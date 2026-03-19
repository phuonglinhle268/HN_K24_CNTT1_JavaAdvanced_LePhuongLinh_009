public class Main {
}































//input data userId,userName;age;role;score;
//public void inputData(Scanner scanner){
//    System.out.println("Nhập mã user: ");
//    this.userId = scanner.nextLine();
//    System.out.println("Nhập tên: ");
//    this.userName = scanner.nextLine();
//    while (true){
//        System.out.println("Nhập tuổi: ");
//        int age = Integer.parseInt(scanner.nextLine());
//        if (age >= 18){
//            this.age = age;
//            break;
//        }
//        System.out.println("Tuổi ko hợp lệ");
//    }
//    while (true){
//        System.out.println("Nhập role (user/admin): ");
//        String role = scanner.nextLine().toUpperCase();
//        if (role.equals("USER") || role.equals("ADMIN")){
//            this.role = role;
//            break;
//        }
//        System.out.println("Role không hợp lệ");
//    }
//    while (true){
//        System.out.println("Nhập score: ");
//        double score = Double.parseDouble(scanner.nextLine());
//        if (score >= 0 && score <= 10){
//            this.score = score;
//            break;
//        }
//        System.out.println("Điểm không hợp lệ");
//    }
//public void displayData(){
//    System.out.printf("| %-5s | %-15s | %-3d | %-6s | %-5.2f |\n", userId, userName, age, role, score);



//private List<User> userList;
////singleton
//private static UserBusiness instance;
//private UserBusiness(){
//    userList = new ArrayList<>();
//public static UserBusiness getInstance(){
//    if (instance == null){
//        instance = new UserBusiness();
//    }
//    return instance;
//}
//public void displayList(){
//    if (userList.isEmpty()){
//        System.out.println("Danh sách rỗng");
//        return;
//    }
//    userList.forEach(User::displayData);
//}
//public boolean addUser(User user){
//    boolean exist = userList.stream().anyMatch(u -> u.getUserId().equals(user.getUserId()));
//    if (exist){
//        System.out.println("Id tồn tại");
//        return  false;
//    }
//    userList.add(user);
//    return true;
//}
//public Optional<User> findById(String id){
//    return userList.stream()
//            .filter(u -> u.getUserId().equals(id))
//            .findFirst();
//}
//public void updateUser(String id, Scanner scanner){
//    Optional<User> optional = findById(id);
//    if (!optional.isPresent()){
//        System.out.println("Mã id ko tồn tại");
//        return;
//    }
//    User user = optional.get();
//    System.out.println("1. Tên\n2. Tuổi\n3. Role\n4. Score");
//    int choice = Integer.parseInt(scanner.nextLine());
//    switch (choice){
//        case 1:
//            System.out.println("Nhập tên mới: ");
//            user.setUserName(scanner.nextLine());
//            break;
//        case 2:
//            System.out.println("Nhập tuổi: ");
//            user.setAge(Integer.parseInt(scanner.nextLine()));
//            break;
//        case 3:
//            System.out.println("Nhập role: ");
//            user.setRole(scanner.nextLine());
//            break;
//        case 4:
//            System.out.println("Nhập score: ");
//            user.setScore(Double.parseDouble(scanner.nextLine()));
//            break;
//    }
//}
//public void searchName(String keyword){
//    List<User> result = userList.stream()
//            .filter(u->u.getUserName().toLowerCase().contains(keyword.toLowerCase()))
//            .collect(Collectors.toList());
//    if (result.isEmpty()){
//        System.out.println("Không thấy");
//        return;
//    }
//    result.forEach(User::displayData);
//    System.out.println("Tổng: " + result.size());
//}
//public void deleteUser(String id){
//    int sizeBefore = userList.size();
//
//    userList.removeIf(u->u.getUserId().equals(id));
//    if (userList.size() ==sizeBefore){
//        System.out.println("Mã user ko tồn tại");
//    }
//}
//public void filterAdmin(){
//    List<User> admins = userList.stream()
//            .filter(u->u.getRole().equals("ADMIN"))
//            .collect(Collectors.toList());
//
//    if (admins.isEmpty()){
//        System.out.println("Ko có admin");
//        return;
//    }
//    admins.forEach(User::displayData);
//}
//public void sortByScore(){
//    userList.sort((u1, u2) ->
//            Double.compare(u2.getScore(), u1.getScore()));
//    displayList();
//}


//Scanner scanner = new Scanner(System.in);
//UserBusiness business = UserBusiness.getInstance();
//        while (true){
//                System.out.println("*********** QUẢN LÝ NGƯỜI DÙNG ***********");
//            System.out.print("Chọn");
//int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice){
//        case 1:
//        business.displayList();
//                            case 2:
//                            while (true){
//User user = new User();
//                        user.inputData(scanner);
//                        if (business.addUser(user)){
//        System.out.println("Thêm thành công");
//                        }
//                                System.out.println("Tiếp? (y/n): ");
//                      if (!scanner.nextLine().equalsIgnoreCase("y")){
//        break;
//        }
//        break;
//        }
//        break;
//        case 3:
//        System.out.println("Nhập id: ");
//                    business.updateUser(scanner.nextLine(), scanner);
//        case 4:
//        System.out.println("Nhập id: ");
//                    business.deleteUser(scanner.nextLine());
//        case 5:
//        System.out.println("Nhập tên cần tìm: ");
//                    business.searchName(scanner.nextLine());
//        case 6:
//        business.filterAdmin();
//                            case 7:
//                            business.sortByScore();