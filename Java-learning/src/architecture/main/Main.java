package architecture.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start!");
        Scanner CONSOLE = new Scanner(System.in);
        boolean flag = true;
        boolean login = false;

        int id = 0;
        String username = null;
        String email = null;
        String password = null;
        String role = "user";


        while (flag) {
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
                        System.out.println("Вы уже вошли в аккаунт!\n");
                        break;
                    }

                    System.out.println("Регистрация!\n");
                    System.out.print("Введите никнейм: ");
                    String usernameRegister = CONSOLE.nextLine();
                    System.out.print("Введите почту: ");
                    String emailRegister = CONSOLE.nextLine();
                    System.out.print("Введите пароль: ");
                    String passwordRegister = CONSOLE.nextLine();

                    if (usernameRegister.isEmpty() || emailRegister.isEmpty() || passwordRegister.isEmpty()) {
                        System.out.println("Ошибка при регистрации! \n");
                        break;
                    }

                    if (usernameRegister.length() < 3) {
                        System.out.println("Никнейм слишком короткий! Необходим никнейм от 3 символов!\n");
                        break;
                    }

                    if (passwordRegister.length() < 6) {
                        System.out.println("Пароль должен слишком короткий! Необходим пароль от 6 символов!\n");
                        break;
                    }

                    id++;
                    username = usernameRegister;
                    email = emailRegister;
                    password = passwordRegister;

                    System.out.println("Регистрация прошла успешно!\n");
                    break;

                case 2:
                    System.out.println();
                    if (login) {
                        System.out.println("Вы уже вошли в аккаунт!\n");
                        break;
                    }

                    System.out.println("Вход!\n");
                    System.out.print("Введите никнейм: ");
                    String usernameLogin = CONSOLE.nextLine();
                    System.out.print("Введите пароль: ");
                    String passwordLogin = CONSOLE.nextLine();

                    if (!usernameLogin.equals(username) || !passwordLogin.equals(password)) {
                        System.out.println("Неверный никнейм или пароль!\n");
                        break;
                    }

                    System.out.print("Вход выполнен успешно!\n");
                    login = true;
                    break;

                case 3:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    System.out.println("Информация об аккаунте: " + username + "!\n");
                    System.out.println(
                            "ID: " + id + "\n" +
                            "Никнейм: " + username + "\n" +
                            "Почта: " + email + "\n" +
                            "Пароль: " + password + "\n" +
                            "Роль: " + role + "\n"
                    );
                    break;

                case 4:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    System.out.println("Смена никнейма!\n");
                    System.out.print("Введите новый никнейм: ");
                    String newUsername = CONSOLE.nextLine();

                    if (newUsername.isEmpty()) {
                        System.out.println("Никнейм не может быть пустым!\n");
                        break;
                    }

                    System.out.println("Никнейм успешно изменён!\n");
                    username = newUsername;
                    break;

                case 5:
                    System.out.println();
                    if (!login) {
                        System.out.println("Вы не вошли в аккаунт!\n");
                        break;
                    }

                    System.out.println("Смена пароля!\n");
                    System.out.print("Введите новый пароль: ");
                    String newPassword = CONSOLE.nextLine();

                    if (newPassword.isEmpty()) {
                        System.out.println("Пароль не может быть пустым!\n");
                        break;
                    }

                    if (newPassword.length() < 6) {
                        System.out.println("Пароль должен быть минимум от 6 символов!\n");
                        break;

                    }

                    System.out.println("Пароль успешно изменён!\n");
                    password = newPassword;
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
                    if (role.equals("admin")) {
                        System.out.println("Система убита!");
                        flag = false;
                    }
                    else {
                        System.out.println("У Вас недостаточно прав для выполнения этой команды!\n");
                    }
                    break;

                default:
                    System.out.println();
                    System.out.println("Команда не распознана!\n");
                    break;
            }
        }
    }
}