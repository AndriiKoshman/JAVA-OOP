package homeworks.lesson5;

import java.io.*;
import java.nio.Buffer;

public class FileOperation {

    public static void copyFile(File in, File out) throws IOException {
        if(in == null || out == null){
            throw new IllegalArgumentException("Null file Pointer");
        }
        try(FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)){
    byte [] buffer = new byte[1024];
    int byteRead = 0;

    for(;(byteRead = fis.read(buffer)) > 0;){
        fos.write(buffer,0,byteRead);
        }

        }catch(IOException e){
            throw e;
        }
    }

    public static File generateFolderPath(String pathname, File file) {
        return new File(pathname + file.getName());
    }

    public static void findMatches(File in1, File in2, File out) throws IOException {
        if(in1 == null || in2 == null || out ==null){
            throw new IllegalArgumentException("Null file Pointer");
        }
        
        String [] words1 = returnWordsArr(in1);
        String [] words2 = returnWordsArr(in2);
        String matches = "";

            for(String word1 : words1){
                if(word1 != null) {
                    for (String word2 : words2) {
                        if (word2 != null && word1.compareTo(word2) == 0) {
                            matches += "Word exists in both files: " + word1 + System.lineSeparator();
                        }
                    }
                }
            }
            saveFile(out,matches);
    }

    public static String[] returnWordsArr(File in) throws IOException {
        if(in == null){
            throw new IllegalArgumentException("Null file Pointer");
        }

        String str = "";
        String strLine = "";

        try(BufferedReader bR = new BufferedReader(new FileReader(in))){

            for(;(str = bR.readLine()) !=null;){
                strLine += str;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String [] words = strLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        return words;

    }

    public static void saveFile(File out, String matches){

        try(FileWriter fW = new FileWriter(out)){

            fW.write(matches);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
