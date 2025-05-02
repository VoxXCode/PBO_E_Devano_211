// Kelas Mahasiswa untuk menangani login dan menampilkan informasi Mahasiswa
class Mahasiswa extends User {

    // Konstruktor Mahasiswa untuk menginisialisasi nama dan NIM
    public Mahasiswa(String nama, String nim) {
        // Memanggil konstruktor superclass (User)
        super(nama, nim);
    }

    // Metode login untuk memverifikasi nama dan NIM Mahasiswa
    @Override
    public void login() {
        // Memeriksa apakah nama dan NIM sesuai dengan data yang telah ditentukan
        if (getNama().equalsIgnoreCase("Devano Aghanza Putra Pradessah") && getNim().equals("202410370110211")) { // Menggunakan equalsIgnoreCase() agar perbandingan nama tidak case-sensitive
            System.out.println("Login Mahasiswa berhasil!"); // Pesan sukses jika login berhasil
            System.out.println(); // Baris kosong untuk tampilan lebih rapi
            displayInfo(); // Menampilkan informasi mahasiswa setelah login sukses
        } else {
            System.out.println("Login gagal! Nama atau NIM salah."); // Pesan jika login gagal
        }
    }

    // Metode untuk menampilkan informasi Mahasiswa setelah login berhasil
    @Override
    public void displayInfo() {
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama: " + getNama()); // Menampilkan nama mahasiswa
        System.out.println("NIM: " + getNim()); // Menampilkan NIM mahasiswa
    }
}
