import java.util.*;

public class Penjumlahan {
    public static void main(String[] args) {
        int x;
        int y;
        Scanner scan = new Scanner(System.in);
        System.out.print("masukkan nilai x : ");
        x = scan.nextInt();
        
        System.out.print("masukkan nilai y : ");
        y = scan.nextInt();

        int hasil = x + y;

        System.out.print("hasil = " + hasil);
    }
    
}
