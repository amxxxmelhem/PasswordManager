# Java Password Manager

A simple desktop password manager built with Java Swing.  
This project demonstrates basic secure storage and retrieval of passwords using AES encryption, file I/O, and a graphical interface.

---

## Features

- **AES Encryption**: All password data is encrypted and stored in `passwords.dat`.
- **Easy-to-Use GUI**: Manage and search your passwords in a simple table.
- **Master Password**: Protects access to your password vault (default: `admin`).
- **Search Function**: Quickly filter your saved passwords.

---

## Quick Start

1. **Download or clone** this project.
2. Open Eclipse and choose **File > Import > Existing Projects into Workspace**.
3. Select the folder containing this project (where the `.project` file is).
4. **Run `MainAppWindow.java`**.
5. **Login** with the default master password:  
   ```
   admin
   ```

---

## File Structure

```
src/
  EncryptionUtils.java
  LoginWindow.java
  MainAppWindow.java
  PasswordEntry.java
  PasswordStorage.java
.project
.classpath
passwords.dat (created after first run)
```

---

## Security Note

- Passwords are encrypted with AES, but the master password is fixed for demonstration.
- **Do not use this project to store real or sensitive data.**
- Improvements for real-world use could include:
  - Secure storage and hashing of the master password
  - Stronger key derivation (PBKDF2, bcrypt)
  - Enhanced error handling

---

## License

MIT License – Free for personal and educational use.

---

## Author

amxxxmelhem

---

> **This project is for learning and demonstration. Not for production use.**