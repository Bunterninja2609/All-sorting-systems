package algorithms;

import java.util.LinkedList;
import java.util.List;

public class SortState {
    int[] array;
    LinkedList <SortingStep> list = new LinkedList<>();
    public SortState(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }
    public void switchPlaces(int index1, int index2){
        list.add(new SortingStep(array, "switch", index1, index2));
    }
    public void stepForward(){
        //move forward
    }
    public void stepBack(){
        //move back
    }
    private class SortingStep{
        String type;
        int index1, index2;
        int[] array;
        public SortingStep(int[] array,String type, int index1, int index2){
            this.type = type;
            this.index1 = index1;
            this.index2 = index2;
            this.array = array;
        }
        public void stepBack(){
            switch(type){
                case "switch":
                    switchPlaces(index2, index1);
                    break;
            }
        }
        public void stepForward(){
            switch(type){
                case "switch":
                    switchPlaces(index1, index2);
                    break;
            }
        }
        private void switchPlaces(int index1, int index2){
            int value1 = array[index1];
            int value2 = array[index2];
            array[index1] = value2;
            array[index2] = value1;
        }
    }
}
