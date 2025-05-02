// Kelas User sebagai superclass yang digunakan untuk Admin dan Mahasiswa
public class User {
    private String nama; // Variabel untuk menyimpan nama pengguna secara private
    private String nim;  // Variabel untuk menyimpan NIM pengguna sebagai String

    // Konstruktor untuk menginisialisasi nama dan NIM
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter untuk mendapatkan nama pengguna
    public String getNama() {
        return nama;
    }

    // Setter untuk mengubah nama pengguna
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk mendapatkan NIM pengguna
    public String getNim() {
        return nim;
    }

    // Setter untuk mengubah NIM pengguna
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Metode login yang akan dioverride oleh subclass (Admin dan Mahasiswa)
    public void login() {
        System.out.println("Sistem Login belum ditambahkan."); // Placeholder untuk login
    }

    // Metode untuk menampilkan informasi pengguna yang akan dioverride oleh subclass
    public void displayInfo() {
        System.out.println("Sistem Info belum ditambahkan."); // Placeholder untuk info pengguna
    }
}
