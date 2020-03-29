package Compunere;

public class Smartphone {
    private Screen theScreen;
    private Case theCase;
    private Speaker theSpeaker;
    private Microphone theMicrophone;

    // constructors
    public Smartphone(Screen theScreen, Case theCase,
                      Speaker theSpeaker, Microphone theMicrophone) {
        this.theScreen = theScreen;
        this.theCase = theCase;
        this.theSpeaker = theSpeaker;
        this.theMicrophone = theMicrophone;
    }

    public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol,
                      int microMaxVol) {
        this.theScreen = new Screen(pixelsNo, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVol);
        this.theMicrophone = new Microphone(microMaxVol);
    }

    public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol,
                      int speakerCrtVol, int microMaxVol, int microCrtVol) {
        this.theScreen = new Screen(pixelsNo, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVol, speakerCrtVol);
        this.theMicrophone = new Microphone(microMaxVol, speakerCrtVol);
    }

    //functionality
    public void pressPowerButton() {
        // delegate the responsibility to the object specific method
        // Obs: reusing the object functionality
        System.out.println("class Smartphone: delegate to Case ->");
        this.theCase.pressPowerButton();
    }

    public void pressVolumeUp() {
        // delegate the responsibility to the object specific method
        // Obs: reusing the object functionality
        System.out.println("class Smartphone: delegate to Case ->");
        this.theCase.pressVolumeUp();
    }

    public void pressVolumeDown() {
        // delegate the responsibility to the object specific method
        // Obs: reusing the object functionality
        System.out.println("class Smartphone: delegate to Case ->");
        this.theCase.pressVolumeDown();
    }

    public void setPixel(int index, String color){
        this.theScreen.setPixel(index, color);
    }

    public void colorScreen(String color){
        this.theScreen.colorScreen(color);
    }

    public void increaseMicrophoneVolume(){
        this.theMicrophone.increaseVolume();
    }

    public void decreaseMicrophoneVolume(){
        this.theMicrophone.decreaseVolume();
    }

    public void muteMicrophone(){
        this.theMicrophone.muteMicrophone();
    }

    public void setSilenceMode(){
        this.theSpeaker.setSilenceMode();
    }



}