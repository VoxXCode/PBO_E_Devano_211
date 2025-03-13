// Kelas RekeningBank untuk merepresentasikan rekening bank
public class RekeningBank {
    // Atribut untuk menyimpan informasi rekening
    String nomorRekening; // Menyimpan nomor rekening bank
    String namaPemilik;   // Menyimpan nama pemilik rekening
    double saldo;         // Menyimpan saldo rekening

    // Metode untuk menampilkan informasi rekening
    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println(); // Baris kosong untuk mempercantik tampilan
    }

    // Metode untuk menyetor uang ke rekening
    void setorUang(double jumlah) {
        saldo += jumlah; // Menambahkan jumlah yang disetor ke saldo
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    // Metode untuk menarik uang dari rekening
    void tarikUang(double jumlah) {
        // Mengecek apakah saldo mencukupi untuk penarikan
        if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        } else {
            saldo -= jumlah; // Mengurangi saldo jika cukup
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        }
    }
}
