package homeworks.lesson6;

import java.math.BigInteger;

public class MultiFactorialThread implements Runnable {

    public MultiFactorialThread() {
        super();
    }

    public MultiFactorialThread(int threads){
        for(int i = 0; i <= threads; i++) {

           Thread thread = new Thread(this);
           thread.start();
        }
    }
    private BigInteger factorialCaclculate(long n){
        BigInteger factorial = new BigInteger("1");
        if(n == 0)
            return new BigInteger("0");
        for(int i = 0; i <= n; i++){
            factorial = factorial.multiply(new BigInteger(""+n));
        }
        return factorial;
    }


    @Override
    public void run(){
        Thread thisThread = Thread.currentThread();

            if(thisThread.isInterrupted()){
                System.out.println("Is interrupted");
            }
            long threadId = thisThread.getId() -10;

            System.out.println((thisThread.getName() + " " + threadId   +"! = " + factorialCaclculate(threadId)));
    }
}
