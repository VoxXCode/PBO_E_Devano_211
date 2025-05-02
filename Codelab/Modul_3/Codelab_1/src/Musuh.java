// Kelas Musuh merupakan subclass dari KarakterGame
class Musuh extends KarakterGame {

    // Constructor untuk menginisialisasi objek Musuh dengan nama dan kesehatan
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan); // Memanggil constructor superclass (KarakterGame)
    }

    // Override method serang untuk memberikan serangan khusus
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite.");

        // Mengurangi kesehatan target sebesar 15 poin
        target.setKesehatan(target.getKesehatan() - 15);

        // Menampilkan kesehatan target setelah diserang
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}
