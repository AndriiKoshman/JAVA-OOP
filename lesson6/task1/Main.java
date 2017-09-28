package homeworks.lesson6;

public class Main {

    static public void main(String[]args){

        MultiFactorialThread threads = new MultiFactorialThread(100);
        threads.run();
    }
}
