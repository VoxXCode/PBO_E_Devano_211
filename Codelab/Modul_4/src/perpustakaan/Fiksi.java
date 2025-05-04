package perpustakaan;

// Kelas Fiksi yang merupakan turunan dari kelas Buku
public class Fiksi extends Buku {
    private String genre;  // Variabel untuk menyimpan genre buku fiksi (misalnya: fantasi, drama, misteri, dll)

    // Konstruktor untuk menginisialisasi objek Fiksi dengan judul, penulis, dan genre buku
    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis);  // Memanggil konstruktor kelas induk Buku untuk menginisialisasi judul dan penulis
        this.genre = genre;     // Menginisialisasi genre buku fiksi
    }

    // Implementasi metode displayInfo() untuk menampilkan informasi buku Fiksi
    @Override
    public void displayInfo() {
        // Menampilkan informasi buku Fiksi termasuk judul, penulis, dan genre
        System.out.println("Buku Fiksi: " + judul + " oleh " + penulis + " (Genre: " + genre + ")");
    }
}
