package Tugas5;
import java.util.Scanner;

public class TestAritmatika1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        boolean bener = true;

        //khusus untuk non-static
        Aritmatika1 tes = new Aritmatika1();
       
        while(bener){
            System.out.println("====================================");
            System.out.println("||SELAMAT DATANG DI OPERASI HITUNG||");
            System.out.println("====================================");
            System.out.println("Pilih layanan jasa kami:");
            System.out.println("1. Penjumlahan ");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Penyederhanaan Pecahan");
            System.out.println("6. Keluar dari program");
            System.out.println("Masukkan pilihan anda: ");
            int pilihan = input.nextInt();
    
            switch (pilihan) {   
            //penjumlahan
                case 1:
                System.out.print("Masukkan bilangan 1 : ");
                double bil1 = input.nextDouble();
        
                System.out.print("Masukkan bilangan 2 : ");
                double bil2 = input.nextDouble();
                Aritmatika1.hitungPenjumlahan(bil1, bil2);
                    break;

            //pengurangan
                case 2:
                System.out.print("Masukkan bilangan 1 : ");
                double nil1 = input.nextDouble();
    
                System.out.print("Masukkan bilangan 2 : ");
                double nil2 = input.nextDouble();
                Aritmatika1.hitungPengurangan(nil1, nil2);
                break;

            //perkalian
                case 3:
                System.out.println("Masukkan bilangan 1: ");
                double kali1 = input.nextDouble();
    
                System.out.println("Masukkan bilangan 2: ");
                double kali2 = input.nextDouble();
                tes.hitungPerkalian(kali1, kali2);
                break;

            //pembagian
                case 4:
                System.out.println("Masukkan bilangan 1: ");
                double bagi1 = input.nextDouble();
    
                System.out.println("Masukkan bilangan 2: ");
                double bagi2 = input.nextDouble();
                tes.hitungPembagian(bagi1, bagi2);
                break;

            //penyederhanaan pecahan
                case 5:
                System.out.println("Masukkan pembilang: ");
                int nilai1 = input.nextInt();
    
                System.out.println("Masukkan penyebut: ");
                int nilai2 = input.nextInt();
                tes.sederhana(nilai1, nilai2);
                break;

            //keluar program
                case 6:
                System.out.println("Program berhenti, terima kasih sudah mengunjungi layanan kami^^");
                System.exit(1);
                break;

                default:
                System.out.println("Input tidak valid, silahkan input 1-6!");
                    break;
            }
        }
    }
}
