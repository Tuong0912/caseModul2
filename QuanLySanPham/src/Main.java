import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerProduct managerProduct = new ManagerProduct();
        while (true) {
            try {
                System.out.println("1. Thêm");
                System.out.println("2. Sửa");
                System.out.println("3. Xóa");
                System.out.println("4. Hiển thị");
                System.out.println("5. Tìm sản phẩm có giá lớn nhất");
                System.out.println("6. Sắp xếp ");
                System.out.println("Nhập khác 1 -> 6 để thoát");
                System.out.print("Mời nhập : ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> managerProduct.add();
                    case 2 -> managerProduct.edit();
                    case 3 -> managerProduct.delete();
                    case 4 -> managerProduct.show();
                    case 5 -> managerProduct.findMaxPrice();
                    case 6 -> {
                        System.out.println("1. Sắp xếp tăng dần");
                        System.out.println("2. Sắp xếp giảm dần");
                        System.out.println("3. Quay lại");
                        System.out.print("Mời nhập : ");
                        choice = Integer.parseInt(sc.nextLine());
                        switch (choice) {
                            case 1 -> managerProduct.sortUpByPrice();
                            case 2 -> managerProduct.sortDownByPrice();
                            case 3 -> {
                                return;
                            }
                        }
                    }
                    default -> System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Chỉ nhập từ 1 -> 6 ");
            }

        }
    }
}

