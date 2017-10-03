package homeworks.lesson6;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FolderChecker implements Runnable {

    private int size;
    private String path;

    public FolderChecker() {
        super();
    }

    public FolderChecker(int size, String path) {
        super();
        this.size = size;
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void startChecker(String path){

        File folder = new File(path);
        File[] fileList = folder.listFiles();
        ScheduledExecutorService exs = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> res = exs.scheduleAtFixedRate(new FolderChecker(fileList.length, path),1,1, TimeUnit.SECONDS);
    }

    @Override
    public void run() {

        File folder = new File(path);
        File[] fileList = folder.listFiles();
        if(size != fileList.length){
            System.out.println("Folder structure is changed");
            setSize(fileList.length);
        }
    }
}
