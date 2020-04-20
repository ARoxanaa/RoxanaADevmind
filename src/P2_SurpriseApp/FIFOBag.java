package P2_SurpriseApp;

import java.util.ArrayList;

public class FIFOBag implements IBag {
    private ArrayList<ISurprise> fifoSurpriseBag;

    //constructor
    public FIFOBag(){
        this.fifoSurpriseBag = new ArrayList<>();
    }

    @Override
    public void put(ISurprise newSurprise) {
        this.fifoSurpriseBag.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()){
            this.fifoSurpriseBag.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(!this.isEmpty()){
            ISurprise surpriseTakenOut = this.fifoSurpriseBag.get(0);
            this.fifoSurpriseBag.remove(0);
            return surpriseTakenOut;
        }
        System.out.println("The fifo surprise bag is empty!");
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.fifoSurpriseBag.isEmpty();
    }

    @Override
    public int size() {
        return this.fifoSurpriseBag.size();
    }
}
