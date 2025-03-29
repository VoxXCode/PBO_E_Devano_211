// Kelas Admin untuk menangani login sebagai Admin
class Admin extends User {
    private String password; // Variabel untuk menyimpan password Admin (bersifat private untuk keamanan)
    private String username; // Variabel untuk menyimpan username Admin (bersifat private untuk keamanan)

    // Konstruktor Admin yang menerima username dan password dari pengguna
    public Admin(String username, String password) {
        // Memanggil konstruktor superclass (User) dengan nama dan NIM tetap
        super("Devano Aghanza Putra Pradessah", "202410370110211");
        this.username = username;
        this.password = password;
    }

    // Metode login untuk memverifikasi username dan password Admin
    @Override
    public void login() {
        // Memeriksa apakah username dan password sesuai dengan data yang telah ditentukan
        if (username.equals("Admin211") && password.equals("password211")) {
            System.out.println("Login Admin berhasil!"); // Pesan sukses untuk Admin
            System.out.println(); // Baris kosong untuk tampilan lebih rapi
            displayInfo(); // Menampilkan informasi Admin setelah login berhasil
        } else {
            System.out.println("Login gagal! Username atau password salah."); // Pesan gagal jika login tidak berhasil
        }
    }

    // Metode untuk menampilkan informasi Admin setelah login berhasil
    @Override 
    public void displayInfo() {
        System.out.println("Informasi Admin:");
        System.out.println("Nama: " + getNama()); // Menampilkan nama Admin yang diatur dalam superclass
        System.out.println("NIM: " + getNim()); // Menampilkan NIM Admin yang diatur dalam superclass
        System.out.println("Username: " + username); // Menampilkan username yang digunakan untuk login
    }
}
