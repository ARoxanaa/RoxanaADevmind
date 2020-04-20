package P2_SurpriseApp;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Random;

public final class GatherSurprises {
    private static final Random random = new Random();

    // constructor
    private GatherSurprises(){

    }

    private static ISurprise generateSurprise(int type){
        switch (type){
            case 0:
                return Candies.generate();
            case 1:
                return FortuneCookie.generate();
            case 2:
                return MinionToy.generate();
            default:
                System.out.println("Invalid surprise type.");
                return null;
        }
    }

    public static ISurprise[] gather(int n){
        int randomNo;
        if(n > 0){
            ISurprise[] surprises = new ISurprise[n];
            for(int i = 0; i < n; i++){
                randomNo = random.nextInt(3);
                surprises[i] = generateSurprise(randomNo);
            }
            return surprises;
        }
        return null;
    }

    public static ISurprise gather(){
        int randomSurprise = random.nextInt(3);
        return generateSurprise(randomSurprise);
    }
}
