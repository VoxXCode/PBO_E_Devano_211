package com.praktikum.users;

import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kelas Mahasiswa merupakan turunan dari kelas abstrak User.
 * Mahasiswa dapat login, melaporkan barang, dan melihat daftar laporan.
 */
public class Mahasiswa extends User {

    // Konstruktor Mahasiswa
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Override method login dari User
    @Override
    public void login() {
        System.out.println("Mahasiswa " + getNama() + " berhasil login!");
    }

    // Override method untuk menampilkan menu aplikasi Mahasiswa
    @Override
    public void displayAppMenu(Scanner scanner) {
        int pilihan;
        do {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // membersihkan newline

                switch (pilihan) {
                    case 1:
                        reportItem(scanner); // Memanggil method untuk melaporkan item
                        break;
                    case 2:
                        viewReportItem(); // Melihat semua laporan
                        break;
                    case 0:
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // membersihkan input tidak valid
                pilihan = -1;
            }
        } while (pilihan != 0);
    }

    // Method untuk melaporkan item yang ditemukan atau hilang
    public void reportItem(Scanner scanner) {
        System.out.println("\n=== LAPORKAN BARANG TEMUAN/HILANG ===");

        System.out.print("Nama Barang: ");
        String itemName = scanner.nextLine();

        System.out.print("Deskripsi Barang: ");
        String description = scanner.nextLine();

        System.out.print("Lokasi Temuan/Kehilangan: ");
        String location = scanner.nextLine();

        // Buat item baru dan tambahkan ke daftar laporan
        Item newItem = new Item(itemName, description, location, "Reported");
        LoginSystem.reportedItems.add(newItem);

        System.out.println("\n[SUKSES] Laporan barang telah berhasil disimpan!");
    }

    // Method untuk menampilkan semua laporan barang dengan status "Reported"
    public void viewReportItem() {
        System.out.println("\n=== DAFTAR LAPORAN BARANG ===");

        boolean adaLaporan = false;
        int counter = 1;

        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                System.out.println("\nLaporan #" + counter++);
                System.out.println("Nama Barang  : " + item.getItemName());
                System.out.println("Deskripsi    : " + item.getDescription());
                System.out.println("Lokasi       : " + item.getLocation());
                System.out.println("Status       : " + item.getStatus());
                System.out.println("-----------------------------");
                adaLaporan = true;
            }
        }

        if (!adaLaporan) {
            System.out.println("Tidak ada laporan barang dengan status 'Reported'.");
        }
    }

    /**
     * Method statis untuk memverifikasi login mahasiswa.
     * Akan mencocokkan nama dan NIM dengan data dalam userList.
     * 
     * @param nama Nama mahasiswa
     * @param nim NIM mahasiswa
     * @return Objek Mahasiswa jika cocok, null jika tidak
     */
    public static Mahasiswa verifyMahasiswaCredentials(String nama, String nim) {
        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                if (mhs.getNama().equalsIgnoreCase(nama) && mhs.getNim().equals(nim)) {
                    return mhs;
                }
            }
        }
        return null;
    }
}
