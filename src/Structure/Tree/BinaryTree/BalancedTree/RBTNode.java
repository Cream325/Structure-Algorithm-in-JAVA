package Structure.Tree.BinaryTree.BalancedTree;

import Structure.Tree.BinaryTree.BinaryTreeNode;

public class RBTNode extends BinaryTreeNode {
    private RBTColor color;
    RBTNode parentNode;
    RBTNode leftNode;
    RBTNode rightNode;

    public RBTNode() {
        super();
        this.color = RBTColor.BLACK;
    }

    public RBTNode(Object data) {
        super(data);
        this.color = RBTColor.RED;
    }

    public void SetColor(RBTColor color) { this.color = color; }
    public RBTColor GetColor() { return this.color; }

    enum RBTColor {
        RED,
        BLACK
    }

    class NilNode extends RBTNode {
        public NilNode() {
            super();
            this.SetColor(RBTColor.BLACK);
        }
    }
}