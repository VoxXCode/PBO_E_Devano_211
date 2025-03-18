import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Deklarasi variabel
        String Firstname; // Nama depan
        char Gender;      // Jenis kelamin
        int Birthyear;    // Tahun lahir


        // Input data dari pengguna
        Scanner objInput = new Scanner(System.in);

        System.out.print("Masukan nama: ");
        Firstname = objInput.nextLine();  // Membaca input nama
        System.out.print("Masukan jenis kelamin (P/L): ");
        Gender = objInput.nextLine().charAt(0);  // Membaca input jenis kelamin
        System.out.print("Masukan tahun lahir: ");
        Birthyear = objInput.nextInt();  // Membaca input tahun lahir


        // Menghitung usia berdasarkan tahun lahir
        int currentYear = LocalDateTime.now().getYear();  // Mendapatkan tahun saat ini
        int Age = currentYear - Birthyear;  // Menghitung usia


        // Output data diri
        System.out.println();
        System.out.println("Data Diri: ");
        System.out.println("Masukkan Nama : "+ Firstname);  // Menampilkan nama
        if (Gender == 'L' || Gender == 'l') {  // Mengecek jenis kelamin Laki-laki
            System.out.println("Jenis kelamin : Laki-laki");
        } else if (Gender == 'P' || Gender == 'p') {  // Mengecek jenis kelamin Perempuan
            System.out.println("Jenis kelamin : Perempuan");
        } else {  // Jika input jenis kelamin tidak valid
            System.out.println("Error: Jenis kelamin tidak valid");
        }
        System.out.println("Usia    : "+ Age);  // Menampilkan usia
    }
}
