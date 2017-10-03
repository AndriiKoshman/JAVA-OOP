package homeworks.lesson6;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadCopy {

    static void multiCopy(File[] fileArray, String path){

        ExecutorService exSr = Executors.newFixedThreadPool(10);

        for(File file : fileArray) {
            exSr.execute(new SingleThreadCopy(file,path));
        }
        exSr.shutdown();
    }
}
