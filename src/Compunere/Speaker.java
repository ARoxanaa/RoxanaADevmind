package Compunere;

public class Speaker {
    private int speakerMaxVolume, speakerCrtVolume;

    //constructors
    public Speaker(int maxVolume){
        this.speakerMaxVolume = maxVolume;
        this.speakerCrtVolume = maxVolume / 4;
    }

    public Speaker(int maxVolume, int crtVolume){
        this.speakerMaxVolume = maxVolume;
        this.speakerCrtVolume = crtVolume;
    }

    //functionality
    public boolean increaseVolume(){
        if(this.speakerCrtVolume + 1 <= this.speakerMaxVolume){
            this.speakerCrtVolume += 1;
            return true;
        }
        return false;
    }

    public boolean decreaseVolume(){
        if(this.speakerCrtVolume - 1 >= 0){
            this.speakerCrtVolume -= 1;
            return true;
        }
        return false;
    }

    public void setSilenceMode(){
        this.speakerCrtVolume = 0;
    }
}
