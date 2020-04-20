package P2_SurpriseApp;

import java.util.ArrayList;
import java.util.Random;

public class RandomBag implements IBag {
    private ArrayList<ISurprise> randomSurprisesBag;
    private static Random random = new Random();

    //constructor
    public RandomBag(){
        this.randomSurprisesBag = new ArrayList<>();
    }

    @Override
    public void put(ISurprise newSurprise) {
        this.randomSurprisesBag.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()){
            this.randomSurprisesBag.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(!this.isEmpty()){
            int randomNo = random.nextInt(this.randomSurprisesBag.size());
            ISurprise surpriseTakenOut = this.randomSurprisesBag.get(randomNo);
            this.randomSurprisesBag.remove(randomNo);
            return surpriseTakenOut;
        }
        System.out.println("The random surprises bag is empty!");
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.randomSurprisesBag.isEmpty();
    }

    @Override
    public int size() {
        return this.randomSurprisesBag.size();
    }
}
