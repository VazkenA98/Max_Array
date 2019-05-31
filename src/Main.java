public class Main {

    public static void main(String[]args){
        int [] myArray = new int[1000000];
        for (int i=0;i<myArray.length;i++){
            int rand = (int)(Math.random() * 1000000000);
            myArray[i] = rand;
            System.out.println("i = "+i);
            System.out.println(myArray[i]);
        }
        System.out.println("done");

        ThreadMax [] findMax = new ThreadMax[4];
        findMax[0] = new ThreadMax(myArray, 0,myArray.length/4);
        findMax[1] = new ThreadMax(myArray, myArray.length/4, (2*myArray.length)/4);
        findMax[2] = new ThreadMax(myArray, (2*myArray.length)/4, (3 * myArray.length) / 4);
        findMax[3] = new ThreadMax(myArray, (3 * myArray.length) / 4, myArray.length);

        for(int i=0;i<findMax.length;i++){
            findMax[i].start();
            try {
                findMax[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 4; i++){
            System.out.println("max for each thread = "+findMax[i].maxValue);
        }
        int[] topFour = new int[4];
        for(int i = 0; i < 4; i++)
            topFour[i] = findMax[i].maxValue;
        int result = 0;
        for(int i = 0; i < 4; i++){
            if(result < topFour[i])
                result = topFour[i];
        }
        System.out.println("Max = " + result);
    }
}
