package P2_SurpriseApp;

import java.util.ArrayList;

public class LIFOBag implements IBag {
    private ArrayList<ISurprise> lifoSurpriseBag;

    //constructor
    public LIFOBag(){
        this.lifoSurpriseBag = new ArrayList<>();
    }
    @Override
    public void put(ISurprise newSurprise) {
        this.lifoSurpriseBag.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()){
            this.lifoSurpriseBag.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(!this.isEmpty()){
            ISurprise surpriseTakenOut = this.lifoSurpriseBag.get(size() - 1);
            this.lifoSurpriseBag.remove(size()-1);
            return surpriseTakenOut;
        }
        System.out.println("The lifo bag is empty!");
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.lifoSurpriseBag.isEmpty();
    }

    @Override
    public int size() {
        return this.lifoSurpriseBag.size();
    }
}
