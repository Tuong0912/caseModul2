import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quanlytk {
    Scanner scanner = new Scanner(System.in);
    static Map<String, String> quanlytk = new HashMap<>();

    public Quanlytk() {
        quanlytk = ReadAndWrite.read();
    }

    public void login() {
        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password =  scanner.nextLine();
        if (quanlytk.containsKey(name)) {
            if (quanlytk.get(name).equals(password)) {
                System.out.println("Đăng nhặp thành công");
                new Run().QuanLy(); //////////********\\\\\\\\\/
            } else {
                System.out.println("Nhập lại mật khẩu");
                String password1 = scanner.nextLine();
                if (quanlytk.get(name).equals(password1)) {
                    System.out.println("Đăng nhập thành công");
                    new Run().QuanLy();
                } else {
                    System.out.println("Đăng nhập thất bại");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Yêu cầu nhập lại");
            System.exit(0);
        }
    }

    public void dangKy() {
        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        if (!quanlytk.isEmpty() && quanlytk.containsKey(name)) {
            System.out.println("Tài khoản đã tồn tại");
        } else {
            TaiKhoan taiKhoan = new TaiKhoan(name, pass);
            quanlytk.put(taiKhoan.getAcc(), taiKhoan.getPassword());
            System.out.println("Đăng kí thành công");
        }
        ReadAndWrite.write(quanlytk);
    }

    public void doiMatKhau() {
        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        if (quanlytk.containsKey(name)) {
            if (quanlytk.get(name).equals(pass)) {
                System.out.println("Nhập mật khẩu mới");
                String pass1 = scanner.nextLine();
                quanlytk.put(name, pass1);

            } else {
                System.out.println("Sai mật khẩu");
            }
        } else {
            System.out.println("Tài khoản không tồn tại");
        }
    }
}
