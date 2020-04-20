package P2_SurpriseApp;

import com.sun.source.util.SourcePositions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
    private IBag container;
    private int waitTime;

    // constructor
    public AbstractGiveSurprises(String type, int waitTime){
        this.container = new BagFactory().makeBag(type);
        if(waitTime < 0){
            this.waitTime = 0;
        } else {
            this.waitTime = waitTime;
        }
    }

    public IBag getContainer() {
        return container;
    }

    // functionality
    public void put(ISurprise newSurprise){
        this.container.put(newSurprise);
    }

    public void put(IBag surprises){
        this.container.put(surprises);
    }

    public void give(){
        if(!this.container.isEmpty()){
            this.container.takeOut().enjoy();
            giveWithPassion();
        } else {
            System.out.println("The bag is empty.");
        }

    }

    public void giveAll(){
/*        ArrayList<ISurprise> giveSurprises = new ArrayList<>();*/
        while(!this.container.isEmpty()){
            this.container.takeOut().enjoy();
            giveWithPassion();
            try {
                TimeUnit.SECONDS.sleep(this.waitTime); // number of seconds to sleep
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public boolean isEmpty(){
        return this.container.isEmpty();
    }

    abstract void giveWithPassion();
}
