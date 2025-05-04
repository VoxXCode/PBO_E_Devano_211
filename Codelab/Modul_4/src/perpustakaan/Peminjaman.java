package perpustakaan;

// Interface Peminjaman yang mendefinisikan kontrak untuk peminjaman buku
public interface Peminjaman {
    
    // Metode untuk meminjam buku dengan hanya menyebutkan judul buku
    void pinjamBuku(String judul);

    // Metode untuk meminjam buku dengan menyebutkan judul dan durasi pinjaman (dalam hari)
    void pinjamBuku(String judul, int durasi);

    // Metode untuk mengembalikan buku berdasarkan judul buku yang dipinjam
    void kembalikanBuku(String judul);
}
