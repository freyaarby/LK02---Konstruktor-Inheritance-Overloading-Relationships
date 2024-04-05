package Tugas5;


public class Aritmatika1 {
        //static untuk penjumlahan dan pengurangan
        public static void hitungPenjumlahan(double x, double y){
            double total = x + y;
            System.out.println("Total penjumlahan adalah senilai: " + total);
        }
    
        public static void hitungPengurangan(double x, double y){
            double total = x - y;
            System.out.println("Total pengurangan adalah senilai: " + total);
        }
    
        //non static  untuk perkalian, pembagian, dan pecahan (namanya sederhana)
        public void hitungPerkalian(double x, double y){
            double total = x * y;
            System.out.println("Total perkalian adalah senilai: " + total);
        }
    
        public void hitungPembagian(double x, double y){
            double total = x / y;
            System.out.println("Total pembagian adalah senilai: " + total);
        }
    
        //menyederhanakan pecahan
        //mencari FPB
    public int cariFPB(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // menyederhanakan pecahan
    public void sederhana(int pembilang, int penyebut) {
        // Cari FPB dari pembilang dan penyebut
        int fpb = cariFPB(pembilang, penyebut);
        
        // Sederhanakan pecahan dengan membagi pembilang dan penyebut dengan FPB
        pembilang /= fpb;
        penyebut /= fpb;
        
        double desimalSederhana = (double) pembilang / penyebut;
        
        
        // Tampilkan pecahan yang disederhanakan
        System.out.println("Pecahan setelah disederhanakan: " + pembilang + "/" + penyebut);
        //desimal
        System.out.println( "Dalam penyederhanaan desimal: " + desimalSederhana);
    }
    }

 

    

