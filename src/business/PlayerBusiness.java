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

    // hiện danh sách
    public void displayList(){
        if (playerList.isEmpty()){
            System.out.println("Danh sách cờ thủ trống");
            return;
        }
        playerList.forEach(ChessPlayer::displayData);
    }

    // thêm
    public boolean addPlayer(ChessPlayer player){
        boolean exist = playerList.stream().anyMatch(p -> p.getPlayerId().equals(player.getPlayerId()));
        if (exist){
            System.out.println("Mã cờ thủ đã tồn tại");
            return false;
        }
        return true;
    }

    public Optional<ChessPlayer> findById(String id){
        return playerList.stream()
                .filter(p ->p.getPlayerId().equals(id))
                .findFirst();
    }

    // update thông tin
    public void updatePlayer(String id, Scanner scanner){
        Optional<ChessPlayer> optional = findById(id);
        if (!optional.isPresent()){
            System.out.println("Mã cờ thủ không tồn tại trong hệ thống");
            return;
        }

        ChessPlayer player = optional.get();
        System.out.println("1. Tên\n2. Tuổi\n3. Elo");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.print("Nhập tên mới: ");
                player.setPlayerName(scanner.nextLine());
                break;

            case 2:
                System.out.print("Nhập tuổi mới: ");
                player.setAge(Integer.parseInt(scanner.nextLine()));
                break;

            case 3:
                System.out.print("Nhập elo mới: ");
                player.setElo(Integer.parseInt(scanner.nextLine()));
                break;
        }
    }

    // search theo tên
    public void searchByName(String keyword){
        List<ChessPlayer> result = playerList.stream()
                .filter(p -> p.getPlayerName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        if (result.isEmpty()){
            System.out.println("Không tìm thấy tên cờ thủ trùng khớp");
            return;
        }
        result.forEach(ChessPlayer::displayData);
        System.out.println("Tổng số cờ thủ tìm thấy: "+result.size());
    }

    //xóa cờ thủ
    public void deletePlayer(String id){
        int sizeBefore = playerList.size();

        playerList.removeIf(p->p.getPlayerId().equals(id));
        if (playerList.size() == sizeBefore){
            System.out.println("Mã cờ thủ không tồn tại trong hệ thống");
        }
    }

    //sắp xếp theo elo giảm dần
    public void sortByElo(){
        playerList.sort((p1, p2) ->
                Integer.compare(p2.getElo(), p1.getElo()));
        displayList();
    }

    // lọc elo >= 1500
    public void filterElo(){
//        List<ChessPlayer> highElo = playerList.stream()
//                .filter(p->p.getElo());
//
//        if (highElo.isEmpty()){
//            System.out.println("Không có sinh viên với điểm elo >= 1500");
//            return;
//        }
//        highElo.forEach(ChessPlayer::displayData);
    }
}
