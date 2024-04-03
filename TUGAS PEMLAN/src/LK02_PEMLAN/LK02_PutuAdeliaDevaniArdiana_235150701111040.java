package LK02_PEMLAN;
import java.util.ArrayList;
import java.util.Scanner;

// Kelas Driver dengan atribut no_sim dan nama
class Driver {
    public String no_sim;
    public String nama;

    public Driver(String no_sim, String nama) {
        this.no_sim = no_sim;
        this.nama = nama;
    }
}

// Kelas Penumpang dengan atribut nama
class Penumpang {
    public String nama;

    public Penumpang(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return this.nama;
    }
}

// Kelas Kendaraan sebagai kelas dasar
class Kendaraan {
    public String platNomor; 
    public int jumlahPenumpang; 
    public int maxPenumpang;
    public Driver supir; // Jawaban Soal 4: Relasi OneToOne dengan Driver
    public ArrayList<Penumpang> penumpangList = new ArrayList<>(); // Jawaban Soal 4: Relasi OneToMany dengan Penumpang

    // Jawaban Soal 1: Konstruktor dengan parameter
    public Kendaraan(String platNomor, int maxPenumpang) {
        this.platNomor = platNomor;
        this.maxPenumpang = maxPenumpang;
        this.jumlahPenumpang = 0;
    }

    // Fungsi untuk menambah jumlah penumpang
    public void penumpangNaik(String namaPenumpang) throws Exception { 
        if (this.jumlahPenumpang + 1 > this.maxPenumpang) {
            throw new Exception("Maaf penumpang melebihi kapasitas"); 
        } else {
            Penumpang penumpangBaru = new Penumpang(namaPenumpang);
            this.penumpangList.add(penumpangBaru);
            this.jumlahPenumpang++;
            System.out.println(namaPenumpang + " berhasil naik");
        }
        cekPenumpang();
    }

    // Fungsi untuk mengurangi jumlah penumpang
    public void penumpangTurun(String namaPenumpang) throws Exception { // Jawaban Soal 2: Tambahkan fungsi penumpangTurun
        boolean found = false;
        for (Penumpang p : this.penumpangList) {
            if (p.nama.equals(namaPenumpang)) {
                this.penumpangList.remove(p);
                this.jumlahPenumpang--;
                System.out.println(namaPenumpang + " berhasil turun");
                found = true;
                break;
            }
        }
        if (!found) {
            throw new Exception("Penumpang dengan nama " + namaPenumpang + " tidak ditemukan"); // Jawaban Soal 2: Eksepsi jika penumpang tidak ditemukan
        }
        cekPenumpang();
    }

    // Fungsi untuk menampilkan info penumpang
    public void cekPenumpang() {
        System.out.println("Penumpang saat ini  : " + this.jumlahPenumpang);
        System.out.println("Sisa Kapasitas      : " + (this.maxPenumpang - this.jumlahPenumpang));
        if (!penumpangList.isEmpty()) {
            System.out.println("Daftar Penumpang:");
            for (Penumpang p : penumpangList) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("Belum ada penumpang");
        }
    }

    // Fungsi untuk menampilkan SIM supir
    public void showDriver() {
        System.out.println("Nama Supir      : " + this.supir.nama);
        System.out.println("No SIM Supir    : " + this.supir.no_sim);
    }

    // Fungsi untuk menampilkan info kendaraan
    public void showInfoKendaraan() {
        System.out.println("Plat Nomor                  : " + this.platNomor);
        System.out.println("Maksimum Penumpang          : " + this.maxPenumpang);
        System.out.println("Jumlah Penumpang Saat Ini   : " + this.jumlahPenumpang);
    }
}

// Kelas Bus sebagai turunan dari Kendaraan
class Bus extends Kendaraan {
    public String tujuan; // Jawaban Soal 3: Atribut spesifik Bus

    // Jawaban Soal 3: Konstruktor dengan parameter
    public Bus(String platNomor, int maxPenumpang, String tujuan) {
        super(platNomor, maxPenumpang);
        this.tujuan = tujuan;
    }

    // Overriding method penumpangNaik untuk Bus
    @Override
    public void penumpangNaik(String namaPenumpang) throws Exception { // Jawaban Soal 5: Overriding function penumpangNaik untuk Bus
        if (this.jumlahPenumpang >= 50) {
            throw new Exception("Maaf, bus sudah penuh. Tidak bisa menambah penumpang lagi.");
        } else {
            super.penumpangNaik(namaPenumpang);
        }
    }

    public void showDaftarPenumpang() {
        System.out.println("Daftar Penumpang Bus tujuan " + this.tujuan + ":");
        for (Penumpang penumpang : penumpangList) {
            System.out.println("- " + penumpang.nama);
        }
    }

    @Override
    public void showInfoKendaraan() {
        super.showInfoKendaraan();
        System.out.println("Tujuan Bus                  : " + this.tujuan);
    }
}

// Kelas Truk sebagai turunan dari Kendaraan
class Truk extends Kendaraan {
    public int kapasitasMuatan; // Jawaban Soal 3: Atribut spesifik Truk
    public int maxMuatan; // Jawaban Soal 3: Atribut maksimum muatan Truk

    // Jawaban Soal 3: Konstruktor dengan parameter
    public Truk(String platNomor, int maxPenumpang, int kapasitasMuatan, int maxMuatan) {
        super(platNomor, maxPenumpang);
        this.kapasitasMuatan = kapasitasMuatan;
        this.maxMuatan = maxMuatan;
    }

