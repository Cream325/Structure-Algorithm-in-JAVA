package Structure.Tree;

public class LCRSTree extends TreeNode {
    TreeNode root;

    public LCRSTree(Object rootData) {
        root = new TreeNode(rootData);
    }

    public TreeNode GetRoot() { return root; }



    /** *LCRS 트리 - 삽입 연산 */
    public void Insert(TreeNode parent, TreeNode newNode) {
        if(parent.childNode == null) parent.childNode = newNode;
        else {
            TreeNode tempNode = parent.childNode;
            while (tempNode.siblingNode != null) tempNode = tempNode.siblingNode;

            tempNode.siblingNode = newNode;
        }
    }



    /** *LCRS 트리 - 삭제 연산 */
    public void Delete() { Delete(root); }

    private void Delete(TreeNode node) {
        if(node.childNode != null) {
            Delete(node.childNode);
        }

        if(node.siblingNode != null) {
            Delete(node.siblingNode);
        }

        node.childNode = null;
        node.siblingNode = null;

        System.out.println("Deleted: " + node.GetData());
        node = null;
    }



    /** *LCRS 트리 - 출력 연산 */
    public void Traversal() {
        int depth = 0;
        Traversal(root, depth);
    }

    private void Traversal(TreeNode node, int depth) {
        for(int i = 0; i < depth-1; i++) {
            System.out.print("   ");
        }

        if(depth > 0) {
            System.out.print("+--");
        }

        System.out.println(node.GetData());

        if(node.childNode != null) {
            Traversal(node.childNode,depth+1);
        }
        if(node.siblingNode != null) {
            Traversal(node.siblingNode, depth);
        }
    }
}