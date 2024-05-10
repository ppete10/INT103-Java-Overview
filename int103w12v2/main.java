package int103;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        demoByteArrayInputStream();
        demoFileInputStream();
        demoSequenceInputStream();
        demoBufferedInputStream();
        demoDataInputStream();
        demoPipedInputOutput();
    }

    private static void demoPipedInputOutput() {
        System.out.println("\n---- Piped Input Output----");
        long n = 1_000_000_000L;
        double d = 13.4567891;
        boolean b1 = false;
        boolean b2 = true;
        try (PipedOutputStream pos = new PipedOutputStream();
                PipedInputStream pis = new PipedInputStream()) {
            pos. connect(pis);
            pos.write(67);
            pos.write(70);
            pos.write(75);
            pos.close();
            int i;
            while ((i = pis.read()) != -1){
                System.out.print((char) i + " ");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demoDataInputStream() {
        System.out.println("\n---- Data Input Output----");
        long n = 1_000_000_000L;
        double d = 13.4567891;
        boolean b1 = false;
        boolean b2 = true;
        try (DataOutputStream dos = new DataOutputStream(new DataOutputStream(new FileOutputStream("/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103w12v2/out.dat")))){
            dos.writeBoolean(b1);
            dos.writeDouble(d);
            dos.writeLong(n);
            dos.writeBoolean(b2);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done Writing");
        try (DataInputStream dis = new DataInputStream(new DataInputStream(new FileInputStream("/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103w12v2/out.dat")))){
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
            System.out.println(dis.readLong());
            System.out.println(dis.readBoolean());
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demoBufferedInputStream() {
        System.out.println("\n---- Buffered Input ----");
        try (InputStream bis = new BufferedInputStream(
                     new FileInputStream("/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103w12v2/input.txt"),1000)) {
            //new FileInputStream(new File("/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103w12v2/input.txt"))){
            int i;
            while ((i = bis.read()) != -1){
                System.out.print((char) i);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void demoSequenceInputStream() {
        System.out.println("\n---- Sequence Input ----");
        byte[] bb =  {65,66,67,68,69,70};
        try (InputStream sis = new SequenceInputStream(
                new ByteArrayInputStream(bb),
                new FileInputStream("/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103w12v2/input.txt"))){
        int i;
        while ((i = sis.read()) != -1) {
            System.out.print((char) i + " ");
        }
    } catch (Exception e){
        e.printStackTrace();
    }

    }

    private static void demoFileInputStream() {
        System.out.println("\n---- File Input ----");
        try (InputStream fis =
             new FileInputStream("/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103w12v2/input.txt")){
             //new FileInputStream(new File("/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103w12v2/input.txt"))){
                    int i;
                    while ((i = fis.read()) != -1){
                        System.out.print((char) i);
                    }
            } catch (Exception e){
                e.printStackTrace();
            }

    }

    private static void demoByteArrayInputStream() {
        System.out.println("\n---- ByteArray ----");
        byte[] bb =  {1,2,3,4,5,6};
        try (InputStream ais = new ByteArrayInputStream(bb)) {
                int i;
                while ((i = ais.read()) != -1) {
                    System.out.print(i + " ");
                }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}