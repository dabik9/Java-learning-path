package architecture.main;
import architecture.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private User user = null;
    public List<User> userList = new ArrayList<>();
    private boolean flag = true;
    private boolean login = false;
    private final Scanner CONSOLE = new Scanner(System.in);

    private void beforeStart() {
        userList.add(new User(0, "admin", "admin@gmail.com", "admin", "admin", 1000));
        userList.add(new User(0, "moderator", "moderator@gmail.com", "moderator", "moderator", 500));
        userList.add(new User(0, "player7453", "test@gmail.com", "parol", "user", 100));
        userList.add(new User(0, "player7454", "test@gmail.com", "parol", "user", 100));
        userList.add(new User(0, "player7455", "test@gmail.com", "parol", "user", 0));
        userList.add(new User(0, "player7456", "test@gmail.com", "parol", "user", 90));
        userList.add(new User(0, "player7582", "test@gmail.com", "parol", "user", 250));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.beforeStart();
        main.menu();
    }


    public void menu() {
        System.out.println("Start!");
        Scanner CONSOLE = new Scanner(System.in);
        boolean flag = true;
        boolean login = false;
        User user = null;
        while (flag) {
            System.out.println();
            System.out.println("Меню: ");
            System.out.println();
            System.out.println("""
                    1. Регистрация \
                    
                    2. Вход \
                    
                    3. Информация об аккаунте \
                    
                    4. Смена никнейма \
                    
                    5. Смена пароля \
                    
                    6. Выход \
                    
                    7. Убить систему
                    """);

            System.out.print("Выберите команду: ");
            int choice = CONSOLE.nextInt();
            CONSOLE.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    if (login) {
                        System.out.println("Вы уже вошли в аккаунт! Выйдите из него, чтобы зарегистрироваться!");
                        break;
                    }

                    this.registerUser();
                    break;

                case 2:
                    if (login) {
                        System.out.println("Вы уже вошли в аккаунт!\n");
                        break;
                    }

                    user = this.login();

                    if (user != null) {
                        System.out.println("Вы успешно вошли в аккаунт!\n");
                        login = true;
                        this.user = user;
                    }

                    break;

                case 3:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    this.userInfo();
                    break;

                case 4:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    this.setNewUsername();
                    break;

                case 5:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    this.setNewPassword();
                    break;

                case 6:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    System.out.println("Выход!\n");
                    login = false;
                    break;

                case 7:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    this.deathProgram();
                    break;

                default:
                    System.out.println();
                    System.out.println("Команда не распознана!\n");
                    break;
            }
        }
    }

    public void registerUser () {
        System.out.print("Введите ник: ");
        String username = CONSOLE.nextLine().trim();
        System.out.print("Введите почту: ");
        String email = CONSOLE.nextLine().trim();
        System.out.print("Введите пароль: ");
        String password = CONSOLE.nextLine().trim();

        if (username.isBlank()) {
            System.out.println("Ник пустой");
            return;
        }

        if (email.isBlank()) {
            System.out.println("Почта пустая");
            return;
        }

        if (password.isBlank()) {
            System.out.println("Пароль пустой");
            return;
        }

        for (User userLocal : userList) {
            if (userLocal.getUsername().equals(username)) {
                System.out.println("Данный ник уже зарегистрирован!");
                return;
            }

            if (userLocal.getEmail().equals(email)) {
                System.out.println("Данная почта уже зарегистрирована!");
                return;
            }
        }

        System.out.println("Регистрация успешна!");
        System.out.println("Аккаунт с ником: " + username + " успешно создан!\n");
        userList.add(new User(username, email, password));
    }

    public User login () {
        System.out.print("Введите ник: ");
        String username = CONSOLE.nextLine().trim();
        System.out.print("Введите пароль: ");
        String password = CONSOLE.nextLine().trim();

        if (username.isBlank()) {
            System.out.println("Ник пустой");
            return null;
        }

        if (password.isBlank()) {
            System.out.println("Пароль пустой");
            return null;
        }

        for (User userLocal : userList) {
            if (userLocal.getUsername().equals(username)) {
                if (userLocal.getPassword().equals(password)) {
                    return userLocal;
                } else {
                    System.out.println("Неверный пароль!\n");
                    return null;
                }
            }
        }

        System.out.println("Аккаунт с ником " + username + " не найден!\n");
        return null;
    }

    public void userInfo () {
        System.out.println("Информация об аккаунте: " + user.getUsername() + "!\n");
        System.out.println(user.toString());
    }

    public void setNewUsername () {
        System.out.println("Смена никнейма!\n");
        System.out.print("Введите новый никнейм: ");
        String newUsername = CONSOLE.nextLine().trim();

        if (newUsername.isBlank()) {
            System.out.println("Новый ник не может быть пустым!");
            return;
        }

        if (newUsername.equals(user.getUsername())) {
            System.out.println("Вы не изменили ник!");
            return;
        }

        for (User userLocal : userList) {
            if (userLocal.getUsername().equals(newUsername)) {
                System.out.println("Невозможно сменить ник! Аккаунт с таким ником уже существует, выбери другой ник!");
                return;
            }
        }

        user.setUsername(newUsername);
    }

    public void setNewPassword () {
        System.out.println("Смена пароля!\n");
        System.out.print("Введите новый пароль: ");
        String newPassword = CONSOLE.nextLine();

        if (newPassword.isBlank()) {
            System.out.println("Пароль не может быть пустым!\n");
            return;
        }

        if (newPassword.length() < 6) {
            System.out.println("Пароль должен быть минимум от 6 символов!\n");
            return;

        }

        System.out.println("Пароль успешно изменён!\n");
        user.setPassword(newPassword);
    }

    public void deathProgram () {
        if (user.getRole().equals("admin")) {
            System.out.println("Система убита!");
            flag = false;
        } else {
            System.out.println("У Вас недостаточно прав для выполнения этой команды!\n");
        }
    }
}
