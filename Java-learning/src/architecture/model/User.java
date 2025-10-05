package architecture.model;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String role;
    private int gold;

    public User(int id, String username, String email, String password, String role, int gold) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gold = gold;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getGold() {
        return gold;
    }

    public String toString() {
        return
                "id: " + id + "\n" +
                "Никнейм: " + username + "\n" +
                "Почта: " + email + "\n" +
                "Пароль: " + password + "\n" +
                "Права: " + role + "\n" +
                "Золото: " + gold;
    }
}
