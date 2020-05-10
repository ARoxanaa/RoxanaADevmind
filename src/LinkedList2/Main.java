package LinkedList2;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args){
       /* OrderedList<Town> orderedTowns = new OrderedList<>();
        orderedTowns.addInOrderedList(new Town("Arad",150));
        orderedTowns.addInOrderedList(new Town("Timisoara",100));

        System.out.println(orderedTowns);

        orderedTowns.addInOrderedList(new Town("Bucuresti",0));
        orderedTowns.addInOrderedList(new Town("Ploiesti",30));

        System.out.println(orderedTowns);*/

        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(1);
        intList.add(1);
        intList.add(2);
        intList.add(2);
        intList.add(2);
        intList.add(10);
        for (Integer value : intList) {
            System.out.println("Current number is: " + value);
        }
        System.out.println();
        //RemoveDuplicates.removeDuplicates1(intList);
        RemoveDuplicates.removeDuplicates2(intList);
        for (Integer integer : intList) {
            System.out.println("Current number is: " + integer);
        }
    }
}
