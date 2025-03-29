import java.util.Scanner; // Mengimpor Scanner untuk membaca input dari pengguna

// Kelas utama (Main) untuk menjalankan program
public class LoginSystem {
    public static void main(String[] args) {
        int pilihan; // Variabel untuk menyimpan pilihan login dari pengguna

        // Scanner untuk membaca input dari konsol
        Scanner objInput = new Scanner(System.in);

        // Menampilkan pilihan login (Admin atau Mahasiswa)
        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan Pilihan: ");
        pilihan = objInput.nextInt(); // Membaca pilihan pengguna
        objInput.nextLine(); // Membersihkan newline dari buffer

        // Memeriksa jenis login yang dipilih oleh pengguna
        if (pilihan == 1) { // Jika pengguna memilih Admin
            System.out.print("Masukkan username: ");
            String username = objInput.nextLine(); // Membaca username Admin dari input pengguna
            System.out.print("Masukkan password: ");
            String password = objInput.nextLine(); // Membaca password Admin dari input pengguna

            // Membuat objek Admin dengan username dan password yang dimasukkan oleh pengguna
            Admin adminObj = new Admin(username, password);
            adminObj.login(); // Memanggil metode login() pada objek Admin untuk melakukan verifikasi login

        } else if (pilihan == 2) { // Jika pengguna memilih Mahasiswa
            System.out.print("Masukkan Nama: ");
            String nama = objInput.nextLine(); // Membaca nama Mahasiswa dari input pengguna
            System.out.print("Masukkan NIM: ");
            String nim = objInput.nextLine(); // Membaca NIM Mahasiswa dari input pengguna

            // Membuat objek Mahasiswa dengan nama dan NIM yang dimasukkan oleh pengguna
            Mahasiswa mahasiswaObj = new Mahasiswa(nama, nim);
            mahasiswaObj.login(); // Memanggil metode login() pada objek Mahasiswa untuk melakukan verifikasi login

        } else { // Jika input tidak sesuai dengan pilihan yang tersedia
            System.out.println("Pilihan tidak valid."); // Pesan error jika input tidak sesuai
        }

        // Menutup scanner untuk mencegah kebocoran sumber daya
        objInput.close();
    }
}
