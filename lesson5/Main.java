package homeworks.lesson5;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File in = new File("C://Users///Public//Downloads//qtp_tutorial.pdf");
        File out = new File("C:/Users/Public/Downloads/ReceivingFolder/" + in.getName());

        try {
            FileOperation.copyFile(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //copy docx files
        MyFileFilter mFF = new MyFileFilter("docx");
        File folder = new File("C:/Users/Public/Downloads");
        File[] fileList = folder.listFiles(mFF);
        String folderPath = "C:/Users/Public/Downloads/ReceivingFolder/";

        try {
                for (File file : fileList) {
                    FileOperation.copyFile(file, FileOperation.generateFolderPath(folderPath, file));
                }
            } catch(IOException e){
                e.printStackTrace();
        }

        //find matches in txt files
        File txt1 = new File("C:/Users/Public/Downloads/SomeTXT.txt");
        File txt2 = new File("C:/Users/Public/Downloads/anotherTXT.txt");
        File matchedWords = new File("C:/Users/Public/Downloads/ReceivingFolder/matchesTXT.txt");

        try{
            FileOperation.findMatches(txt1,txt2,matchedWords);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
