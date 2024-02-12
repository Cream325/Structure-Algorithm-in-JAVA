package Structure.Tree.BinaryTree.BalancedTree;

import Structure.Tree.BinaryTree.BinaryTreeNode;

public class AVLNode extends BinaryTreeNode {
    int height;
    AVLNode parentNode;
    AVLNode leftNode;
    AVLNode rightNode;

    public AVLNode() {
        super();
        this.height = -1;
    }

    public AVLNode(Object data) {
        super(data);
        this.height = 0;
    }
}