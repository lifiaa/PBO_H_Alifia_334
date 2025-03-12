class rekeningBank{
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    public rekeningBank(String nomorRekening, String namaPemilik, double saldo){
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void tampilkanInfo(){
        System.out.println("=======================================");
        System.out.println("Informasi Rekening:");
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik   : " + namaPemilik);
        System.out.println("Saldo          : Rp." + saldo);
        System.out.println("=======================================");
        System.out.println();
    }

    public void setorUang(double jumlah){
        if(jumlah > 0){
            saldo =+ jumlah;
            System.out.printf(">>> %s menyetor Rp.%.2f. Saldo sekarang: Rp.%.2f%n%n", namaPemilik, jumlah, saldo);
        } else{
            System.out.println(">>> Jumlah setor harus lebih dari 0.%n%n");
        }
    }

    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.printf(">> %s menarik Rp%.2f. Saldo sekarang: Rp%.2f%n%n", namaPemilik, jumlah, saldo);
        } else {
            System.out.printf(">> %s menarik Rp%.2f. (Gagal, saldo tidak mencukupi) Saldo saat ini: Rp%.2f%n%n", namaPemilik, jumlah, saldo);
        }
    }
}

public class Mainn{
    public static void main(String[] args){
        rekeningBank rek1 = new rekeningBank("202410370110334", "Alifia", 7000000);
        rekeningBank rek2 = new rekeningBank("202410370110381", "Ayshea", 5000000);

        rek1.tampilkanInfo();
        rek2.tampilkanInfo();

        rek1.setorUang(2000000);
        rek2.tarikUang(8000000);
        rek2.tarikUang(2000000);

        rek1.tampilkanInfo();
        rek2.tampilkanInfo();
    }
}