package LinkedList2;

import Quiz12.BigNumbers;

import java.util.LinkedList;

public class Ex3BigNumbers {
    public static LinkedList<Integer> sum(LinkedList<Integer> op1, LinkedList<Integer> op2){
        LinkedList<Integer> sum = new LinkedList<>();
        int remainder = 0;
        int sumVar = 0;
        while(op1.size() > 0 && op2.size() > 0){
            sumVar = op1.getLast() + op2.getLast() + remainder;
            if(sumVar > 9){
                sum.addFirst(sumVar % 10);
                remainder = sumVar / 10;
            } else {
                sum.addFirst(sumVar);
                remainder = 0;
            }
            op1.removeLast();
            op2.removeLast();
        }
        while(op1.size() > 0){
            sumVar = op1.getLast() + remainder;
            if(sumVar > 9){
                sum.addFirst(sumVar % 10);
                remainder = sumVar / 10;
            } else {
                sum.addFirst(sumVar);
                remainder = 0;
            }
            op1.removeLast();
        }
        while(op2.size() > 0){
            sumVar = op2.getLast() + remainder;
            if(sumVar > 9){
                sum.addFirst(sumVar % 10);
                remainder = sumVar / 10;
            } else {
                sum.addFirst(sumVar);
                remainder = 0;
            }
            op2.removeLast();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Checking input...");
        LinkedList<Integer> op1 = new LinkedList();
        op1.addLast(2);
        op1.addLast(1);
        op1.addLast(7);
        op1.addLast(8);

        LinkedList<Integer> op2 = new LinkedList();
        op2.addLast(5);
        op2.addLast(9);
        op2.addLast(6);

        Ex3BigNumbers bn = new Ex3BigNumbers();
        LinkedList<Integer> rez = new LinkedList<>(sum(op1,op2));
        LinkedList<Integer> correct = new LinkedList<>();
        correct.addLast(2);
        correct.addLast(7);
        correct.addLast(7);
        correct.addLast(4);

        System.out.println(noToString(op1) + " + " + noToString(op2) +
                " = " + noToString(rez) + " C: " + noToString(correct));
    }

    private static String noToString(LinkedList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
