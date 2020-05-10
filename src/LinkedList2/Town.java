package LinkedList2;

public class Town implements Comparable<Town>{
    // ex. 1
    private String townName;
    private int km;

    public Town(String townName, int km) {
        this.townName = townName;
        this.km = km;
    }

    public String getTownName() {
        return townName;
    }

    public int getKm() {
        return km;
    }


    @Override
    public int compareTo(Town t) {
        if(this.km < t.getKm()){
            return -1;
        }
        if(this.km > t.getKm()){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Town t = (Town) obj;
        return this.km == t.getKm();
    }

    @Override
    public String toString(){
        return this.townName + " " + this.km;
    }
}
