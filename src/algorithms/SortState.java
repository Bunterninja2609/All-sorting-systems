package algorithms;

import java.util.ArrayList;

public class SortState {
    int[] array;
    int currentIndex = 0;
    ArrayList<SortingStep> list = new ArrayList<>();
    public SortState(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }
    public void switchPlaces(int index1, int index2){
        list.add(new SortingStep(array, "switch", index1, index2));
    }
    public void stepForward(){
        if (currentIndex == list.size()) return;
        list.get(currentIndex).stepForward();

        currentIndex++;
    }
    public void stepBack(){
        if (currentIndex == 0) return;
        currentIndex--;
        list.get(currentIndex).stepBack();
    }
    public void stepTo(int index){

        while (currentIndex != index){
            if (currentIndex > index){
                stepBack();
            }else{
                stepForward();
            }
        }


    }
    public void printSorting(){
        while(currentIndex < list.size()){
            printArray();
            stepForward();
        }

    }
    public void printArray(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public int getSteps(){
        return list.size();
    }
    public int getCurrentIndex(){
        return currentIndex;
    }
    public int[] getArray(){
        return array;
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
