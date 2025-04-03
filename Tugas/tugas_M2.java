import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Admin{
    private final String username = "admin";
    private final String password = "Admin123";
    
    public boolean login(String inputUsername, String inputPassword){
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

class Mahasiswa{
    private final String nama;
    private final String nim;
    private final String prodi = "Informatika";
    private final int usia = 19;
    private final String asal = "Kalimantan Tengah/Pangkalan Bun";
    
    public Mahasiswa(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }
    public boolean login(String inputNama, String inputNim){
        return nama.equals(inputNama) && nim.equals(inputNim);
    }
    public void tampilkanInfo(){
        System.out.println("\n==== Informasi Mahasiswa ====");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Prodi: " + prodi);
        System.out.println("Usia: " + usia);
        System.out.println("Asal: " + asal);
        System.out.println("=============================\n");
    }
}

//main class
public class tugas_M2 {
    private static final Map<String, Mahasiswa> mahasiswaDB = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    
    public static void main(String[] args) {
        //database simulasi
        mahasiswaDB.put("202410370110334", new Mahasiswa("Alifia Nadia Ruksana", "202410370110334"));
        // mahasiswaDB.put("202410370110379", new Mahasiswa("Ayshea Marvella Pasha", "202410370110379"));

        Admin admin = new Admin();

        //login system
        while (true) { 
            System.out.println("\n\n=== Selamat datang di Sistem Login! ===");
            System.out.println(">> Masukkan jenis login (Admin/Mahasiswa): ");
            String role = scanner.nextLine().trim().toLowerCase();
    
            switch (role) {
                case "admin" -> loginAdmin(admin);
                case "mahasiswa" -> loginMahasiswa();
                default -> System.out.println("Jenis login tidak valid!");
            }   
            
            System.out.println("Apakah Anda ingin login ulang? (ya/tidak): ");
            String pilihan = scanner.nextLine().trim().toLowerCase();
            if (!pilihan.equals("ya")) {
                break;
            }
        }
    }

    private static void loginAdmin(Admin admin){
        while (true) { 
            System.out.println("\n==== Login Admin ====");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
    
            if(admin.login(username, password)){
                System.err.println("\n=================================================");
                System.out.println("Login admin berhasil! ID Tiket: " + generateTicketID());
                System.err.println("=================================================");
            } else{
                System.err.println("\n=================================================");
                System.out.println("Login admin gagal! Username atau password salah.");
                System.err.println("=================================================");
            }

            break;
        }
    }
    
    private static void loginMahasiswa(){
        while (true) { 
            System.out.println("\n==== Login Mahasiswa ====");
            System.out.print("username: ");
            String inputNama = scanner.nextLine();
            System.out.print("password: ");
            String inputNim = scanner.nextLine();
            
            Mahasiswa mahasiswa = mahasiswaDB.get(inputNim);
            
            if(mahasiswa != null && mahasiswa.login(inputNama, inputNim)){
                mahasiswa.tampilkanInfo();
            } else{
                System.err.println("\n============================================");
                System.out.println("Login mahasiswa gagal! Nama atau NIM salah.");
                System.err.println("============================================\n");
            }

            break;
        }   
    }
    
    private static String generateTicketID(){
        return "Tiket-" + (1000 + random.nextInt(9000));
    }
}
