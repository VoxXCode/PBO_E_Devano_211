public class KarakterGame {
    // Atribut privat untuk menyimpan nama dan kesehatan karakter
    private String nama;
    private int kesehatan;

    // Constructor untuk menginisialisasi objek dengan nama dan kesehatan
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Getter untuk mendapatkan nilai nama karakter
    public String getNama() {
        return nama;
    }

    // Setter untuk mengubah nilai nama karakter
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk mendapatkan nilai kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }

    // Setter untuk mengubah nilai kesehatan karakter
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Method untuk menyerang karakter lain
    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.getNama());
    }
}
