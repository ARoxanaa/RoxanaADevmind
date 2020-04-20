package P2_SurpriseApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FortuneCookie implements ISurprise {
    private static final ArrayList<String> quotes = new ArrayList<>(
            Arrays.asList("The greatest glory in living lies not in never falling, but in rising every time we fall.\" -Nelson Mandela",
                   "\"The way to get started is to quit talking and begin doing.\" -Walt Disney",
                    "\"Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.\" -Steve Jobs",
                    "\"If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough.\" -Oprah Winfrey",
                    "\"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.\" -James Cameron",
                    "\"Life is what happens when you're busy making other plans.\" -John Lennon",
                    "\"Spread love everywhere you go. Let no one ever come to you without leaving happier.\" -Mother Teresa",
                    "\"When you reach the end of your rope, tie a knot in it and hang on.\" -Franklin D. Roosevelt",
                    "\"Always remember that you are absolutely unique. Just like everyone else.\" -Margaret Mead",
                    "\"Don't judge each day by the harvest you reap but by the seeds that you plant.\" -Robert Louis Stevenson",
                    "\"The future belongs to those who believe in the beauty of their dreams.\" -Eleanor Roosevelt",
                    "\"Tell me and I forget. Teach me and I remember. Involve me and I learn.\" -Benjamin Franklin",
                    "\"The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.\" -Helen Keller",
                    "\"It is during our darkest moments that we must focus to see the light.\" -Aristotle",
                    "\"Whoever is happy will make others happy too.\" -Anne Frank",
                    "\"Cine face bine lumea te vede\" -Gica Hagi",
                    "\"La anul vine un an nou si alt an\" -Gica Hagi",
                    "\"Nu pe vorbe, pe fapte, adica trebuie sa stii ce sa vorbesti\" -Gica Hagi",
                    "\"Copii, mergeti la scoala, ca si scoala e buna la ceva!\" -Gica Hagi",
                    " \"Important e punctele\" -Gica Hagi"));
    private final String quote;
    private static final Random random = new Random();

    // constructor
    private FortuneCookie(String quote){
        this.quote = quote;
    }

    @Override
    public void enjoy() {
        // we call the method that generates a random number and returns the corresponding quote from the array
        System.out.println(this.toString());
    }

    public static FortuneCookie generate(){
        int n = random.nextInt(20);
        return new FortuneCookie(quotes.get(n));
    }

    @Override
    public String toString(){
        return "Your quote is: " + this.quote;
    }

}
