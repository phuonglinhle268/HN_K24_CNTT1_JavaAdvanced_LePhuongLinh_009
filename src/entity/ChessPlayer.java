package entity;

import java.util.Scanner;

public class ChessPlayer {
    String playerId;
    String playerName;
    int age;
    int elo;  //hệ số elo - đại diện trình độ

    public ChessPlayer() {}

    public ChessPlayer(String playerId, String playerName, int age, int elo) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.age = age;
        this.elo = elo;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public void inputData(Scanner scanner){
        while (true){
            System.out.print("Nhập mã cờ thủ: ");
            String id = scanner.nextLine();
            if (!id.trim().isEmpty()){
                this.playerId = id;
                break;
            }
            System.out.println("Không được để trống!");
        }

        System.out.print("Nhập tên cờ thủ: ");
        this.playerName = scanner.nextLine();

        while (true){
            try {
                System.out.print("Nhập tuổi: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age >= 18){
                    this.age = age;
                    break;
                }
                System.out.println("Tuổi phải >= 18");
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng");
            }
        }

        while (true){
            try {
                System.out.print("Nhập elo: ");
                int elo = Integer.parseInt(scanner.nextLine());
                if (elo >= 0){
                    this.elo = elo;
                    break;
                }
                System.out.println("Elo không được âm");
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng");
            }
        }
    }

    public  void displayData(){
        System.out.printf("| %-10s | %-20s | %-5d | %-5d |\n ", playerId, playerName, age, elo);
    }
}
