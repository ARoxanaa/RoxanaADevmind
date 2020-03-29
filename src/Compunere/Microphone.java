package Compunere;

public class Microphone {
    private int micMaxVolume, micCrtVolume;

    //constructors
    public Microphone(int maxVolume){
        this.micMaxVolume = maxVolume;
        this.micCrtVolume = maxVolume / 4;
    }

    public Microphone(int maxVolume, int crtVolume){
        this.micMaxVolume = maxVolume;
        this.micCrtVolume = crtVolume;
    }

    //functionality
    public boolean increaseVolume(){
        if(this.micCrtVolume + 1 <= this.micMaxVolume){
            this.micCrtVolume += 1;
            return true;
        }
        return false;
    }

    public boolean decreaseVolume(){
        if(this.micCrtVolume - 1 >= 0){
            this.micCrtVolume -= 1;
            return true;
        }
        return false;
    }

    public void muteMicrophone(){
        this.micCrtVolume = 0;
    }
}
