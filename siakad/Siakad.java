import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
public class Siakad {
    static int jumlahData = 0;
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];

    public static void tambahData() {
        System.out.println("Silahkan tambah data");
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan NIM = ");
        int nim = scan.nextInt();
        scan.nextLine();
        System.out.print("Masukan Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData = jumlahData + 1;
    }

    public static void tampilData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i<jumlahData) {
            System.out.println(mahasiswa[i].getNim()+"  "+mahasiswa[i].getNama());
            i++;
        }
    }


    public static void searchData()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih menu L search or B search : ");
        System.out.println("1. Linear Search (L)");
        System.out.println("2. Binary Search (B)");
        System.out.print("Pilihan : ");
        int searchNim = scan.nextInt();
        switch(searchNim)
        {
            case 1:
            {
                System.out.print("Inputkan NIM pencarian : ");
                Integer linear = scan.nextInt();
                linearSearch(linear);
                break;
            }

            case 2:
            {
                System.out.print("Inputkan NIM pencarian : ");
                Integer binarysearch = scan.nextInt();
                binarySearch(binarysearch);
                break;
            }
        }
    }


    public static void binarySearch(int binarysearch)
    {
        int l = 0, r = jumlahData - 1;
        while(l <= r)
        {
            int s = l + (r - l) / 2;

            if (mahasiswa[s].getNim() == binarysearch)
            {
                System.out.println("Data yang dicari ada pada data ke-" + (s+1));
            }

            if(mahasiswa[s].getNim() < binarysearch)
            {
                l = s + 1;
            } else
            {
                r = s - 1;
            }
        }
    }


    public static void linearSearch(int linear)
    {
        int n = jumlahData;
        for(int i = 0; i < n; i++)
        {
            if(mahasiswa[i].getNim() == linear)
            {
                System.out.println("Data yang dicari ada pada data ke-" + (i+1));
            }
        }
    }





    public static void urutkanData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. QUICK SORT");
        System.out.println("4. INSERTION SORT");
        System.out.println("5. BUBBLE SORT");
        System.out.println("6. ShellSORT");
        System.out.print("Pilih algoritma = ");
        int algo = scanner.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }

            case 2: {
                selectionSort();
                break;
            }

            case 3: {
                quickSort(mahasiswa, 0, jumlahData-1);
                break;
            }

            case 4: {
                insertionSort();
                break;
            }

            case 5: {
                bubbleSort();
                break;
            }

            case 6: {
                shellSort();
                break;
            }

            
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j].getNim() < arr[low].getNim())
                swap(arr, ++p, j);
    
        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot){
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void exchangeSort() {
        for (int x = 0; x<jumlahData; x++) {
            for (int y = x+1; y<jumlahData; y++) {
                if (mahasiswa[x].getNim() > mahasiswa[y].getNim()) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
    for (int i = 0; i < jumlahData-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < jumlahData; j++)
                if (mahasiswa[j].getNim() < mahasiswa[min_idx].getNim())
                    min_idx = j;
 
            
            Mahasiswa temp = mahasiswa[min_idx];
            mahasiswa[min_idx] = mahasiswa[i];
            mahasiswa[i] = temp;
        }
    }

    public static void insertionSort()
    {
        
        for (int i = 1; i < jumlahData; ++i) {
            Mahasiswa key = mahasiswa[i];
            int j = i - 1;
 
            
            while (j >= 0 && mahasiswa[j].getNim() > key.getNim()) {
                mahasiswa[j + 1] = mahasiswa[j];
                j = j - 1;
            }
            mahasiswa[j + 1] = key;
        }
    }

    public static void bubbleSort()
    {
        for (int i = 0; i < jumlahData - 1; i++)
            for (int j = 0; j < jumlahData - i - 1; j++)
                if (mahasiswa[j].getNim() > mahasiswa[j + 1].getNim()) {
                    
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }




            
    public static void  shellSort()
    {

        
        for (int gap = jumlahData/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < jumlahData; i += 1)
            {
                Mahasiswa temp = mahasiswa[i];
 
                
                int j;
                for (j = i; j >= gap && mahasiswa[j - gap].getNim() > temp.getNim(); j -= gap)
                    mahasiswa[j] = mahasiswa[j - gap];
 
                
                mahasiswa[j] = temp;
            }
        }
        
    }

    public static void deleteData()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan data NIM yang akan dihapus : ");
        int delete = scan.nextInt();
        for(int i = 0; i < jumlahData; i++)
        {
            if(mahasiswa[i].getNim() == delete)
            {
                System.out.println("Mahasiswa yang dipilih sudah dihapus ");
                mahasiswa[i] = mahasiswa[i + 1];
            }
        }
        jumlahData--;
    }

    public static void changeData()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Inputkan data NIM yang ingin anda rubah : ");
        int changedata = scan.nextInt();
       
        for(int i = 0; i < jumlahData; i++)
        {
            if(mahasiswa[i].getNim() == changedata)
            {
                System.out.print("Inputkan NIM sesuai keinginan anda = ");
                int nim = scan.nextInt();
                scan.nextLine();
                System.out.print("inputkan Nama sesuai keinginan anda = ");
                String nama = scan.nextLine();
                mahasiswa[i].setNama(nama);
                mahasiswa[i].setNim(nim);
            }
        }
    }


    public static void UAS_Bpradana()
    {
        if(jumlahData == 0)
        {
            System.out.println("Data kosong");
        }else

        {
            int jarak = jumlahData;
            int susut = 13;
            int urut = 0;

            while(urut == 0)
            {
                jarak = (jarak*10) / susut;
                if(jarak <= 1)
                {
                    jarak = 1; urut = 1;
                }
                for(int i = 0; (i + jarak) < jumlahData; i++)
                {
                    if(mahasiswa[i].getNim() > mahasiswa[i + jarak].getNim())
                    {
                        Mahasiswa temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i+jarak];
                        mahasiswa[i+jarak] = temp;
                        urut = 0;
                    }
                }
            }
            System.out.println("Data menjadi terurut, Anda dapat melihat dengan menuju menu 2");
        }
    }





            





    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
            System.out.println("8. keluar");
            System.out.print("Pilih menu = ");
            menu = scan.nextInt();
            if (menu==1) {
                tambahData();
            } else if (menu==2) {
                tampilData();
            } else if (menu==3) {
                urutkanData();
            }else if (menu==4){
                searchData();
            }else if (menu==5){
                changeData();
            }else if (menu==6){
                deleteData();
            }else if (menu==7){
                UAS_Bpradana();
            }


        } while (menu!=8);
        System.out.println("Anda telah keluar dari program");
    }
}