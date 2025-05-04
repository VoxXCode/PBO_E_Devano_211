package perpustakaan;

// Kelas NonFiksi yang merupakan turunan dari kelas Buku
public class NonFiksi extends Buku {
    private String bidang;  // Variabel untuk menyimpan bidang atau kategori buku non-fiksi

    // Konstruktor untuk menginisialisasi objek NonFiksi dengan judul, penulis, dan bidang buku
    public NonFiksi(String judul, String penulis, String bidang) {
        super(judul, penulis);  // Memanggil konstruktor kelas induk Buku untuk menginisialisasi judul dan penulis
        this.bidang = bidang;   // Menginisialisasi bidang buku non-fiksi
    }

    // Implementasi metode displayInfo() untuk menampilkan informasi buku NonFiksi
    @Override
    public void displayInfo() {
        // Menampilkan informasi buku NonFiksi termasuk judul, penulis, dan bidang
        System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: " + bidang + " )");
    }
}
