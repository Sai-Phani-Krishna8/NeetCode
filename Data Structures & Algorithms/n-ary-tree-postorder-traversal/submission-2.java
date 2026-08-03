/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Pair<Node, Boolean>> st = new Stack<>();
        st.push(new Pair<>(root, false));

        while(!st.isEmpty()) {
            Pair<Node, Boolean> p = st.pop();
            Node node = p.getKey();
            boolean visited = p.getValue();

            if(visited) {
                res.add(node.val);
            } else {
                st.push(new Pair<>(node, true));
                for(int i=node.children.size()-1; i>=0; i--) {
                    st.push(new Pair<>(node.children.get(i), false));
                }
            }
        }
        
        return res;
    }
}