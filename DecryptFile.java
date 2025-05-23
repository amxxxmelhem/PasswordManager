import java.nio.file.*;
public class DecryptFile {
    public static void main(String[] args) throws Exception {
        String encrypted = new String(Files.readAllBytes(Paths.get("passwords.dat")));
        String key = padKey("admin"); // use your real master password if it's not admin
        String decrypted = EncryptionUtils.decrypt(encrypted, key);
        System.out.println(decrypted);
    }
    private static String padKey(String key) {
        if (key.length() >= 16) return key.substring(0, 16);
        return String.format("%-16s", key).replace(' ', '0');
    }
}