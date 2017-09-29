package homeworks.lesson6;

public class SingleThreadCulc implements Runnable {

    private int[] array;
    private int begin;
    private int end;
    private Thread thr;
    private int sum;

    public SingleThreadCulc(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
    }

    public Thread getThr() {
        return thr;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = begin; i < end; i++) {
            sum += array[i];
        }
        setSum(sum);
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}
