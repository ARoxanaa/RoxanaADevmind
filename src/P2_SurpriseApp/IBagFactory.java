package P2_SurpriseApp;

public interface IBagFactory {
    // Create a new container, according to the specified type
    IBag makeBag(String type);
}
