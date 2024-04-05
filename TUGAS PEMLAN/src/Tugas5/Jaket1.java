package Tugas5;
import java.util.Scanner;

public class Jaket1 {
    //untuk final harga
    private final double jaket_A = 100000;
    private final double jaket_B = 125000;
    private final double jaket_C = 175000;

    //untuk harga diskon
    private double jaketA_diskon = 95000;
    private double jaketB_diskon = 120000;
    private double jaketC_diskon = 160000;

    //untuk proses transaksi pembelian
    private boolean jaketA = false; private boolean bener = true; private boolean jaketB = false; private boolean jaketC = false;
    private int hargaBarang = 0; 
    private int kedua = 0; private double hargaJaketA = 0; private double hargaJaketB = 0; private double hargaJaketC  = 0;
    private int totalhargaJaketA = 0; private int totalhargaJaketB = 0; private int totalhargaJaketC  = 0; 
    public int noPilihan;
    public String daftarBarang;

    Scanner input = new Scanner (System.in);

    public void displayPilihan() {
        System.out.println("===================================");
        System.out.println("||SELAMAT DATANG DI CV. Labkomdas||");
        System.out.println("===================================");
        System.out.println("Daftar Barang");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s || %10s || \n", "Nama Produk", "Harga Produk");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s     || %12s || \n", "Jaket A", "Rp. 100.000");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s     || %12s || \n", "Jaket B", "Rp. 125.000");
        System.out.println("---------------------------------");
        System.out.printf("|| %5s     || %12s || \n", "Jaket C", "Rp. 175.000");
        System.out.println("---------------------------------");
        System.out.println("Pilih pembelian jaket anda:");
        System.out.println("1. Jaket A ");
        System.out.println("2. Jaket B");
        System.out.println("3. Jaket C");
        System.out.println("4. Keluar dari layanan");
    }

    public void setChoiceNumber(int pilihNomor) {
        this.noPilihan = pilihNomor;
    }

    public void getChoiceNumber() {
        boolean out = true;
        do {
            if (noPilihan == 1) {
                pembelian();
                break;
            } else if (noPilihan == 2) {
                pembelian();
                break;
            } else if (noPilihan == 3) {
               pembelian();
                break;
            } else if (noPilihan == 4) {
                out = false;
                System.out.println("Terima kasih sudah mengunjungi CV Labkomdas! Silakan berkunjung kembali ^^");
                System.exit(1);
            } else {
                System.out.println("Input tidak valid. Mohon masukkan input 1-4.");
            }
        } while (out);
    }

    public void pembelian(){
        Scanner sc = new Scanner(System.in);
        while (bener) {
            System.out.print("Masukkan pilihan anda ('4' untuk keluar): ");
            noPilihan = sc.nextInt();

           if (noPilihan == 4) {
                break;
            }

        switch (noPilihan) {
            case 1:
                hargaJaketA = jaket_A;
                jaketA = true;
                kedua = 1;
                break;
            case 2:
                hargaJaketB = jaket_B;
                jaketB = true;
                kedua = 2;
                break;
            case 3:
                hargaJaketC = jaket_C;
                jaketC = true;
                kedua = 3;
                break;
            default:
            System.out.println("Barang tidak ditemukan");
            break;
        }

        System.out.print("Masukkan jumlah: ");
        int jumlah = sc.nextInt();
        sc.nextLine();
            switch (kedua) {
            case 1:
            if(jumlah > 100){
                totalhargaJaketA += jaketA_diskon * jumlah;
                System.out.println("Anda berhak mendapatkan harga Rp. 95.000/pcs karena berbelanjan lebih dari 100 pcs");
            }else{
                totalhargaJaketA += jaket_A * jumlah;
            }
                break;
            case 2:
            if(jumlah > 100){
                totalhargaJaketB += jaketB_diskon * jumlah;
                System.out.println("Anda berhak mendapatkan harga Rp. 120.000/pcs karena berbelanjan lebih dari 100 pcs");
            }else{
                totalhargaJaketB += jaket_B * jumlah;
            }
                break;
            case 3:
            if(jumlah > 100){
                totalhargaJaketC += jaketC_diskon * jumlah;
                System.out.println("Anda berhak mendapatkan harga Rp. 160.000/pcs karena berbelanjan lebih dari 100 pcs");
            }else{
                totalhargaJaketC += jaket_C * jumlah;
            }
                break;
        }
    }
        hargaBarang = totalhargaJaketA + totalhargaJaketB + totalhargaJaketC;
        System.out.println("Total belanjaan anda senilai: Rp. " + hargaBarang + ",-");
}
}
