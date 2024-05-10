package int103;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String Filename = "/Users/peerapansatitwiparawong/Documents/Assignment/INT103/FileIO/src/main/java/int103/output.txt";
        String[] names = {"Pete", "Get", "Bonus"};
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("filename"));
            writer.write("Write to a file");
            writer.write("\nAnother line");
            for (String name: names){
                writer.write("\n" + name);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("filename"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}