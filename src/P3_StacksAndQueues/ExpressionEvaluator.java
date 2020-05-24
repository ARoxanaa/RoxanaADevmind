package P3_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ExpressionEvaluator {
    private static final HashMap<String, Integer> precedenceTable = new HashMap<>(5){{
        put("+", 11);
        put("-", 11);
        put("*", 12);
        put("/", 12);
        put("^", 13);
    }};

    private static final HashMap<String, String> associationTable = new HashMap<>(5){{
        put("+", "left");
        put("-", "left");
        put("*", "left");
        put("/", "left");
        put("^", "right");
    }};

    private static boolean isDigit(String strNum){
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public static String convertToPostfixed(String toConvert){
        Deque<String> operators = new ArrayDeque<>();
        String[] strConverted = toConvert.split(" ");
        String[] postfixedArr = new String[strConverted.length];
        int counter = 0;
        for (String s : strConverted) { // 1.1
            if (isDigit(s)) { // 1.2
                postfixedArr[counter] = s; // 1.2.1
                counter++;
            }

            if (precedenceTable.containsKey(s)) { // 1.3
                while (operators.peekLast() != null && !operators.peekLast().equals("(") // 1.3.1
                        && (precedenceTable.get(s) < precedenceTable.get(operators.peekLast())
                        || precedenceTable.get(s).equals(precedenceTable.get(operators.peekLast()))
                        && associationTable.get(operators.peekLast()).equals("left"))) {
                    postfixedArr[counter] = operators.removeLast(); // 1.3.1.1
                    counter++;
                }
                operators.addLast(s); // 1.3.2
            }

            if (s.equals("(")) { // 1.4
                operators.addLast(s); // 1.4.1
            }

            if (s.equals(")")) { // 1.5
                while (operators.peekLast() != null && !operators.peekLast().equals("(")) { // 1.5.1
                    postfixedArr[counter] = (operators.removeLast()); // 1.5.1.1
                    counter++;
                }
                if (operators.isEmpty()) { // 1.5.2
                    return "The expression had wrong parentheses. Please try again."; // 1.5.2.1
                }
                operators.removeLast(); // 1.5.3
            }
        }
        while (!operators.isEmpty()){ // 2
            if(operators.peekLast().equals("(")){ // 2.2
               return "The expression had wrong parentheses. Please try again."; // 2.2.1
            }
            postfixedArr[counter] = operators.removeLast(); // 2.1
            counter++;
        }
        StringBuilder postfixed = new StringBuilder();
        for(int i = 0; i < postfixedArr.length && postfixedArr[i] != null; i++){
            postfixed.append(postfixedArr[i]).append(" ");
        }
        return postfixed.toString();
    }

    public static String evaluateExpression(String toEvaluate){
        Deque<Integer> numbers = new ArrayDeque<>();
        String[] strConverted = toEvaluate.split(" ");
        Integer op1;
        Integer op2;
        int result;
        for (String s : strConverted) { // 1
            if (isDigit(s)) { // 1.2
                numbers.addLast(Integer.parseInt(s)); // 1.2.1
            }

            if (precedenceTable.containsKey(s)) { // 1.3
                op1 = numbers.removeLast(); // 1.3.1
                op2 = numbers.removeLast(); // 1.3.2
                if (op1 == null || op2 == null) { // 1.3.3
                    return "Postfixed expression is invalid. Please try again"; // 1.3.3.1
                }

                switch (s) {
                    case "+":
                        result = op2 + op1;
                        break;
                    case "-":
                        result = op2 - op1;
                        break;
                    case "*":
                        result = op2 * op1;
                        break;
                    case "/":
                        result = op2 / op1;
                        break;
                    case "^":
                        result = (int) Math.pow(op2, op1);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s);
                }
                numbers.addLast(result);
            }
        }
        result = numbers.removeLast();
        if(!numbers.isEmpty()){
            return "Postfixed expression is invalid. Please try again";
        }


        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String toConvert = "( ( 10 * ( 6 / ( ( 9 + 3 ) * -11 ) ) ) + 17 ) + 5";
        String converted = convertToPostfixed(toConvert);
        System.out.println(convertToPostfixed(toConvert));
        System.out.println(evaluateExpression(converted));
    }
}
