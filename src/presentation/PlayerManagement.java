package presentation;

import business.PlayerBusiness;
import entity.ChessPlayer;

import java.util.Scanner;

public class PlayerManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerBusiness business = PlayerBusiness.getInstance();

        while (true){
            System.out.println("---------- QUẢN LÝ CỜ THÚ ----------");
            System.out.println("1. Hiển thị danh sách toàn bộ cờ thú");
            System.out.println("2. Thêm mới cờ thú");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã cờ thú");
            System.out.println("4. Xóa sinh viên theo mã cờ thú");
            System.out.println("5. Tìm kiếm cờ thú theo tên");
            System.out.println("6. Lọc danh sách cờ thú xuất sắc nhất (elo >= 1500)");
            System.out.println("7. Sắp xếp danh sách giảm dần theo Elo");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    business.displayList();
                    break;

                case 2:
                    while (true){
                        ChessPlayer player = new ChessPlayer();
                        player.inputData(scanner);

                        if (business.addPlayer(player)){
                            System.out.println("Thêm cờ thủ thành công");
                        }

                        System.out.print("Tiếp tục thêm?(y/n): ");
                        if (!scanner.nextLine().equalsIgnoreCase("y")){
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã cờ thủ của sinh viên cần cập nhập: ");
                    business.updatePlayer(scanner.nextLine(),scanner);
                    break;

                case 4:
                    System.out.print("Nhập mã cờ thủ của sinh viên muốn xóa: ");
                    business.deletePlayer(scanner.nextLine());
                    break;

                case 5:
                    System.out.print("Nhập tên cờ thủ muốn tìm: ");
                    business.searchByName(scanner.nextLine());
                    break;

                case 6:
                    business.filterElo();
                    break;

                case 7:
                    business.sortByElo();
                    break;

                case 8:
                    System.out.println("Thoát lựa chọn của bạn");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }
}
