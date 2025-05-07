package com.praktikum.users;

import com.praktikum.actions.AdminActions;  // Import interface AdminActions
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String password; // Variabel untuk menyimpan password Admin
    private String username; // Variabel untuk menyimpan username Admin

    // Konstruktor Admin
    public Admin(String username, String password) {
        super("Devano Aghanza Putra Pradessah", "202410370110211"); // Memanggil konstruktor User
        this.username = username;
        this.password = password;
    }

    // Metode login untuk Admin
    @Override
    public void login() {
        if (username.equals("Admin211") && password.equals("password211")) {
            System.out.println("Login Admin berhasil!");
            displayInfo(); // Tampilkan informasi Admin
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    // Menampilkan informasi Admin
    @Override
    public void displayInfo() {
        System.out.println("Informasi Admin:");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
        System.out.println("Username: " + username);
    }

    // Menu aplikasi untuk Admin
    @Override
    public void displayAppMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;

            do {
                System.out.println("\n=== Menu Admin ===");
                System.out.println("1. Kelola Laporan Barang");
                System.out.println("2. Kelola Data Mahasiswa");
                System.out.println("0. Logout");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                switch (pilihan) {
                    case 1:
                        manageItems(); // Memanggil metode kelola barang
                        break;
                    case 2:
                        manageUsers(); // Memanggil metode kelola mahasiswa
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

    // Implementasi dari interface AdminActions
    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}
