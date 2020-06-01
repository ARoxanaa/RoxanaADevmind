package P3_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class RadixSort {
    // creating queues
    private static final Queue<String> zero = new ArrayDeque<>();
    private static final Queue<String> one = new ArrayDeque<>();
    private static final Queue<String> two = new ArrayDeque<>();
    private static final Queue<String> three = new ArrayDeque<>();
    private static final Queue<String> four = new ArrayDeque<>();
    private static final Queue<String> five = new ArrayDeque<>();
    private static final Queue<String> six = new ArrayDeque<>();
    private static final Queue<String> seven = new ArrayDeque<>();
    private static final Queue<String> eight = new ArrayDeque<>();
    private static final Queue<String> nine = new ArrayDeque<>();

    // method that calculates te max length of ArrayList strings
    private static int maxLength(ArrayList<String> numbers){
        int maxLength = 0;
        for (String number : numbers) {
            if (number.length() > maxLength) {
                maxLength = number.length();
            }
        }
        return maxLength;
    }

    // method that adds zeroes to even the numbers
    private static void addZeros(ArrayList<String> numbers, int maxLength){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i).length() < maxLength){
                for(int z = numbers.get(i).length(); z < maxLength; z++){
                    numbers.set(i, "0" + numbers.get(i));
                }
            }
        }
    }

//    public static ArrayList<String> sortAscending(ArrayList<String> numbers) {
//
//    }
//
//    public static ArrayList<String> sortDescending(ArrayList<String> numbers){
//        radixSort(numbers);
//    }
    public static void radixSort(ArrayList<String> numbers, int sort) {
        if(numbers.isEmpty()){
            System.out.println("Please insert numbers.");
        }
        if(sort != 0 && sort != 1){
            System.out.println("Sorting order must be represented by digits 1 or 0");
        } else {
            int max = maxLength(numbers);
            addZeros(numbers,max);

            for(int i = max - 1; i >= 0; i--){
                for(String number : numbers){
                    switch (number.charAt(i)) {
                        case '0':
                            zero.add(number);
                            break;
                        case '1':
                            one.add(number);
                            break;
                        case '2':
                            two.add(number);
                            break;
                        case '3':
                            three.add(number);
                            break;
                        case '4':
                            four.add(number);
                            break;
                        case '5':
                            five.add(number);
                            break;
                        case '6':
                            six.add(number);
                            break;
                        case '7':
                            seven.add(number);
                            break;
                        case '8':
                            eight.add(number);
                            break;
                        case '9':
                            nine.add(number);
                            break;
                    }
                }
                numbers.clear();
                switch (sort){
                    case 0:
                        while (!zero.isEmpty()){
                            numbers.add(zero.remove());
                        }
                        while (!one.isEmpty()){
                            numbers.add(one.remove());
                        }
                        while (!two.isEmpty()) {
                            numbers.add(two.remove());
                        }
                        while (!three.isEmpty()){
                            numbers.add(three.remove());
                        }
                        while (!four.isEmpty()) {
                            numbers.add(four.remove());
                        }
                        while (!five.isEmpty()){
                            numbers.add(five.remove());
                        }
                        while (!six.isEmpty()) {
                            numbers.add(six.remove());
                        }
                        while (!seven.isEmpty()){
                            numbers.add(seven.remove());
                        }
                        while (!eight.isEmpty()) {
                            numbers.add(eight.remove());
                        }
                        while (!nine.isEmpty()) {
                            numbers.add(nine.remove());
                        }
                        break;
                    case 1:
                        while (!nine.isEmpty()){
                            numbers.add(nine.remove());
                        }
                        while (!eight.isEmpty()){
                            numbers.add(eight.remove());
                        }
                        while (!seven.isEmpty()) {
                            numbers.add(seven.remove());
                        }
                        while (!six.isEmpty()){
                            numbers.add(six.remove());
                        }
                        while (!five.isEmpty()) {
                            numbers.add(five.remove());
                        }
                        while (!four.isEmpty()){
                            numbers.add(four.remove());
                        }
                        while (!three.isEmpty()) {
                            numbers.add(three.remove());
                        }
                        while (!two.isEmpty()){
                            numbers.add(two.remove());
                        }
                        while (!one.isEmpty()) {
                            numbers.add(one.remove());
                        }
                        while (!zero.isEmpty()) {
                            numbers.add(zero.remove());
                        }
                        break;
                }
            }
            for (String number : numbers) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("56876", "93838", "25", "0001", "51", "3430",
                                    "8471", "0", "1", "2989", "657", "713"));
        radixSort(numbers,0);
    }
}
