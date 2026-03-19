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

    public  void inputData(Scanner scanner){
        System.out.print("Nhập mã cờ thủ: ");
        this.playerId = scanner.nextLine();
        System.out.print("Nhập tên cờ thủ: ");
        this.playerName = scanner.nextLine();

        while (true){
            System.out.print("Nhập tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 18){
                this.age = age;
                break;
            }
            System.out.println("Sân chơi dành cho sinh viên đại học từ 18 trở lên");
        }

        while (true){
            System.out.print("Nhập elo (trình độ): ");
            int elo = Integer.parseInt(scanner.nextLine());
            if (elo >= 0){
                this.elo = elo;
                break;
            }
            System.out.println("Elo không được âm");
        }
    }


    public  void displayData(){
        System.out.printf("| %-5s | %-20s | %-3s | %-5s | \n ", playerId, playerName, age, elo);
    }
}
