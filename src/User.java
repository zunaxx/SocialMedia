public class User {
    private static int nextUserId = 1;
    private int userId;
    private String username;
    private String email;
    private int password;
    private Profile profile;

    public User(String username, String email, int password, Profile profile) {
        this.userId = nextUserId++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public static int getNextUserId() {
        return nextUserId;
    }

    public static void setNextUserId(int nextUserId) {
        User.nextUserId = nextUserId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", profile=" + profile +
                '}';
    }
}
