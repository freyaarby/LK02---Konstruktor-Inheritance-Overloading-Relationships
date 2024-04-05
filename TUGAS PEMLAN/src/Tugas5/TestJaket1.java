package Tugas5;
import java.util.Scanner;

public class TestJaket1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean bener;

        Jaket1 jaket = new Jaket1();

        jaket.displayPilihan();
        System.out.println("Ketik '1' untuk lanjut berbelanja!^^ ");
        int pilihan = input.nextInt();

        if(pilihan == 1){
            jaket.setChoiceNumber(pilihan);
        }else{
            System.out.println("Yah, hanya bisa ketik 1 saja biar bisa lanjut, coba ulangi lagi yaa");
            System.exit(1);
        }
        jaket.getChoiceNumber();
    }
}