    // Fungsi untuk menaikkan muatan truk
    public void naikMuatan(int jumlahMuatan) throws Exception { // Jawaban Soal 3: Behaviour spesifik Truk
        int sisaKapasitas = this.maxMuatan - this.kapasitasMuatan;
        
        if (this.kapasitasMuatan + jumlahMuatan > this.maxMuatan) { 
            if (sisaKapasitas == 0) {
                throw new Exception("Muatan Sudah Penuh");
            }
            
            System.out.println("Maksimal kapasitas yang bisa ditambahkan adalah " + sisaKapasitas + " kg");
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Apakah anda yakin ingin menambahkan muatan sebanyak " + (sisaKapasitas < jumlahMuatan ? sisaKapasitas : jumlahMuatan) + " kg? (Y/N): ");
            String konfirmasi = scanner.nextLine();
            
            if (konfirmasi.equalsIgnoreCase("y")) {
                this.kapasitasMuatan += (sisaKapasitas < jumlahMuatan ? sisaKapasitas : jumlahMuatan);
                System.out.println("Muatan truk berhasil ditambahkan sebanyak " + (sisaKapasitas < jumlahMuatan ? sisaKapasitas : jumlahMuatan) + " kg");
                System.out.println("Total kapasitas muatan truk saat ini: " + this.kapasitasMuatan + " kg");
            } else {
                System.out.println("Penambahan muatan dibatalkan.");
            }
        } else {
            this.kapasitasMuatan += jumlahMuatan;
            System.out.println("Muatan truk berhasil ditambahkan sebanyak " + jumlahMuatan + " kg");
            System.out.println("Total kapasitas muatan truk saat ini: " + this.kapasitasMuatan + " kg");
        }
    }

    // Fungsi untuk mengurangi muatan truk
    public void turunMuatan(int jumlahMuatan) throws Exception { // Jawaban Soal 3: Behaviour spesifik Truk
        if (this.kapasitasMuatan - jumlahMuatan < 0) {
            throw new Exception("Maaf muatan tidak mencukupi");
        } else {
            this.kapasitasMuatan -= jumlahMuatan;
            System.out.println("Muatan truk berhasil diturunkan sebanyak " + jumlahMuatan + " kg");
            System.out.println("Sisa kapasitas muatan truk saat ini: " + this.kapasitasMuatan + " kg");
        }
    }

    @Override
    public void showInfoKendaraan() {
        System.out.println("Plat Nomor                      : " + this.platNomor);
        System.out.println("Kapasitas Muatan Truk           : " + this.kapasitasMuatan + " kg");
        System.out.println("Kapasitas Maksimum Muatan Truk  : " + this.maxMuatan + " kg");
    }
}

public class LK02_PutuAdeliaDevaniArdiana_235150701111040 {
    public static void main(String[] args) {
         int pilihan = 0;

        // Instansiasi objek Bus dan Truk
        Bus b1 = new Bus("N 1234 YY", 50, "Surabaya-Malang");
        Truk t1 = new Truk("N 5678 ZZ", 0, 0, 1000);  // Satuan berat dalam kg, awalnya muatan truk kosong

        // Instansiasi objek Driver
        Driver s1 = new Driver("654321", "Budi");
        Driver s2 = new Driver("123456", "Agus");
        b1.supir = s1; // Jawaban Soal 4: Relasi OneToOne dengan Driver
        t1.supir = s2; // Jawaban Soal 4: Relasi OneToOne dengan Driver

        // Input dari user menggunakan Scanner
        Scanner scanner = new Scanner(System.in);
        while (pilihan != 11) {
            // Menu
            System.out.println("==========MENU==========");
            System.out.println("==========BUS===========");
            System.out.println("1. Naik Penumpang");
            System.out.println("2. Turun Penumpang");
            System.out.println("3. Cek penumpang");
            System.out.println("4. Nama dan SIM Supir");
            System.out.println("5. Info Kendaraan");
            System.out.println("==========TRUK==========");
            System.out.println("6. Naik muatan");
            System.out.println("7. Turun muatan");
            System.out.println("8. Cek muatan");
            System.out.println("9. Nama dan SIM Supir");
            System.out.println("10. Info Kendaraan");
            System.out.println("11. Keluar program");

            // Input pilihan
            System.out.print("Pilih menu (masukkan angka): ");
            pilihan = scanner.nextInt();

            // Switch case untuk memilih menu
            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan nama penumpang yang naik ke bus:");
                    scanner.nextLine();
                    String namaNaikBus = scanner.nextLine();
                    try {
                        b1.penumpangNaik(namaNaikBus);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Masukkan nama penumpang yang turun dari bus:");
                    scanner.nextLine();
                    String namaTurunBus = scanner.nextLine();
                    try {
                        b1.penumpangTurun(namaTurunBus);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    b1.cekPenumpang();
                    break;
                case 4:
                    b1.showDriver();
                    break;
                case 5:
                    b1.showInfoKendaraan();
                    break;
                case 6:
                    System.out.println("Masukkan kapasitas muatan yang naik ke truk (kg):");
                    int muatanNaik = scanner.nextInt();
                    try {
                        t1.naikMuatan(muatanNaik);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                System.out.println("Kapasitas muatan truk saat ini: " + t1.kapasitasMuatan + " kg");
                    System.out.println("Masukkan kapasitas muatan yang turun dari truk (kg):");
                    int muatanTurun = scanner.nextInt();
                    try {
                        t1.turunMuatan(muatanTurun);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    t1.showInfoKendaraan();
                    break;
                case 9:
                    t1.showDriver();
                    break;
                case 10:
                    t1.showInfoKendaraan();
                    break;
                case 11:
                    System.out.println("Terima kasih atas perhatian anda, program berhenti.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-11.");
            }
        }
        scanner.close();
    }
}
