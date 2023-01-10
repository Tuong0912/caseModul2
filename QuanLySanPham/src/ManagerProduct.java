import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerProduct {
    ReadAndWrite readAndWrite = new ReadAndWrite();
    ArrayList<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void read() {
        readAndWrite.read();
    }

    public void show() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    public void add() {
        System.out.println("Nhập mã sản phẩm");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(sc.nextLine());
                if (id < 0) {
                    System.out.println("Nhập lại");
                } else break;
            } catch (Exception e) {
                System.out.println("Nhập lại");
            }

        }
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price;
        while (true) {
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price < 0) {
                    System.out.println("Nhập lại");
                } else break;
            } catch (Exception e) {
                System.out.println("Nhập lại");
            }
        }

        System.out.println("Nhập số lượng");
        int number;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 0) {
                    System.out.println("Nhập lại");
                } else break;
            } catch (Exception e) {
                System.out.println("Nhập lại");
            }
        }
        System.out.println("Nhập mô tả");
        String moTa = sc.nextLine();
        Product product = new Product(id, name, price, number, moTa);
        products.add(product);
        readAndWrite.writefile(products);
    }

    public void delete() {
        System.out.println("Nhập mã sản phẩm cần xóa");
        int id = 0;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Chỉ nhập số");
        }
        boolean check = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).maSanPham() == id) {
                System.out.println("Nhập Y để xác nhận xóa");
                String y = sc.nextLine();
                if (y.equals("Y")) {
                    products.remove(i);
                    check = true;
                } else return;
            }
        }
        if (!check) System.out.println("Không có sản phẩm tương ứng");
        readAndWrite.writefile(products);
    }


    public void edit() {
        System.out.println("Nhập mã sản phẩm cần sửa");
        int id = 0;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Chỉ nhập số");
        }

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).maSanPham()) {
                System.out.println("Nhập mã sản phẩm mới");
                String maSP = sc.nextLine();
                if (maSP.equals("")) System.out.println("Không sửa");
                else products.get(i).setMaSanPham(Integer.parseInt(maSP));

                System.out.println("Nhập tên sản phẩm");
                String name = sc.nextLine();
                if (name.equals("")) System.out.println("Không sửa");
                else products.get(i).setTenSanPham(name);

                System.out.println("Nhập giá sản phẩm");
                String gia = sc.nextLine();
                if (gia.equals("")) System.out.println("không sửa");
                else products.get(i).setGiaSanPham(Double.parseDouble(gia));

                System.out.println("Nhập số lượng");
                String numBer = sc.nextLine();
                if (numBer.equals("")) System.out.println("Không sửa");
                else products.get(i).setSoLuong(Integer.parseInt(numBer));

                System.out.println("Nhập mô tả");
                String moTa = sc.nextLine();
                if (moTa.equals("")) System.out.println("Không sửa");
                else products.get(i).setMoTa(moTa);
            }
        }
        readAndWrite.writefile(products);
    }

    public void sortUpByPrice() { //Sắp xếp tăng dần
        Collections.sort(this.products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.giaSanPham() < o2.giaSanPham()) {
                    return -1;
                } else if (o1.giaSanPham() > o2.giaSanPham()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void sortDownByPrice() { //Sắp xếp giảm dần
        Collections.sort(this.products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.giaSanPham() > o2.giaSanPham()) {
                    return -1;
                } else if (o1.giaSanPham() < o2.giaSanPham()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void findMaxPrice() {
        double max = products.get(0).giaSanPham();
        Product product = products.get(0);
        for (int i = 0; i < products.size(); i++) {
            if (max < products.get(i).giaSanPham()) {
                max = products.get(i).giaSanPham();
                product = products.get(i);
            }
        }
        System.out.println(product);
    }


}
