// Kelas Admin untuk menangani login sebagai Admin
public class Admin {
    String username; // Variabel untuk menyimpan username Admin
    String password; // Variabel untuk menyimpan password Admin

    // Metode login untuk memverifikasi username dan password Admin
    void login() {
        // Memeriksa apakah username dan password sesuai dengan data yang ditentukan
        if (username.equals("Admin211") && password.equals("password211")) {
            System.out.println("Login Admin berhasil!"); // Pesan sukses untuk Admin
        } else {
            System.out.println("Login gagal! Username atau password salah."); // Pesan gagal untuk Admin
        }
    }
}
