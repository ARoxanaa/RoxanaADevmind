package LinkedList;

import org.w3c.dom.Node;

public class MergeList {
    private static ListNode makeList(int[] values) {
        ListNode head = new ListNode();
        ListNode it = head;
        for (int el : values) {
            ListNode newNode = new ListNode(el);
            it.next = newNode;
            it = it.next;
        }
        return head.next;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }

        ListNode head = new ListNode();
        ListNode newList = head;
        ListNode it1 = l1;
        ListNode it2 = l2;
        while (it1 != null && it2 != null) {
            if(it1.val < it2.val){
                ListNode newNode = new ListNode(it1.val);
                newList.next = newNode;
                it1 = it1.next;
                newList = newList.next;
            } else if (it2.val < it1.val) {
                ListNode newNode = new ListNode(it2.val);
                newList.next = newNode;
                it2 = it2.next;
                newList = newList.next;
            } else {
                ListNode newNode = new ListNode(it1.val);
                newList.next = newNode;
                it1 = it1.next;
                newList = newList.next;
                ListNode newNode2 = new ListNode(it2.val);
                newList.next = newNode2;
                it2 = it2.next;
                newList = newList.next;
            }
        }

        while (it1 != null) {
            ListNode newNode = new ListNode(it1.val);
            newList.next = newNode;
            it1 = it1.next;
            newList = newList.next;
        }

        while (it2 != null) {
            ListNode newNode = new ListNode(it2.val);
            newList.next = newNode;
            it2 = it2.next;
            newList = newList.next;
        }
        return head.next;
    }

    public static void main (String[] args){
        int[] values = {1};
        ListNode list = makeList(values);
        int[] values2 = {2};
        ListNode list2 = makeList(values2);
        mergeTwoLists(list,list2);
    }
}
