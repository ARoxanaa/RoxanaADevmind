package ArrayList;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListEx0 {
    public static int containsNames(ArrayList<String> names, String find){
        int counter = 0;
        for(int i = 0; i < names.size(); i++){
            if(names.get(i).startsWith(find)){
                counter ++;
            }
        }
        return counter;
    }

    private static ArrayList<String> countMaxFreq(ArrayList<String> names){
        int counter = 0;
        int localCounter = 0;
        ArrayList<String> maxFreq = new ArrayList<>();
        for (int i = 0; i < names.size(); i++){
            localCounter = 0;
            for (int j = 0; j < names.size(); j++){
                if(names.get(i).equals(names.get(j))){
                    localCounter++;
                }
            }
            if(localCounter > counter){
                maxFreq.clear();
                counter = localCounter;
                maxFreq.add(names.get(i));
            }
            if(localCounter == counter && !maxFreq.contains(names.get(i))){
                maxFreq.add(names.get(i));
            }
        }
        return maxFreq;
    }


    public static void main (String []args){
        ArrayList<String> inviteList =
                new ArrayList<>(Arrays.asList("John", "Lucy", "Anna", "Kelly", "Dean", "Lucy", "Dan", "Daniel","Dan"));
        inviteList.add(3,"John");
        inviteList.add("Alyssa");
        /* System.out.println(inviteList.size());
        System.out.println(inviteList.contains("Dan"));
        System.out.println(inviteList.get(4));
        System.out.println(inviteList.indexOf("John"));
        System.out.println(inviteList.lastIndexOf("John"));
        System.out.println(inviteList.remove("John"));
        System.out.println(inviteList.size());
        System.out.println(inviteList.indexOf("John"));
        System.out.println(inviteList.remove(2));
        inviteList.clear();
        inviteList.add("John");
        inviteList.add("Dan");
        inviteList.add("Daniel");
        inviteList.add("Johnson");
        System.out.println(containsNames(inviteList,"John"));
        inviteList.set(2,"Johnny");
        System.out.println(containsNames(inviteList,"John"));
        inviteList.clone(); */
        ArrayList<String> maxFreq = new ArrayList<>(countMaxFreq(inviteList));
        for(int i = 0; i < maxFreq.size(); i++){
            System.out.println(maxFreq.get(i));
        }

    }

}
