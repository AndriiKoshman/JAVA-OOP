package homeworks.lesson6;

import homeworks.lesson5.MyFileFilter;
import java.io.File;

public class Main {

    static public void main(String[]args){

        MyFileFilter mFF = new MyFileFilter("docx", "pdf", "txt", "xlsx", "doc");
        File folder = new File("C:/Users/Public/Downloads");
        File[] fileList = folder.listFiles(mFF);
        String folderPath = "C:/Users/Public/Downloads/ReceivingFolder/";

        MultiThreadCopy.multiCopy(fileList,folderPath);
   }
}
