package perpustakaan;

// Implementasi interface Peminjaman pada kelas Anggota
public class Anggota implements Peminjaman {
    private String nama;        // Variabel untuk menyimpan nama anggota
    private String idAnggota;   // Variabel untuk menyimpan ID anggota

    // Konstruktor untuk menginisialisasi objek Anggota dengan nama dan ID anggota
    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    // Implementasi metode pinjamBuku dari interface Peminjaman
    // Meminjam buku dengan judul tertentu
    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " meminjam buku berjudul: " + judul);
    }

    // Implementasi metode pinjamBuku dengan durasi tertentu dari interface Peminjaman
    // Meminjam buku dengan judul dan durasi pinjaman tertentu (dalam hari)
    @Override
    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasi + " hari.");
    }

    // Implementasi metode kembalikanBuku dari interface Peminjaman
    // Mengembalikan buku dengan judul tertentu
    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);
    }

    // Menampilkan informasi anggota
    public void displayInfo() {
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
    }
}