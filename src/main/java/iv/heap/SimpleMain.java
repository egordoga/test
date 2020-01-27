package iv.heap;

import java.io.File;
import java.io.IOException;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("MAIN");
        try {
           // Process proc = Runtime.getRuntime().exec("java -jar test_runtime.jar");
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "test_runtime.jar");
            pb.directory(new File("d:\\"));
            Process proc = pb.start();
            Thread.sleep(3000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MAIN END");
    }
}
