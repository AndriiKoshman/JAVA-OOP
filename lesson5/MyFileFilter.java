package homeworks.lesson5;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

    private String extensionsArr [];

    public MyFileFilter(String... extensionsArr) {
        super();
        this.extensionsArr = extensionsArr;
    }
     private boolean checkExt(String ext) {
         for (String extString : extensionsArr) {
             if(extString.equals(ext)){
                 return true;
             }
         }
         return false;
     }

     @Override
     public boolean accept(File pathname){
         int pointerIndex = pathname.getName().lastIndexOf(".");
         if(pointerIndex == -1){
             return false;
         }
         String ext = pathname.getName().substring(pointerIndex + 1);
         return checkExt(ext);
    }
}
