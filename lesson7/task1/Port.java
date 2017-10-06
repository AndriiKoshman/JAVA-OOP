package homeworks.lesson7;

import java.util.concurrent.Semaphore;

public class Port {

    private int load;
    private Semaphore semaphore;

    public Port(int load, int docks) {
        super();
        this.load = load;
        this.semaphore = new Semaphore(docks);
    }



    public void setLoad(Ship ship) {

        try {
        semaphore.acquire();
        Thread thisThread = Thread.currentThread();
        for (;ship.getVolume() > 0;){
                System.out.println("Volume:" + ship.getVolume() + " - " + thisThread.getName());
                ship.setVolume(ship.getVolume() - 1);
                 load ++;
                Thread.sleep(500);
            }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }


    public int getLoad() {
        return load;
    }

    @Override
    public String toString() {
        return "Dock{" +
                "load=" + load +
                ", semaphore=" + semaphore +
                '}';
    }
}
