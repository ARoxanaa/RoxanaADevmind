public class ArrayList {
    private int[] arr;
    private int size;

    public ArrayList(){
        this(10);
    }

    public ArrayList(int initCapacity){
        arr = new int[initCapacity];
    }

    public ArrayList(int[] arr) {
        this.arr = arr;
    }

    public int removeElementAtIndex(int index){
        int removedElement = arr[index];
        for(int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        return removedElement;
    }

    public void clear(){
        size = 0;
    }

}
