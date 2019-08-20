/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    private StringBuilder serial(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return sb.append("#");
        }

        sb.append(root.val).append(",");
        serial(sb, root.left).append(",");
        serial(sb, root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new ArrayDeque<>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserial(Queue<String> que) {
        String val = que.poll();
        if ("#".equals(val)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserial(que);
        root.right = deserial(que);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));