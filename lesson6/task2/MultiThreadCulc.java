package homeworks.lesson6;

public class MultiThreadCulc {

    static void culculateSum(int[] array, int threadNumber){

        SingleThreadCulc[] threadArray = new SingleThreadCulc[threadNumber];

        for(int i = 0; i < threadArray.length; i++){
            int size = array.length / threadNumber;
            int begin = size * i;
            int end = ((i + 1) * size);
            if((array.length - end) < size){
                end = array.length;
            }
            threadArray[i] = new SingleThreadCulc(array, begin, end);
        }

        for(int i = 0; i < threadArray.length; i++){
            try{
                threadArray[i].getThr().join();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
      System.out.println(mergeSum(threadArray));
    }

    private static int mergeSum(SingleThreadCulc [] threadArray){
        int sum =0;
        for(int i = 0; i < threadArray.length; i++){
         sum += threadArray[i].getSum();
        }
        return sum;
    }
}
