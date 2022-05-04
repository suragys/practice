package leet;

import javafx.beans.property.ListPropertyBase;

public class _21MergeTwoSortedLists {

    //      Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
            compare the l1.val to l2.val
            whichever is less add that to return list and then move the pointer of that list only and repeat comparision till the end of either of the node and then just add the rest of the node to return list
        */
        ListNode psuedoHead = new ListNode(-1);
        ListNode curr = psuedoHead;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                // System.out.println(curl2.val);
                curr.next = l2;
                l2 = l2.next;
            } else {
                // System.out.println(curl1.val);
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            // System.out.println(curl1.val);
            curr.next = l1;
        }

        if (l2 != null) {
            // System.out.println(curl2.val);
            curr.next = l2;
        }
        return psuedoHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l4;
        l2.next = l3;
        l3.next = l5;
        l5.next = l6;

        _21MergeTwoSortedLists mergeTwoSortedLists = new _21MergeTwoSortedLists();

        mergeTwoSortedLists.mergeTwoLists(l1,l2);


    }

}
