package app;

import perpustakaan.*;  // Mengimpor seluruh kelas yang ada pada paket perpustakaan

public class Main {
    public static void main(String[] args) {
        // Membuat objek buku1 bertipe NonFiksi
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        
        // Membuat objek buku2 bertipe Fiksi
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        // Menampilkan informasi buku1 dan buku2
        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();  // Memberikan jeda baris kosong

        // Membuat objek anggota1 dengan ID "211"
        Anggota anggota1 = new Anggota("Devano", "211");
        
        // Membuat objek anggota2 dengan ID "208"
        Anggota anggota2 = new Anggota("Dicky", "208");

        // Menampilkan informasi anggota1 dan anggota2
        anggota1.displayInfo();
        anggota2.displayInfo();
        System.out.println();  // Memberikan jeda baris kosong

        // Anggota1 meminjam buku "Madilog"
        anggota1.pinjamBuku("Madilog");

        // Anggota2 meminjam buku "Hainuwele: Sang Putri Kelapa" dengan durasi 7 hari
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);
        System.out.println();  // Memberikan jeda baris kosong

        // Anggota1 mengembalikan buku "Madilog"
        anggota1.kembalikanBuku("Madilog");

        // Anggota2 mengembalikan buku "Hainuwele: Sang Putri Kelapa"
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}
