import java.util.Scanner; // Mengimpor Scanner untuk membaca input dari pengguna

// Kelas utama (Main) untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        int Pilihan; // Variabel untuk menyimpan pilihan login dari pengguna

        // Scanner untuk membaca input dari konsol
        Scanner objInput = new Scanner(System.in);
        
        // Membuat objek Admin dan Mahasiswa
        Admin adminObj = new Admin();
        Mahasiswa mahasiswaObj = new Mahasiswa();

        // Menampilkan pilihan login (Admin atau Mahasiswa)
        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukan Pilihan: ");
        Pilihan = objInput.nextInt(); // Membaca pilihan pengguna
        objInput.nextLine(); // Membersihkan newline dari buffer

        // Memeriksa jenis login yang dipilih oleh pengguna
        if (Pilihan == 1) { // Jika pengguna memilih Admin
            System.out.print("Masukan username: ");
            adminObj.username = objInput.nextLine(); // Membaca username Admin
            System.out.print("Masukan password: ");
            adminObj.password = objInput.nextLine(); // Membaca password Admin
            
            adminObj.login(); // Memanggil metode login dari Admin
        } else if (Pilihan == 2) { // Jika pengguna memilih Mahasiswa
            System.out.print("Masukan Nama: ");
            mahasiswaObj.nama = objInput.nextLine(); // Membaca nama Mahasiswa
            System.out.print("Masukan Nim: ");
            mahasiswaObj.nim = objInput.nextLine(); // Membaca NIM Mahasiswa
            
            mahasiswaObj.login(); // Memanggil metode login dari Mahasiswa
        } else {
            System.out.println("Pilihan tidak valid."); // Pesan jika pilihan tidak valid
        }

        // Menutup scanner untuk mencegah kebocoran sumber daya
        objInput.close();
    }
}