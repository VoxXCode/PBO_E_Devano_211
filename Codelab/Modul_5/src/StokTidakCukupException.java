// Kelas exception khusus untuk menangani kasus stok barang yang tidak mencukupi
public class StokTidakCukupException extends Exception {

    // Konstruktor yang menerima pesan error saja
    StokTidakCukupException(String message) {
        super(message); // Memanggil konstruktor superclass (Exception) dengan pesan
    }

    // Konstruktor yang menerima pesan error dan penyebab (cause) exception
    StokTidakCukupException(String message, Throwable cause) {
        super(message, cause); // Memanggil konstruktor superclass dengan pesan dan penyebab
    }
}
