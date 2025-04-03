import java.util.Scanner;

// Superclass User
class User {
    private String nama;
    private String nim;

    // Constructor
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Method login (akan di-override)
    public boolean login(String inputNama, String inputNim) {
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    // Method displayInfo (akan di-override)
    public void displayInfo() {
        System.out.println("Nama: " + nama + ", NIM: " + nim);
    }
}

// Subclass Admin
class Admin extends User {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil! Selamat datang, " + getNama());
    }
}

// Subclass Mahasiswa
class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return super.login(inputNama, inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil! Selamat datang, " + getNama());
    }
}

// Kelas utama untuk menjalankan sistem login
public class M3_LoginSystem {
    public static void main(String[] args) {
        // Membuat objek Admin dan Mahasiswa
        try (Scanner scanner = new Scanner(System.in)) {
            // Membuat objek Admin dan Mahasiswa
            Admin admin = new Admin("Admin Satu", "0001", "admin", "1234");
            Mahasiswa mahasiswa = new Mahasiswa("Budi", "210001");
            
            System.out.println("Pilih peran: 1. Admin  2. Mahasiswa");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline
            switch (pilihan) {
                case 1 -> {
                    // Login sebagai Admin
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();
                    if (admin.login(username, password)) {
                        admin.displayInfo();
                    } else {
                        System.out.println("Login gagal! Username atau password salah.");
                    }
                }
                case 2 -> {
                    // Login sebagai Mahasiswa
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    if (mahasiswa.login(nama, nim)) {
                        mahasiswa.displayInfo();
                    } else {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
