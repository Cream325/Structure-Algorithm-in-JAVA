package Structure.Tree.BinaryTree.BalancedTree;

public class AVLTree extends AVLNode {
    public AVLNode root;
    public AVLTree(Object rootData) { root = new AVLNode(rootData); }

    public AVLNode GetRoot() { return root; }


    /** AVL 트리 - 높이 및 균형도 */
    private int GetHeight(AVLNode node) {
        return (node != null ? node.height : -1);
    }
    private void UpdateHeight(AVLNode node) {
        int leftChildHeight = GetHeight(node.leftNode);
        int rightChildHeight = GetHeight(node.rightNode);

        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }
    private int GetbalanceFactor(AVLNode node) {
        return (GetHeight(node.rightNode) - GetHeight(node.leftNode));
    }
    private void Rebalance(AVLNode node) {
        UpdateHeight(node);
        int balanceFactor = GetbalanceFactor(node);

        if(balanceFactor < -1) {
            if(GetbalanceFactor(node.leftNode) > 0) node.leftNode = RotateLeft(node.leftNode);
            node = RotateRight(node);
        }
        else if(balanceFactor > 1) {
            if(GetbalanceFactor(node.rightNode) < 0) node.rightNode = RotateRight(node.rightNode);
            node = RotateLeft(node);
        }

        if(node == root) return;
        else Rebalance(node.parentNode);
    }


    /** *AVL 트리 - 삽입 연산 */
    public AVLNode Insert(Object newData) {
        return Insert(new AVLNode(newData));
    }

    public AVLNode Insert(AVLNode newNode) {
        AVLNode minNode = root;
        AVLNode parent = null;

        while(minNode != null) {
            parent = minNode;
            if((Integer)newNode.GetData() < (Integer)minNode.GetData()) minNode = minNode.leftNode;
            else if((Integer)newNode.GetData() > (Integer)minNode.GetData()) minNode = minNode.rightNode;
        }

        if((Integer)newNode.GetData() < (Integer)parent.GetData()) parent.leftNode = newNode;
        else if((Integer)newNode.GetData() > (Integer)parent.GetData()) parent.rightNode = newNode;
        newNode.parentNode = parent;

        UpdateHeight(newNode);
        Rebalance(newNode);

        return newNode;
    }



    /** *AVL 트리 - 탐색 연산 */
    public AVLNode Search(Object targetData) {
        AVLNode searchedNode = root;

        while(searchedNode != null) {
            if(targetData == searchedNode.GetData()) return searchedNode;
            else if((Integer)targetData < (Integer)searchedNode.GetData()) searchedNode = searchedNode.leftNode;
            else if((Integer)targetData > (Integer)searchedNode.GetData()) searchedNode = searchedNode.rightNode;
        }

        return null;
    }



    /** *AVL 트리 - 삭제 연산 */
    public AVLNode Delete(Object targetData) {
        AVLNode removedNode = root;
        AVLNode movedUpNode = null;

        while(removedNode != null && removedNode.GetData() != targetData) {
            if((Integer)targetData < (Integer)removedNode.GetData()) removedNode = removedNode.leftNode;
            else if((Integer)targetData > (Integer)removedNode.GetData()) removedNode = removedNode.rightNode;
        }

        if(removedNode == null) return null;

        if(removedNode.leftNode == null || removedNode.rightNode == null) {
            movedUpNode = DeleteMinNode(removedNode);
        }
        else {
            AVLNode successor = GetMinNode(removedNode.leftNode);

            removedNode.SetData(successor.GetData());
            movedUpNode = DeleteMinNode(successor);
        }

        GetHeight(removedNode);
        Rebalance(removedNode);

        return removedNode;
    }
    private AVLNode DeleteMinNode(AVLNode node) {
        if(node.leftNode != null) {
            ReplaceNodes(node.parentNode, node, node.leftNode);
            return node.leftNode;
        }
        else if(node.rightNode != null) {
            ReplaceNodes(node.parentNode, node, node.rightNode);
            return node.rightNode;
        }
        else {
            ReplaceNodes(node.parentNode, node, null);
            return null;
        }
    }
    private AVLNode GetMinNode(AVLNode node) {
        while(node.rightNode != null) node = node.rightNode;
        return node;
    }
    private void ReplaceNodes(AVLNode parent, AVLNode oldChild, AVLNode newChild) {
        if(parent == null) root = newChild;
        else if(parent.leftNode == oldChild) parent.leftNode = newChild;
        else if(parent.rightNode == oldChild) parent.rightNode = newChild;

        if(newChild != null) newChild.parentNode = parent;
    }



    /** *AVL 트리 - 회전 연산(좌회전) */
    public AVLNode RotateLeft(AVLNode node) {
        AVLNode parent = node.parentNode;
        AVLNode rightChild = node.rightNode;

        node.rightNode = rightChild.leftNode;
        if(rightChild.leftNode != null) rightChild.leftNode.parentNode = node;

        rightChild.leftNode = node;
        node.parentNode = rightChild;

        ReplaceNodes(parent, node, rightChild);

        UpdateHeight(node);
        UpdateHeight(rightChild);

        return rightChild;
    }

    /** *AVL 트리 - 회전 연산(우회전) */
    public AVLNode RotateRight(AVLNode node) {
        AVLNode parent = node.parentNode;
        AVLNode leftChild = node.leftNode;

        node.leftNode = leftChild.rightNode;
        if(leftChild.rightNode != null) leftChild.rightNode.parentNode = node;

        leftChild.rightNode = node;
        node.parentNode = leftChild;

        ReplaceNodes(parent, node, leftChild);

        UpdateHeight(node);
        UpdateHeight(leftChild);

        return leftChild;
    }



    /** *AVL 트리 - 출력 연산 */
    public void Traversal() {
        int depth = 0;
        Traversal(root, depth);
    }

    private void Traversal(AVLNode node, int depth) {
        char ch = 'X';
        Object parentNodeData = null;

        if(node == null) return;
        if(node.parentNode != null) {
            parentNodeData = node.parentNode.GetData();
            if(node.parentNode.leftNode == node) ch = 'L';
            else ch = 'R';
        }

        for(int i = 0; i < depth; i++) System.out.print(" ");

        System.out.println(node.GetData() + " " + " [" + ch + " " + parentNodeData + " " + GetbalanceFactor(node) + "]");

        Traversal(node.leftNode, depth+1);
        Traversal(node.rightNode, depth+1);
    }
}