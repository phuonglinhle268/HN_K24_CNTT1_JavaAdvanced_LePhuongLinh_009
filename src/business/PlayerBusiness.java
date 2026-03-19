package business;

import entity.ChessPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayerBusiness {
    private List<ChessPlayer> playerList;

    private static PlayerBusiness instance;

    private PlayerBusiness(){
        playerList = new ArrayList<>();
    }

    public static PlayerBusiness getInstance(){
        if (instance == null){
            instance = new PlayerBusiness();
        }
        return instance;
    }

    // hiển thị
    public void displayList(){
        if (playerList.isEmpty()){
            System.out.println("Danh sách cờ thủ trống");
            return;
        }
        System.out.printf("| %-10s | %-20s | %-5s | %-5s |\n", "ID", "Tên", "Tuổi", "Elo");
        playerList.forEach(ChessPlayer::displayData);
    }

    // thêm
    public boolean addPlayer(ChessPlayer player){
        boolean exist = playerList.stream().anyMatch(p -> p.getPlayerId().equals(player.getPlayerId()));

        if (exist){
            System.out.println("Mã cờ thủ đã tồn tại");
            return false;
        }
        playerList.add(player);
        return true;
    }

    public Optional<ChessPlayer> findById(String id){
        return playerList.stream()
                .filter(p -> p.getPlayerId().equals(id))
                .findFirst();
    }

    // update
    public void updatePlayer(String id, Scanner scanner){
        Optional<ChessPlayer> optional = findById(id);

        if (!optional.isPresent()){
            System.out.println("Mã cờ thủ không tồn tại trong hệ thống");
            return;
        }
        ChessPlayer player = optional.get();

        try {
            System.out.println("1. Tên\n2. Tuổi\n3. Elo");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    System.out.print("Nhập tên mới: ");
                    player.setPlayerName(scanner.nextLine());
                    break;

                case 2:
                    while (true){
                        try {
                            System.out.print("Nhập tuổi mới: ");
                            int age = Integer.parseInt(scanner.nextLine());
                            if (age >= 18){
                                player.setAge(age);
                                break;
                            } else {
                                System.out.println("Tuổi phải >= 18");
                            }
                        } catch (Exception e){
                            System.out.println("Nhập sai!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập elo mới: ");
                    int elo = Integer.parseInt(scanner.nextLine());
                    if (elo >= 0){
                        player.setElo(elo);
                    } else{
                        System.out.println("Elo không hợp lệ");
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } catch (Exception e) {
            System.out.println("Lỗi nhập");
        }
    }

    // search
    public void searchByName(String keyword){
        List<ChessPlayer> result = playerList.stream()
                .filter(p -> p.getPlayerName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()){
            System.out.println("Không tìm thấy cờ thủ tên tương ứng");
            return;
        }

        result.forEach(ChessPlayer::displayData);
        System.out.println("Tổng cờ thủ tìm thấy: " + result.size());
    }

    // delete
    public void deletePlayer(String id){
        int sizeBefore = playerList.size();

        playerList.removeIf(p -> p.getPlayerId().equals(id));

        if (playerList.size() == sizeBefore){
            System.out.println("Mã cờ thủ không tồn tại trong hệ thống");
        }
    }

    // sort giảm dần elo
    public void sortByElo(){
        List<ChessPlayer> sorted = playerList.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getElo(), p1.getElo()))
                .collect(Collectors.toList());

        sorted.forEach(ChessPlayer::displayData);
    }

    //filter elo >= 1500
    public void filterElo(){
        List<ChessPlayer> result = playerList.stream()
                .filter(p -> p.getElo() >= 1500)
                .collect(Collectors.toList());

        if (result.isEmpty()){
            System.out.println("Không có cờ thủ xuất sắc");
            return;
        }
        result.forEach(ChessPlayer::displayData);
    }
}