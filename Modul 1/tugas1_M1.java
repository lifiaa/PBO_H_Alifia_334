import java.util.Scanner;

public class tugas1_M1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan tiga digit terakhir NIM Anda: ");
            String NIM = input.nextLine();

            String usernameBenar = "Admin" + NIM;
            String passwordBenar = "Password" + NIM;

            System.out.print("Masukkan username: ");
            String username = input.nextLine();
            System.out.print("Masukkan password: ");
            String password = input.nextLine();

            if (username.equals(usernameBenar) && password.equals(passwordBenar)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login Admin gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama Anda: ");
            String nama = input.nextLine();
            System.out.print("Masukkan NIM Anda: ");
            String nim = input.nextLine();

            // Contoh validasi dengan data hardcoded
            String namaValid = "Alifia Nadia Ruksana";
            String nimValid = "202410370110334";

            if (nama.equalsIgnoreCase(namaValid) && nim.equals(nimValid)) {
                System.out.println("Login Mahasiswa berhasil!");
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}