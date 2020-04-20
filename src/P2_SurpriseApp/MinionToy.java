package P2_SurpriseApp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinionToy implements ISurprise {
    private static final ArrayList<String> minionNames =
            new ArrayList<>(Arrays.asList("Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"));
    private final String minionName;
    private static int minionCounter = 0;

    // constructor
    private MinionToy(String minionName){
        this.minionName = minionName;
    }

    @Override
    public void enjoy() {
        System.out.println(this.toString());
    }

    public static MinionToy generate(){
        MinionToy generatedMinion = new MinionToy(minionNames.get(minionCounter));
        if(minionCounter == 5){
            minionCounter = 0;
        } else {
            minionCounter++;
        }
        return generatedMinion;
    }

    public String toString(){
        return "Your toy minion's name is " + this.minionName + "!";
    }
}
