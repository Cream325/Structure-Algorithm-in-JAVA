package Structure.Tree.BinaryTree;

public class BinarySearchTree extends BinaryTreeNode {
    BinaryTreeNode root;

    public BinarySearchTree(Object rootData) {
        root = new BinaryTreeNode(rootData);
    }

    public BinaryTreeNode GetRoot() { return root; }



    /** *이진 탐색 트리 - 삽입 연산 */
    public BinaryTreeNode Insert(Object newData) {
        return Insert(new BinaryTreeNode(newData));
    }

    public BinaryTreeNode Insert(BinaryTreeNode newNode) {
        BinaryTreeNode minNode = root;
        BinaryTreeNode parent = null;

        while(minNode != null) {
            parent = minNode;
            if((Integer)newNode.GetData() < (Integer)minNode.GetData()) minNode = minNode.leftNode;
            else if((Integer)newNode.GetData() > (Integer)minNode.GetData()) minNode = minNode.rightNode;
        }

        if((Integer)newNode.GetData() < (Integer)parent.GetData()) parent.leftNode = newNode;
        else if((Integer)newNode.GetData() > (Integer)parent.GetData()) parent.rightNode = newNode;

        newNode.parentNode = parent;

        return newNode;
    }

    

    /** *이진 탐색 트리 - 검색 연산 */
    public BinaryTreeNode searchTree(Object targetData) {
        BinaryTreeNode searchedNode = root;

        while(searchedNode != null) {
            if(targetData == searchedNode.GetData()) return searchedNode;
            else if((Integer)targetData < (Integer)searchedNode.GetData()) searchedNode = searchedNode.leftNode;
            else if((Integer)targetData > (Integer)searchedNode.GetData()) searchedNode = searchedNode.rightNode;
        }

        return null;
    }



    /** *이진 탐색 트리 - 삭제 연산 */
    public BinaryTreeNode Delete(Object targetData) {
        BinaryTreeNode removedNode = root;
        BinaryTreeNode movedUpNode = null;

        while(removedNode != null && removedNode.GetData() != targetData) {
            if((Integer)targetData < (Integer)removedNode.GetData()) removedNode = removedNode.leftNode;
            else if((Integer)targetData > (Integer)removedNode.GetData()) removedNode = removedNode.rightNode;
        }

        if(removedNode == null) return null;

        if(removedNode.leftNode == null || removedNode.rightNode == null) {
            movedUpNode = DeleteMinNode(removedNode);
        }
        else {
            BinaryTreeNode successor = GetMinNode(removedNode.rightNode);

            removedNode.SetData(successor.GetData());
            movedUpNode = DeleteMinNode(successor);
        }

        return removedNode;
    }
    private BinaryTreeNode DeleteMinNode(BinaryTreeNode node) {
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
    private BinaryTreeNode GetMinNode(BinaryTreeNode node) {
        while(node.leftNode != null) node = node.leftNode;
        return node;
    }
    private void ReplaceNodes(BinaryTreeNode parent, BinaryTreeNode oldChild, BinaryTreeNode newChild) {
        if(parent == null) root = newChild;
        else if(parent.leftNode == oldChild) parent.leftNode = newChild;
        else if(parent.rightNode == oldChild) parent.rightNode = newChild;

        if(newChild != null) newChild.parentNode = parent;
    }



    /** *이진 탐색 트리 - 출력 연산 */
    public void Traversal() {
        Traversal(root);
    }
    private void Traversal(BinaryTreeNode node) {
        if(node.leftNode != null) Traversal(node.leftNode);
        System.out.print(node.GetData() + " ");
        if(node.rightNode != null) Traversal(node.rightNode);
    }
}