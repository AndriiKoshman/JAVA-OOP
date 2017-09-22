package homeworks.lesson5;

import java.io.*;

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
        String str1 = "";
        String str2 = "";
        String strLine1 = "";
        String strLine2 = "";
        String matches = "";

        try(BufferedReader bR1 = new BufferedReader(new FileReader(in1)); BufferedReader bR2 = new BufferedReader(new FileReader(in2)); FileWriter fW = new FileWriter(out)){

            for(;(str1 = bR1.readLine()) != null;){
                strLine1 += str1;
            }
            String [] words1 = strLine1.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            System.out.println(strLine1);

            for (; (str2 = bR2.readLine()) != null; ) {
               strLine2 += str2;
            }
            String[] words2 = strLine2.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            for(String word1 : words1){
                if(word1 != null) {
                    for (String word2 : words2) {
                        if (word2 != null && word1.compareTo(word2) == 0) {
                            matches += "Word exists in both files: " + word1 + System.lineSeparator();
                        }
                    }
                }
            }

            fW.write(matches);

        }catch(IOException e){
            throw e;
        }
    }
}
