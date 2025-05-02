// Mendefinisikan kelas Hewan
public class Hewan {
    // Deklarasi atribut untuk menyimpan informasi hewan
    String Nama;  // Nama hewan
    String Jenis; // Jenis hewan
    String Suara; // Suara yang dihasilkan hewan

    // Metode untuk menampilkan informasi hewan
    void tampilkanInfo() {
        // Menampilkan informasi nama, jenis, dan suara hewan
        System.out.println("Nama  : " + Nama);
        System.out.println("Jenis : " + Jenis);
        System.out.println("Suara : " + Suara);
        System.out.println(); // Memberikan baris kosong agar tampilan lebih rapi
    }
}
