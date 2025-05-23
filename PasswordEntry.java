import java.io.Serializable;

public class PasswordEntry implements Serializable {
    private String website;
    private String username;
    private String password;

    public PasswordEntry(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public String getWebsite() { return website; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}