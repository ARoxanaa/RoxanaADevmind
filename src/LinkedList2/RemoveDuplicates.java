package LinkedList2;

import java.util.LinkedList;
import java.util.ListIterator;

public class RemoveDuplicates {
    public static void removeDuplicates1(LinkedList<Integer> list){
        ListIterator<Integer> listIt = list.listIterator();
        Integer current = listIt.next();
        while(listIt.hasNext()){
            Integer next = listIt.next();
            if(current.equals(next)){
                listIt.remove();
            }
            current = next;
        }
    }

    public static void removeDuplicates2(LinkedList<Integer> list){
        ListIterator<Integer> listIt = list.listIterator();
        Integer current = listIt.next();
        int counter = 0;
        while (listIt.hasNext()){
            counter = 0;
            Integer next = listIt.next();
            while(current.equals(next)){
                listIt.remove();
                next = listIt.next();
                counter++;
            }
            if(counter > 0){
                listIt.previous();
                listIt.previous();
                listIt.remove();
                listIt.next();
            }
            current = next;
        }
    }
}
