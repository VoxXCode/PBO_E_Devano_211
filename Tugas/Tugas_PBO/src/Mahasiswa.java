// Kelas Mahasiswa untuk menangani login dan menampilkan informasi Mahasiswa
public class Mahasiswa {
    String nama; // Variabel untuk menyimpan nama Mahasiswa
    String nim;  // Variabel untuk menyimpan NIM Mahasiswa

    // Metode login untuk memverifikasi nama dan NIM Mahasiswa
    void login() {
        // Memeriksa apakah nama dan NIM sesuai dengan data yang ditentukan
        if (nama.equals("Devano Aghanza Putra Pradessah") && nim.equals("202410370110211")) {
            System.out.println("Login Mahasiswa berhasil!"); // Pesan sukses untuk Mahasiswa
            System.out.println(); // Baris kosong untuk tampilan yang lebih rapi
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah."); // Pesan gagal untuk Mahasiswa
        }
    }

    // Metode untuk menampilkan informasi Mahasiswa setelah login berhasil
    void displayInfo() {
        System.out.println("Informasi Mahasiswa:"); // Header informasi
        System.out.println("Nama: " + nama); // Menampilkan nama Mahasiswa
        System.out.println("NIM: " + nim); // Menampilkan NIM Mahasiswa
    }
}
