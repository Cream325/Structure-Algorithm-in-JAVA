package Structure.Tree.BinaryTree.BalancedTree;

public class RedBlackTree extends RBTNode {
    private RBTNode root;
    public RedBlackTree(Object rootData) {
        root = new RBTNode(rootData);
    }

    public RBTNode GetRoot() { return root; }


    /** *Red-Black 트리 - 삽입 연산 */
    public RBTNode Insert(Object newData) {
        return Insert(new RBTNode(newData));
    }

    public RBTNode Insert(RBTNode newNode) {
        RBTNode minNode = root;
        RBTNode parent = null;
        newNode.SetColor(RBTColor.RED);

        while(minNode != null) {
            parent = minNode;
            if((Integer)newNode.GetData() < (Integer)minNode.GetData()) minNode = minNode.leftNode;
            else if((Integer)newNode.GetData() > (Integer)minNode.GetData()) minNode = minNode.rightNode;
        }

        if((Integer)newNode.GetData() < (Integer)parent.GetData()) parent.leftNode = newNode;
        else if((Integer)newNode.GetData() > (Integer)parent.GetData()) parent.rightNode = newNode;
        newNode.parentNode = parent;

        ReBuildInsert(newNode);

        return newNode;
    }
    private void ReBuildInsert(RBTNode newNode) {
        RBTNode parent = newNode.parentNode;

        if(parent == null) return;
        if(parent.GetColor() == RBTColor.BLACK) return;

        RBTNode grandParentNode = parent.parentNode;

        if(grandParentNode == null) {
            parent.SetColor(RBTColor.BLACK);
            return;
        }

        RBTNode uncleNode = GetUncleNode(parent);

        if(uncleNode != null && uncleNode.GetColor() == RBTColor.RED) {
            parent.SetColor(RBTColor.BLACK);
            grandParentNode.SetColor(RBTColor.RED);
            uncleNode.SetColor(RBTColor.BLACK);

            ReBuildInsert(grandParentNode);
        }
        else if(parent == grandParentNode.leftNode) {
            if(newNode == parent.rightNode) {
                RotateLeft(parent);
                parent = newNode;
            }

            RotateRight(grandParentNode);

            parent.SetColor(RBTColor.BLACK);
            grandParentNode.SetColor(RBTColor.RED);
        }
        else if(parent == grandParentNode.rightNode) {
            if(newNode == parent.leftNode) {
                RotateRight(parent);
                parent = newNode;
            }

            RotateLeft(grandParentNode);

            parent.SetColor(RBTColor.BLACK);
            grandParentNode.SetColor(RBTColor.RED);
        }
    }
    private RBTNode GetUncleNode(RBTNode parent) {
        RBTNode grandParentNode = parent.parentNode;

        if(grandParentNode.leftNode == parent) return grandParentNode.rightNode;
        else if(grandParentNode.rightNode == parent) return grandParentNode.leftNode;

        return null;
    }



    /** *Red-Black 트리 - 검색 연산 */
    public RBTNode Search(Object targetData) {
        RBTNode searchedNode = root;

        while(searchedNode != null) {
            if(targetData == searchedNode.GetData()) return searchedNode;
            else if((Integer)targetData < (Integer)searchedNode.GetData()) searchedNode = searchedNode.leftNode;
            else if((Integer)targetData > (Integer)searchedNode.GetData()) searchedNode = searchedNode.rightNode;
        }

        return null;
    }



