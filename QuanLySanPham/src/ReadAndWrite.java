import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite {

    public void writefile(ArrayList<Product> products) {
        try {
            FileWriter fw = new FileWriter("D:\\DeThucHanhMD2\\QuanLySanPham\\src\\product.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Product p : products) {
                bw.write(p.toString());
                bw.newLine();

            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Product> read() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\untitled4\\modul2\\thuchanhMODUL2\\src\\Product.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("----");
        }
        return products;
    }
}