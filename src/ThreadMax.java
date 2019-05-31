public class ThreadMax extends Thread{
    int maxValue;
    int arrayStart;
    int arrayEnd;
    int []array;

    public ThreadMax(int []array,int arrayStart,int arrayEnd){
        this.array = array;
        this.arrayStart = arrayStart;
        this.arrayEnd = arrayEnd;

    }

    public void run() {
        for (int i = arrayStart; i < arrayEnd; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
    }
}
