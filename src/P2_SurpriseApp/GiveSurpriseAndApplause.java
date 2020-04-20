package P2_SurpriseApp;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {
    public GiveSurpriseAndApplause(String type, int waitTime) {
        super(type.toUpperCase(), waitTime);
    }


    @Override
    void giveWithPassion() {
        System.out.println("Loud applause to you… For it is in giving that we receive.");
    }
}
