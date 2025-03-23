import java.util.Scanner;

// Superclass utk semua karakter dalam game
class KarakterGame {
    private final String nama; // Nama karakter (ga bisa diubah setelah dibuat)
    private int kesehatan; // Kesehatan karakter yg bisa berubah

    // Konstruktor utk menginisialisasi karakter dengan nama dan kesehatan
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Getter utk mendapatkan nama karakter
    public String getNama() {
        return nama;
    }

    // Getter utk mendapatkan nilai kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }

    // Setter utk mengubah nilai kesehatan karakter
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Method utk menampilkan informasi karakter
    public void tampilkanInfo() {
        System.out.println(">> " + nama + " memiliki kesehatan: " + kesehatan);
    }

    // Method serang yang akan dioverride oleh subclass
    public void serang(KarakterGame target) {
        System.out.println(">> " + nama + " menyerang " + target.getNama());
    }

    // Method utk mengecek apakah karakter masih hidup
    public boolean masihHidup() {
        return kesehatan > 0;
    }
}

// Subclass Pahlawan (turunan dari KarakterGame)
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan); // Memanggil konstruktor superclass
    }

    // Override method serang dengan efek serangan khas Pahlawan
    @Override
    public void serang(KarakterGame target) {
        System.out.println("\n>> " + getNama() + " menyerang " + target.getNama() + " menggunakan tombak suci!");
        target.setKesehatan(target.getKesehatan() - 25); // Mengurangi kesehatan enemy sebesar 25
        System.out.println("> Damage yang diberikan sebesar 25 point");
        System.out.println(">>> " + target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan() + " point");
    }
}

// Subclass Musuh (turunan dari KarakterGame)
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan); // Memanggil konstruktor superclass
    }

    // Override method serang dengan efek serangan khas Musuh
    @Override
    public void serang(KarakterGame target) {
        System.out.println("\n>> " + getNama() + " menyerang " + target.getNama() + " dengan api neraka!");
        target.setKesehatan(target.getKesehatan() - 18); // Mengurangi kesehatan enemy sebesar 18
        System.out.println("> Damage yang diberikan sebesar 18 point");
        System.out.println(">>> " + target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan() + " point");
    }
}

// Kelas utama
public class Main {
    static Pahlawan sentinel = new Pahlawan("Sentinel", 170); // Objek Pahlawan
    static Musuh revenant = new Musuh("Revenant", 220); // Objek Musuh

    // Method utk menampilkan status karakter
    public static void statusKarakter() {
        System.out.println("\n======== Status Karakter ========\n");
        sentinel.tampilkanInfo();
        revenant.tampilkanInfo();
        System.out.println("\n=================================");
    }

    // Method utk pilih karakter yg akan dimainkan
    public static KarakterGame[] pilihKarakter(Scanner scanner) {
        KarakterGame user = null;
        KarakterGame enemy = null;

        // looping sampai user pilih karakter yg valid
        while (user == null) {
            System.out.println("\n=== Selamat datang di Game Pertarungan Karakter! ===\n");
            System.out.println("Pilih karakter yang ingin digunakan:");
            System.out.println("1. " + sentinel.getNama());
            System.out.println("2. " + revenant.getNama());
            System.out.print("Masukkan pilihan (1/2): ");

            int pilihan = scanner.nextInt(); // Menerima input dari user

            switch (pilihan) {
                case 1 -> {
                    user = sentinel;
                    enemy = revenant;
                }
                case 2 -> {
                    user = revenant;
                    enemy = sentinel;
                }
                default -> System.out.println("Pilihan tidak valid! Silakan pilih kembali.");
            }
        }

        return new KarakterGame[]{user, enemy}; // Mengembalikan karakter yang dipilih
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean mainLagi = true; // Flag utk menentukan apakah ingin bermain lagi

            while (mainLagi) {
                // pilih karakter sebelum memulai pertarungan
                KarakterGame[] karakter = pilihKarakter(scanner);
                KarakterGame user = karakter[0];
                KarakterGame enemy = karakter[1];

                System.out.println("\nAnda pilih: " + user.getNama());
                System.out.println("Lawan Anda adalah: " + enemy.getNama());

                // looping utama pertarungan
                while (user.masihHidup() && enemy.masihHidup()) {
                    System.out.println("\n=== Giliran Anda ===");
                    System.out.println("1. Serang enemy");
                    System.out.println("2. Cek kesehatan");
                    System.out.println("3. Pilih ulang karakter");
                    System.out.print("Pilihan Anda (1-3): ");

                    int pilihan = scanner.nextInt(); // Menerima input dari user

                    switch (pilihan) {
                        case 1 -> user.serang(enemy); // Jika pilih menyerang
                        case 2 -> { // Jika pilih cek kesehatan
                            user.tampilkanInfo();
                            enemy.tampilkanInfo();
                        }
                        case 3 -> { // Jika pilih ulang karakter
                            System.out.println("pilih ulang karakter...");
                            mainLagi = true; // Mengatur ulang permainan
                            break;
                        }
                        default -> System.out.println("Pilihan tidak valid, giliran Anda dilewati!");
                    }

                    if (pilihan == 3) break; // Keluar dari loop jika pilih ulang karakter
                }

                // Jika user pilih ulang karakter, ulangi pemilihan karakter
                if (user.masihHidup() && enemy.masihHidup()) {
                    continue;
                }

                // Menentukan pemenang setelah pertarungan selesai
                System.out.println("\n====== Game Selesai ======\n");

                if (user.masihHidup()) {
                    System.out.println("Selamat! " + user.getNama() + " memenangkan pertarungan!");
                } else {
                    System.out.println(enemy.getNama() + " memenangkan pertarungan!");
                }

                // Menampilkan status karakter setelah bertarung
                statusKarakter();

                // Menanyakan apakah user ingin bermain lagi
                System.out.print("\nApakah Anda ingin bermain lagi? (y/n): ");
                char ulang = scanner.next().charAt(0); // Menerima input ulang dari user
                if (ulang == 'n' || ulang == 'N') {
                    mainLagi = false; // Menghentikan permainan
                }
            }

            System.out.println("\n===== Terima kasih telah bermain! =====\n\n"); // Pesan akhir permainan
        }
    }
}
