package Structure.Tree;

import Structure.Node;

public class TreeNode extends Node {
    TreeNode childNode;
    TreeNode siblingNode;

    public TreeNode() {
        super.SetData(null);
    }
    public TreeNode(Object data) {
        super.SetData(data);
    }
}