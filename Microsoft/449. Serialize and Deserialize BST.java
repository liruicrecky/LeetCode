/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(root, new StringBuilder()).toString();
    }

    private StringBuilder serial(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return sb.append("#");
        }

        sb.append(node.val).append(",");
        serial(node.left, sb).append(",");
        serial(node.right, sb);

        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new ArrayDeque<>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserial(Queue<String> que) {
        String s = que.poll();
        if (s.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserial(que);
        root.right = deserial(que);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));