class Node {
    String val;
    Node prev;
    Node next;

    Node(String val) {
        this.val = val;
    }
}

class Solution {
    public int evalRPN(String[] tokens) {

        // Build doubly linked list
        Node head = new Node(tokens[0]);
        Node curr = head;

        for (int i = 1; i < tokens.length; i++) {
            Node node = new Node(tokens[i]);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }

        curr = head;

        while (curr != null) {

            if ("+-*/".contains(curr.val)) {

                Node left = curr.prev.prev;
                Node right = curr.prev;

                int l = Integer.parseInt(left.val);
                int r = Integer.parseInt(right.val);

                int res = 0;

                switch (curr.val) {
                    case "+":
                        res = l + r;
                        break;
                    case "-":
                        res = l - r;
                        break;
                    case "*":
                        res = l * r;
                        break;
                    case "/":
                        res = l / r;
                        break;
                }

                // Store result in operator node
                curr.val = String.valueOf(res);

                // Remove two operand nodes
                Node beforeLeft = left.prev;

                curr.prev = beforeLeft;

                if (beforeLeft != null) {
                    beforeLeft.next = curr;
                } else {
                    head = curr;
                }

                // Continue from previous if possible
                if (curr.prev != null) {
                    curr = curr.prev;
                } else {
                    curr = head;
                }
            } else {
                curr = curr.next;
            }
        }

        return Integer.parseInt(head.val);
    }
}