# Java Password Manager

A simple desktop password manager built with Java Swing.  
This project demonstrates basic secure storage and retrieval of passwords using AES encryption, file I/O, and a graphical interface.

---

## Features

- **AES Encryption:** All password data is encrypted and stored in `passwords.dat`.
- **Easy-to-Use GUI:** Manage and search your passwords in a simple table.
- **Master Password Protection:** Access is protected by a master password (default: `admin`).
- **Search Function:** Quickly filter your saved passwords.
- **Manual Decryption Utility:** Use `DecryptFile.java` to decrypt your data from the command line.

---

## Project Structure

```
PasswordManager/
├── src/
│   ├── DecryptFile.java
│   ├── EncryptionUtils.java
│   ├── LoginWindow.java
│   ├── MainAppWindow.java
│   ├── PasswordEntry.java
│   └── PasswordStorage.java
├── .project
├── .classpath
├── README.md
└── passwords.dat (created after first run)
```

- **All Java source files (`.java`) are inside the `src/` folder.**
- Project configuration files (`.project`, `.classpath`) and documentation (`README.md`) are at the root.

---

## Quick Start

1. **Download or clone** this project.
2. Open Eclipse and choose **File > Import > Existing Projects into Workspace**.
3. Select the folder containing this project (where the `.project` file is).
4. **Run `MainAppWindow.java`** from the `src/` folder.
5. **Login** with the default master password:  
   ```
   admin
   ```
6. Start adding, searching, and managing your passwords.

---

## Decrypting Saved Passwords

All passwords and usernames are encrypted using your master password and stored in the `passwords.dat` file.  
If you want to decrypt the saved data outside the main application, use the provided `DecryptFile.java` utility:

### How to Use `DecryptFile.java`

1. **Compile** the class together with `EncryptionUtils.java` (both must be in the same `src/` folder).
2. **Run** the `DecryptFile` class:
   - In Eclipse: Right-click `DecryptFile.java` → Run As → Java Application.
   - Or via command line:
     ```sh
     javac src/*.java
     java -cp src DecryptFile
     ```
3. **Enter your master password** when prompted.
4. The program will print all decrypted website, username, and password entries from `passwords.dat` to the console.

> **Note:** If you forget your master password, the encrypted data cannot be recovered.

---

## Security Note

- Passwords are encrypted with AES, but the master password is fixed for demonstration.
- **Do not use this project to store real or sensitive data.**
- For real-world use, consider:
  - Secure storage and hashing of the master password.
  - Stronger key derivation (PBKDF2, bcrypt).
  - Enhanced error handling and security practices.

---

## License

MIT License – Free for personal and educational use.

---

## Author

amxxxmelhem

---

> **This project is for learning and demonstration. Not for production use.**
