// Kelas Barang merepresentasikan sebuah item dalam stok
public class Barang {
    private String nama;  // Nama barang
    private int stok;     // Jumlah stok barang

    // Konstruktor untuk menginisialisasi nama dan stok barang
    public Barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    // Mengembalikan nama barang
    public String getNama() {
        return nama;
    }

    // Mengembalikan jumlah stok barang
    public int getStok() {
        return stok;
    }

    // Mengatur ulang jumlah stok barang
    public void setStok(int stok) {
        this.stok = stok;
    }
}
