// Kelas Pahlawan merupakan subclass dari KarakterGame
class Pahlawan extends KarakterGame {

    // Constructor untuk menginisialisasi objek Pahlawan dengan nama dan kesehatan
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan); // Memanggil constructor superclass (KarakterGame)
    }

    // Override method serang untuk memberikan serangan khusus
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike.");

        // Mengurangi kesehatan target sebesar 20 poin
        target.setKesehatan(target.getKesehatan() - 20);

        // Menampilkan kesehatan target setelah diserang
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}
