
import java.time.LocalDateTime;
import java.util.Scanner;

public class codelab1_M1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n=== Program Biodata ===");

        System.out.print("Masukkan nama lengkap: ");
        String nama = input.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelamin = input.nextLine().trim();
        
        String gender;
        if (jenisKelamin.equalsIgnoreCase("P") || jenisKelamin.equalsIgnoreCase("p")) {
            gender = "Perempuan";
        } else if (jenisKelamin.equalsIgnoreCase("L") || jenisKelamin.equalsIgnoreCase("l")) {
            gender = "Laki-laki";
        } else {
            gender = "Tidak valid";
        }
        
        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = input.hasNextInt() ? input.nextInt() : 0;
        input.nextLine(); // Membersihkan buffer
        System.out.println("=== ================ ===\n");

        int tahunSekarang = LocalDateTime.now().getYear();
        int umur = (tahunLahir > 0) ? (tahunSekarang - tahunLahir) : 0;

        System.out.println("\n=== Biodata Pengguna ===");
        System.out.printf("Nama         : %s%n", nama);
        System.out.printf("Jenis Kelamin: %s%n", gender);
        System.out.printf("Umur         : %d tahun%n", (umur > 0) ? umur : 0);
        System.out.println("=== ================ ===\n");
        
        input.close();
    }
}
