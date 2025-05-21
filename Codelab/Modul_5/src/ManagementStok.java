import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

// Kelas utama untuk manajemen stok barang
public class ManagementStok {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Scanner untuk input dari pengguna
        ArrayList<Barang> daftarBarang = new ArrayList<>(); // List untuk menyimpan data barang
        ArrayList temp = new ArrayList<>(); // Tidak digunakan, bisa dihapus jika tidak diperlukan
        int pilihan = 0;
        Iterator iterator = daftarBarang.iterator(); // Iterator, tidak digunakan juga

        // Menambahkan barang awal ke daftar
        daftarBarang.add(new Barang("buku", 5));
        daftarBarang.add(new Barang("meja", 7));

        // Menu utama
        do {
            System.out.println();
            System.out.println("Pilihan:");
            System.out.println("1. Tambahkan barang baru");
            System.out.println("2. Tampilkan semua barang");
            System.out.println("3. Kurangi stok");
            System.out.println("0. Keluar");
            System.out.print("Masukkan Pilihan: ");
            try {
                pilihan = input.nextInt(); // Membaca pilihan menu
                input.nextLine(); // Membersihkan newline
                int inputJumlah = 0;
                String inputBarang = "";
                int inputPilihan = 0;

                switch (pilihan) {
                    case 1:
                        // Menambahkan barang baru
                        System.out.printf("Masukkan nama Barang: ");
                        inputBarang = input.nextLine();
                        System.out.printf("Masukkan Jumlah Barang: ");
                        try {
                            inputJumlah = input.nextInt(); // Membaca jumlah barang
                            input.nextLine();
                            Barang barangBaru = new Barang(inputBarang, inputJumlah);
                            daftarBarang.add(barangBaru); // Menambahkan ke daftar
                        } catch (java.util.InputMismatchException e) {
                            System.out.println(e.getMessage() + "Input Stok Harus angka");
                            input.nextLine(); // Membersihkan buffer input
                        }
                        break;
                    case 2:
                        // Menampilkan semua barang
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong");
                        } else {
                            System.out.println("\nDaftar Barang:");
                            System.out.println("-----------------------------");
                            System.out.println("No. Nama Barang\tStok");
                            System.out.println("-----------------------------");
                            int index = 0;
                            for (Barang barang : daftarBarang) {
                                System.out.printf("%d. %s\t\t%d\n", index++, barang.getNama(), barang.getStok());
                            }
                        }
                        break;
                    case 3:
                        // Mengurangi stok barang
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong");
                            break;
                        }

                        System.out.println("\nDaftar Barang:");
                        System.out.println("-----------------------------");
                        System.out.println("No. Nama Barang\tStok");
                        System.out.println("-----------------------------");

                        int index = 0;
                        for (Barang barang : daftarBarang) {
                            System.out.printf("%d. %s\t\t%d\n", index++, barang.getNama(), barang.getStok());
                        }

                        try {
                            System.out.print("Masukkan angka barang yang ingin dikurangi: ");
                            inputPilihan = input.nextInt(); // Membaca indeks barang"
                            input.nextLine();

                            System.out.print("Masukkan jumlah barang yang ingin dikurangi: ");
                            inputJumlah = input.nextInt(); // Membaca jumlah pengurangan
                            input.nextLine();

                            // Validasi indeks
                            if (inputPilihan < 0 || inputPilihan >= daftarBarang.size()) {
                                throw new IndexOutOfBoundsException("Index tidak ada");
                            }

                            Barang barangDipilih = daftarBarang.get(inputPilihan);

                            // Validasi stok cukup
                            if (inputJumlah > barangDipilih.getStok()) {
                                throw new StokTidakCukupException("Stok untuk: " + barangDipilih.getNama() + " hanya tinggal " + barangDipilih.getStok());
                            }

                            // Mengurangi stok
                            barangDipilih.setStok(barangDipilih.getStok() - inputJumlah);
                            System.out.println("Stok berhasil dikurangi!");
                            System.out.printf("Stok %s sekarang adalah %d\n", barangDipilih.getNama(), barangDipilih.getStok());

                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage() + ": Input Harus Angka");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        } catch (StokTidakCukupException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 0:
                        // Keluar dari program
                        System.out.println("Terima Kasih <3");
                        break;
                    default:
                        // Pilihan tidak valid
                        System.out.println("Input Tidak Valid");
                }
            } catch (InputMismatchException e) {
                // Penanganan input selain angka pada pilihan menu
                System.out.println("Input harus berupa angka");
                input.nextLine();
            }

        } while (pilihan != 0);

        input.close(); // Menutup Scanner
    }
}
