package Structure.Tree.BinaryTree;

public class BinaryTree extends BinaryTreeNode {
    BinaryTreeNode root;
    public BinaryTree(Object rootData) { root = new BinaryTreeNode(rootData); }

    public BinaryTreeNode GetRoot() { return root; }



    /** *이진 트리 - 삽입 연산 */
    public void Insert(BinaryTreeNode parent, BinaryTreeNode newNode) {
        if(parent.leftNode == null) parent.leftNode = newNode;
        else parent.rightNode = newNode;
    }



    /** *이진 트리 - 삭제 연산 */
    public void Delete() {
        BinaryTreeNode parentNode = root;

        if(parentNode.leftNode != null) {
            parentNode = parentNode.leftNode;
        }
        if(root.rightNode != null) {
            parentNode = parentNode.rightNode;
        }

        parentNode.leftNode = null;
        parentNode.rightNode = null;

        parentNode = null;
    }



    /** *이진 트리 - 출력 연산(전위 순회) */
    public void printTreePreorder(BinaryTreeNode node) {
        System.out.print(node.GetData() + " ");
        if(node.leftNode != null) printTreePreorder(node.leftNode);
        if(node.rightNode != null) printTreePreorder(node.rightNode);
    }

    /** *이진 트리 - 출력 연산(중위 순회) */
    public void printTreeInorder(BinaryTreeNode node) {
        if(node.leftNode != null) printTreeInorder(node.leftNode);
        System.out.print(node.GetData() + " ");
        if(node.rightNode != null) printTreeInorder(node.rightNode);
    }

    /** *이진 트리 - 출력 연산(후위 순회) */
    public void printTreePostorder(BinaryTreeNode node) {
        if(node.leftNode != null) printTreePostorder(node.leftNode);
        if(node.rightNode != null) printTreePostorder(node.rightNode);
        System.out.print(node.GetData() + " ");
    }
}