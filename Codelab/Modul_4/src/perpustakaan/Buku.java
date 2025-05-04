package perpustakaan;

// Kelas abstrak Buku yang mendefinisikan properti dan metode dasar untuk buku
public abstract class Buku {
    protected String judul;       // Variabel untuk menyimpan judul buku
    protected String penulis;     // Variabel untuk menyimpan penulis buku

    // Konstruktor untuk menginisialisasi objek Buku dengan judul dan penulis
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    // Getter untuk mendapatkan judul buku
    public String getJudul() {
        return judul;
    }

    // Getter untuk mendapatkan penulis buku
    public String getPenulis() {
        return penulis;
    }

    // Metode abstrak untuk menampilkan informasi buku
    // Setiap kelas turunan dari Buku harus mengimplementasikan metode ini
    public abstract void displayInfo();
}
