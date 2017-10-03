package homeworks.lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SingleThreadCopy implements Runnable {

    private File in;
    private String out;

    public SingleThreadCopy(File in, String out) {
        super();
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        if(in == null || out == null){
            throw new IllegalArgumentException("Null file Pointer");
        }
        System.out.println(in.getName());
            try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out + in.getName())) {
                byte[] buffer = new byte[1024];
                int byteRead = 0;

                for (; (byteRead = fis.read(buffer)) > 0; ) {
                    fos.write(buffer, 0, byteRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
