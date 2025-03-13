// Kelas utama (Main) untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat dua objek dari kelas RekeningBank
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        // Mengatur nomor rekening untuk masing-masing rekening
        rekening1.nomorRekening = "202410370110211";
        rekening2.nomorRekening = "202410370110208";

        // Mengatur nama pemilik rekening
        rekening1.namaPemilik = "Devano";
        rekening2.namaPemilik = "Dicky";

        // Mengatur saldo awal untuk masing-masing rekening
        rekening1.saldo = 5000000;
        rekening2.saldo = 2000000;

        // Menampilkan informasi rekening sebelum transaksi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Melakukan penyetoran uang ke rekening masing-masing
        rekening1.setorUang(200000);
        rekening2.setorUang(500000);
        System.out.println(); // Baris kosong untuk tampilan yang lebih rapi

        // Melakukan penarikan uang dari rekening masing-masing
        rekening1.tarikUang(800000);
        rekening2.tarikUang(300000);

        System.out.println(); // Baris kosong untuk tampilan yang lebih rapi

        // Menampilkan informasi rekening setelah transaksi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
