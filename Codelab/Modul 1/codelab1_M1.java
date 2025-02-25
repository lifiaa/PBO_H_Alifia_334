import java.util.Scanner;

public class codelab1_M1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelamin = input.nextLine();

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = input.nextInt();

        int tahunSekarang = 2025;
        int umur = tahunSekarang - tahunLahir;

        System.out.println("Nama: " + nama);
        System.out.println("Jenis kelamin: " + jenisKelamin);
        System.out.println("Umur: " + umur);

        input.close();
    }
}