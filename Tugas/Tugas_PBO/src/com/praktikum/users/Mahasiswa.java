package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions; // Import interface MahasiswaActions
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    // Konstruktor Mahasiswa
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Metode login untuk Mahasiswa
    @Override
    public void login() {
        if (getNama().equalsIgnoreCase("Devano Aghanza Putra Pradessah") &&
            getNim().equals("202410370110211")) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo(); // Tampilkan informasi mahasiswa
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    // Menampilkan informasi Mahasiswa
    @Override
    public void displayInfo() {
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }

    // Menu aplikasi untuk Mahasiswa
    @Override
    public void displayAppMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;

            do {
                System.out.println("\n=== Menu Mahasiswa ===");
                System.out.println("1. Laporkan Barang Temuan/Hilang");
                System.out.println("2. Lihat Daftar Laporan");
                System.out.println("0. Logout");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                switch (pilihan) {
                    case 1:
                        reportItem(); // Memanggil metode lapor barang
                        break;
                    case 2:
                        viewReportItem(); // Memanggil metode lihat laporan
                        break;
                    case 0:
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } while (pilihan != 0); // Loop sampai pengguna memilih untuk logout
        }
    }

    // Implementasi dari interface MahasiswaActions
    @Override
    public void reportItem() {
        System.out.println(">> Fitur Laporkan Barang Temuan/Hilang belum tersedia <<");
    }

    @Override
    public void viewReportItem() {
        System.out.println(">> Fitur Lihat Daftar Laporan belum tersedia <<");
    }
}
