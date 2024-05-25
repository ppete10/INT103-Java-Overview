package int103;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        //demoPassword();
        demoScannerFromString();

    }

    private static void demoPassword() {
        String password;
        var cons = System.console();
        if (cons != null) {
            System.out.print("Password: ");
            password = new String(cons.readPassword());
        } else {
            System.out.println("[Public]");
            System.out.println("Password: ");
            var sc = new Scanner(System.in);
            sc.useDelimiter("\\n");
            password = sc.next();
        }
        System.out.println("your password: " + password);
    }

    private static void demoScannerFromString() throws IOException {
        String src = """
                This is the first line.
                This is the second line.
                false 40 010010 12.54542345345 8438247832743829 832478237489327493249
                x y mm a the end""";
        var sc = new Scanner(src);
        sc.useDelimiter("\\s+");
        while (sc.hasNext()){
            if (sc.hasNextBoolean()){
                boolean b = sc.nextBoolean();
                System.out.println("boolean: " + b);
            } else if (sc.hasNextInt(2)){
                System.out.println("binary value: " + sc.next());
            } else if (sc.hasNextInt()){
                System.out.println("int: " + sc.nextInt());
            } else if (sc.hasNextLong()){
                System.out.println("long: " + sc.nextLong());
            } else if (sc.hasNextDouble()){
                System.out.println("double: " + sc.nextDouble());
            }else if (sc.hasNext("\\b.\\b")){
                char c = sc.next().charAt(0);
                System.out.println("char: " + c);
            } else
                System.out.println("String: " + sc.next());
        }
        //var s2 = new Scanner(new File("abc.txt"));
        //var s3 = new Scanner(new FileInputStream(new File("abc.txt")));
    }
}