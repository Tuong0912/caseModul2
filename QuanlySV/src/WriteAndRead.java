import java.io.*;
import java.util.ArrayList;

public class WriteAndRead {


    public WriteAndRead() {
    }

    public static void write(ArrayList<SinhVien> sinhViens) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\Module-2\\QuanlySV\\src\\sinhvien.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sinhViens);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<SinhVien> read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Admin\\Module-2\\QuanlySV\\src\\sinhvien.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList) objectInputStream.readObject();
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }


}
