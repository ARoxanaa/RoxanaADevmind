package LinkedList;

import java.util.List;

public class LC62RotateList {
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

    public static ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode it = head;
        while(it.next != null){
            len++;
            it = it.next;
        }

        int noIterations = k <= len ? k : len + k % len;
        if(noIterations == len){
            return head;
        }
        for(int i = 0; i < noIterations; i++){
            while(it.next != null){
                if(it.next.next == null){
                    it.next.next = head;
                    head = it.next;
                    it.next = null;
                } else {
                    it = it.next;
                }
            }
            it = head;
        }
        return head;
    }


    public static void main (String[] args){
        int[] values = {1,2,3};
        ListNode list = makeList(values);
        rotateRight(list,2000000000);
     }
}
