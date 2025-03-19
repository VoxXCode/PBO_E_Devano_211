public class Main {
    public static void main(String[] args) {

        // Membuat objek dari kelas KarakterGame, Pahlawan, dan Musuh
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        // Menampilkan status awal dari masing-masing karakter
        System.out.println("=== Status Awal ===");
        System.out.println(brimstone.getNama() + " memiliki kesehatan " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan " + viper.getKesehatan());
        System.out.println();

        // Simulasi serangan: Brimstone menyerang Viper
        brimstone.serang(viper);

        // Simulasi serangan: Viper menyerang Brimstone
        viper.serang(brimstone);
    }
}
