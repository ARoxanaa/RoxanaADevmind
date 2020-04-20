package P2_SurpriseApp;

public class BagFactory implements IBagFactory {
    private static IBag bag;

    @Override
    public IBag makeBag(String type) {
        switch (type) {
            case "RANDOM":
                return bag = new RandomBag();
            case "FIFO":
                return bag = new FIFOBag();
            case "LIFO":
                return bag = new LIFOBag();
            default:
                return null;
        }
    }
}
