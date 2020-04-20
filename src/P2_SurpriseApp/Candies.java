package P2_SurpriseApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Candies implements ISurprise {
    private static final ArrayList<String> candyTypes =
            new ArrayList<>(Arrays.asList("chocolate", "jelly","fruit","vanilla"));
    private final String candyType;
    private final int noOfCandies;
    private static final Random random = new Random();

    // constructor
    private Candies(String candyType, int noOfCandies){
        this.candyType = candyType;
        this.noOfCandies = noOfCandies;
    }

    @Override
    public void enjoy() {
        System.out.println(this.toString());
    }

    public static Candies generate(){
        int candyTypeIndex = random.nextInt(4);
        // Below, I've assigned an upper bound, I could've used Math.abs but I didn't want to give out a super long no. of surprises
        int candyNo = random.nextInt(1001);
        return new Candies(candyTypes.get(candyTypeIndex),candyNo);
    }

    @Override
    public String toString(){
        return "You got " + this.noOfCandies + " " + this.candyType + " candies!";
    }
}
