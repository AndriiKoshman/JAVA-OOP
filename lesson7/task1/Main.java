package homeworks.lesson7;

public class Main {

        static public void main(String[]args) throws InterruptedException {

            Port port = new Port(0,2);

            Thread threadOne = new Thread( new Ship("Mariia", 10, port));
            Thread threadTwo = new Thread(new Ship("Black Pearl", 20, port));
            Thread threadThree = new Thread(new Ship("Ghost",10, port));

            threadOne.start();
            threadTwo.start();
            threadThree.start();
            Thread.sleep(10000);
            System.out.println(port);
        }
}
