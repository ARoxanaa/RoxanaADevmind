package ArrayList;

import java.util.Arrays;

public class MyIntArrayList {
    private int[] arr;
    private int size;

    public MyIntArrayList(){
        this(10);
    }

    public MyIntArrayList(int initCapacity){
        arr = new int[initCapacity];
    }

    public MyIntArrayList(int[] arr) {
        this.arr = arr;
    }

    public void add(int index, int element){
        if(index < 0 || index > arr.length){
            System.out.println("Throw exception");
        } else{
            arr[index] = element;
        }
    }

    public boolean add(int e){
        if(this.size == arr.length){
            this.arr = Arrays.copyOf(this.arr, this.size * 2);
        }
        this.arr[size] = e;
        this.size++;
        return true;
    }

    public int size(){
        return this.size;
    }

    public boolean contains(int e){
        for(int i = 0; i < this.size; i++){
            if(this.arr[i] == e){
                return true;
            }
        }
        return false;
    }

    public int get(int index){
        return this.arr[index];
    }

    public int indexOf(int e){
        for(int i = 0; i < this.size; i++){
            if(e == this.arr[i]){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int e){
        int lastIndex = -1;
        for(int i = 0; i < this.size; i++){
            if(e == this.arr[i]){
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public int removeElementAtIndex(int index){
        if(index < 0 || index >= this.size){
            System.out.println("Index out of bounds exception");
            return -1;
        }
        int removedElement = this.arr[index];
        for(int i = index; i < this.size - 1; i++){
            this.arr[i] = this.arr[i+1];
        }
        size--;
        return removedElement;
    }

    public void clear(){
        this.size = 0;
    }

    public int set(int index, int e){
        if(index < 0 || index >= size()){
            System.out.println("Index Out of Bounds Exception");
            return -1;
        }
        int replacedElement = this.arr[index];
        arr[index] = e;
        return replacedElement;
    }

    public boolean addAll(int[] addArr){
        if (addArr == null || addArr.length == 0) {
            System.out.println("Null Pointer Exeption");
            return false;
        }

        if(this.arr.length < this.size + addArr.length){
            this.arr = Arrays.copyOf(this.arr, this.size * 2);
        }
        for(int i = 0; i < addArr.length; i++){
            this.arr[size + 1] = addArr[i];
            size ++;
        }

        return true;
    }

    public boolean addAll(int index, int[] addArr){
        if (addArr == null || addArr.length == 0) {
            System.out.println("Null Pointer Exeption");
            return false;
        }
        if(index < 0 || index > size()){
            System.out.println("Index out of bounds exception");
            return false;
        }

        if(this.arr.length < this.size + addArr.length){
            this.arr = Arrays.copyOf(this.arr, this.size * 2);
        }
        for(int i = 0; i < addArr.length; i++){
            this.arr[size + 1] = addArr[i];
            size ++;
        }

        return true;
    }

    public int[] toArray(){
        int[] arrayToReturn = new int[this.size];
        for(int i = 0; i < this.size; i++){
            arrayToReturn[i] = this.arr[i];
        }
        return arrayToReturn;
    }

    public void ensureCapacity(int minCapacity){
        if(this.arr.length < minCapacity){
            this.arr = Arrays.copyOf(this.arr, minCapacity);
        }
    }

    public void trimToSize(){
        if(this.size < this.arr.length){
            int[] newArr = new int[this.size];
            for(int i = 0 ; i < this.size; i++){
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }
    }

}
