package leet;

import java.util.HashMap;
import java.util.Map;

public class _138CopyListwithRandomPointer {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
       /*
        create a map of <node, copyNode>

        Iterate the linked list and popupalte the node.
       */

        Map<Node, Node> m = new HashMap<>();

        Node curr = head;
        // populate map
        while (curr != null) {
            Node copy = new Node(curr.val);
            m.put(curr, copy);
            curr = curr.next;
        }
        // Iterate the linked list again now get the nodes from the map and set next and random for each
        curr = head;
        while (curr != null) {
            Node copy = m.get(curr);
            Node next = curr.next;
            Node random = curr.random;

            Node copyNext = m.get(next);
            Node copyRandom = m.get(random);

            copy.next = copyNext;
            copy.random = copyRandom;
            curr = curr.next;
        }
        return m.get(head);
    }
}