    /** *Red-Black 트리 - 삭제 연산 */
    public RBTNode Delete(Object targetData) {
        RBTNode removedNode = root;
        RBTNode movedUpNode = null;
        RBTColor deletedNodeColor = null;

        while(removedNode != null && removedNode.GetData() != targetData) {
            if((Integer)targetData < (Integer)removedNode.GetData()) removedNode = removedNode.leftNode;
            else if((Integer)targetData > (Integer)removedNode.GetData()) removedNode = removedNode.rightNode;
        }

        if(removedNode == null) return null;

        if(removedNode.leftNode == null || removedNode.rightNode == null) {
            movedUpNode = DeleteMinNode(removedNode);
            deletedNodeColor = removedNode.GetColor();
        }
        else {
            RBTNode successor = GetMinNode(removedNode.rightNode);

            removedNode.SetData(successor.GetData());
            movedUpNode = DeleteMinNode(successor);
            deletedNodeColor = successor.GetColor();
        }

        if(deletedNodeColor == RBTColor.BLACK) {
            RebuildDelete(movedUpNode);

            if(movedUpNode.getClass() == NilNode.class) {
                ReplaceNodes(movedUpNode.parentNode, movedUpNode, null);
            }
        }

        return removedNode;
    }
    private void RebuildDelete(RBTNode node) {
        if(node == root) return;

        RBTNode sibling = GetSibling(node);

        if(sibling.GetColor() == RBTColor.RED) {
            sibling.SetColor(RBTColor.BLACK);
            node.parentNode.SetColor(RBTColor.RED);

            if(node == node.parentNode.leftNode) RotateLeft(node.parentNode);
            else if(node == node.parentNode.rightNode) RotateRight(node.parentNode);

            sibling = GetSibling(node);
        }

        if(IsBlack(sibling.leftNode) && IsBlack(sibling.rightNode)) {
            sibling.SetColor(RBTColor.RED);

            if(node.parentNode.GetColor() == RBTColor.RED) node.parentNode.SetColor(RBTColor.BLACK);
            else RebuildDelete(node.parentNode);
        }

        else {
            boolean nodeIsLeftChild = (node == node.parentNode.leftNode);

            if(nodeIsLeftChild && IsBlack(sibling.rightNode)) {
                sibling.leftNode.SetColor(RBTColor.BLACK);
                sibling.SetColor(RBTColor.RED);
                RotateRight(sibling);
                sibling = node.parentNode.rightNode;
            }
            else if(!nodeIsLeftChild && IsBlack(sibling.leftNode)) {
                sibling.rightNode.SetColor(RBTColor.BLACK);
                sibling.SetColor(RBTColor.RED);
                RotateLeft(sibling);
                sibling = node.parentNode.leftNode;
            }

            sibling.SetColor(node.parentNode.GetColor());
            node.parentNode.SetColor(RBTColor.BLACK);
            if(nodeIsLeftChild) {
                sibling.rightNode.SetColor(RBTColor.BLACK);
                RotateLeft(node.parentNode);
            }
            else {
                sibling.leftNode.SetColor(RBTColor.BLACK);
                RotateRight(node.parentNode);
            }
        }
    }
    private RBTNode GetSibling(RBTNode node) {
        RBTNode parent = node.parentNode;

        if(node == parent.leftNode) return parent.rightNode;
        else if(node == parent.rightNode) return parent.leftNode;

        return null;
    }
    private boolean IsBlack(RBTNode node) { return (node == null || node.GetColor() == RBTColor.BLACK); }
    private RBTNode DeleteMinNode(RBTNode node) {
        if(node.leftNode != null) {
            ReplaceNodes(node.parentNode, node, node.leftNode);
            return node.leftNode;
        }
        else if(node.rightNode != null) {
            ReplaceNodes(node.parentNode, node, node.rightNode);
            return node.rightNode;
        }
        else {
            RBTNode newChild = (node.GetColor() == RBTColor.BLACK ? new NilNode() : null);
            ReplaceNodes(node.parentNode, node, newChild);
            return newChild;
        }
    }
    private RBTNode GetMinNode(RBTNode node) {
        while(node.leftNode != null) node = node.leftNode;
        return node;
    }



    /** *Red-Black 트리 - 회전 연산(좌회전) */
    public void RotateLeft(RBTNode node) {
        RBTNode parent = node.parentNode;
        RBTNode rightChild = node.rightNode;

        node.rightNode = rightChild.leftNode;
        if(rightChild.leftNode != null) rightChild.leftNode.parentNode = node;

        rightChild.leftNode = node;
        node.parentNode = rightChild;

        ReplaceNodes(parent, node, rightChild);
    }

    /** *Red-Black 트리 - 회전 연산(우회전) */
    public void RotateRight(RBTNode node) {
        RBTNode parent = node.parentNode;
        RBTNode leftChild = node.leftNode;

        node.leftNode = leftChild.rightNode;
        if(leftChild.rightNode != null) leftChild.rightNode.parentNode = node;

        leftChild.rightNode = node;
        node.parentNode = leftChild;

        ReplaceNodes(parent, node, leftChild);
    }
    private void ReplaceNodes(RBTNode parent, RBTNode oldChild, RBTNode newChild) {
        if(parent == null) root = newChild;
        else if(parent.leftNode == oldChild) parent.leftNode = newChild;
        else if(parent.rightNode == oldChild) parent.rightNode = newChild;

        if(newChild != null) newChild.parentNode = parent;
    }



    /** *Red-Black 트리 - 출력 연산 */
    public void Traversal() {
        int depth = 0;
        int blackCount = 0;
        Traversal(root, depth, blackCount);
    }

    private void Traversal(RBTNode node, int depth, int blackCount) {
        char ch = 'X';
        Object parentNodeData = null;
        String printedLine;

        if(node == null) return;
        if(node.GetColor() == RBTColor.BLACK) blackCount++;
        if(node.parentNode != null) {
            parentNodeData = node.parentNode.GetData();
            if(node.parentNode.leftNode == node) ch = 'L';
            else ch = 'R';
        }

        if(node.leftNode == null && node.rightNode == null) printedLine = "--------- " + (blackCount + 1);
        else printedLine = "";

        for(int i = 0; i < depth; i++) System.out.print(" ");

        System.out.println(node.GetData() + " " + ((node.GetColor() == RBTColor.RED ? "RED" : "BLACK")) + " [" + ch + " " + parentNodeData + "] " + printedLine);

        Traversal(node.leftNode, depth+1, blackCount);
        Traversal(node.rightNode, depth+1, blackCount);
    }
}