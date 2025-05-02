// Kelas utama (Main class) untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat dua objek dari kelas Hewan
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        // Mengatur atribut nama untuk setiap hewan
        hewan1.Nama = "Kucing";
        hewan2.Nama = "Anjing";

        // Mengatur atribut jenis hewan
        hewan1.Jenis = "Mamalia";
        hewan2.Jenis = "Mamalia";

        // Mengatur suara yang dihasilkan oleh setiap hewan
        hewan1.Suara = "Nyann~~";
        hewan2.Suara = "Woof-Woof!!";

        // Memanggil method untuk menampilkan informasi tentang setiap hewan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}
