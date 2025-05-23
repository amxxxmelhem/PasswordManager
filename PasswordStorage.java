import java.util.*;
import java.io.*;

public class PasswordStorage {
    private static final String FILE_NAME = "passwords.dat";

    public static void saveEntries(List<PasswordEntry> entries, String masterPassword) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (PasswordEntry entry : entries) {
            sb.append(entry.getWebsite()).append("|||")
              .append(entry.getUsername()).append("|||")
              .append(entry.getPassword()).append("\n");
        }
        // ENCRYPT before saving!
        String encrypted = EncryptionUtils.encrypt(sb.toString(), padKey(masterPassword));
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write(encrypted);
        }
    }

    public static List<PasswordEntry> loadEntries(String masterPassword) throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        StringBuilder encrypted = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                encrypted.append(line);
            }
        }
        // DECRYPT after loading!
        String decrypted = EncryptionUtils.decrypt(encrypted.toString(), padKey(masterPassword));
        List<PasswordEntry> entries = new ArrayList<>();
        for (String line : decrypted.split("\n")) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split("\\|\\|\\|");
            if (parts.length == 3) {
                entries.add(new PasswordEntry(parts[0], parts[1], parts[2]));
            }
        }
        return entries;
    }

    // Pad key to 16 characters for AES
    private static String padKey(String key) {
        if (key.length() >= 16) return key.substring(0, 16);
        return String.format("%-16s", key).replace(' ', '0');
    }
}