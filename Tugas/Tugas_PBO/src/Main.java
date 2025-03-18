import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Mendeklarasikan variabel untuk menyimpan kredensial login
        String Username;
        String Password;
        String Name;
        String Nim;
        int Pilihan; // Variabel untuk menyimpan pilihan login dari pengguna

        // Scanner untuk membaca input dari konsol
        Scanner objInput = new Scanner(System.in);

        // Menampilkan pilihan login (Admin atau Mahasiswa)
        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukan Pilihan: ");
        Pilihan = objInput.nextInt(); // Membaca pilihan pengguna
        objInput.nextLine();


        // Memeriksa jenis login yang dipilih oleh pengguna
        if (Pilihan == 1) { // Login Admin
            // Meminta username dan password Admin
            System.out.print("Masukan username: ");
            Username = objInput.nextLine();
            System.out.print("Masukan password: ");
            Password = objInput.nextLine();

            // Memvalidasi kredensial Admin
            if (Username.equals("Admin211") && Password.equals("password211")) {
                System.out.println("Login Admin berhasil!"); // Pesan sukses untuk Admin
            } else {
                System.out.println("Login gagal! Username atau password salah."); // Pesan gagal untuk Admin
            }
        } else if (Pilihan == 2) { // Login Mahasiswa
            // Meminta nama dan NIM Mahasiswa
            System.out.print("Masukan Name: ");
            Name = objInput.nextLine();
            System.out.print("Masukan Nim: ");
            Nim = objInput.nextLine();

            // Memvalidasi kredensial Mahasiswa (contoh pengecekan)
            if (Name.equals("Devano Aghanza Putra Pradessah") && Nim.equals("202410370110211")) {
                System.out.println("Login Mahasiswa berhasil!"); // Pesan sukses untuk Mahasiswa
                System.out.println("Name: " + Name); // Menampilkan nama
                System.out.println("Nim: " + Nim); // Menampilkan NIM
            } else {
                System.out.println("Login gagal! Name atau Nim salah."); // Pesan gagal untuk Mahasiswa
            }
        } else {
            System.out.println("Pilihan tidak valid."); // Pesan jika pilihan tidak valid
        }

        // Menutup scanner untuk mencegah kebocoran sumber daya
        objInput.close();
    }
}