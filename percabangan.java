import java.util.*;

public class percabangan {
    public static void main(String[] args) {
    int nilai;
    String nama;

    Scanner inp = new Scanner(System.in);
    System.out.print("masukkan nama siswa : ");
    nama = inp.next();

    System.out.print("masukkan nilai : ");
    nilai = inp.nextInt();

    if (nilai >= 60)
    System.out.print(nama + " anda dinyatakan :lulus ");
    else
    System.out.print(nama + " anda dinyatakan :tidak lulus ");
    
    }
}
