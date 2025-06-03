package com.praktikum.users;

import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kelas Admin adalah turunan dari kelas abstrak User.
 * Admin dapat mengelola laporan barang dan (nantinya) data mahasiswa.
 */
public class Admin extends User {
    private String username;
    private String password;

    // Konstruktor Admin
    public Admin(String username, String password) {
        super(username, "ADMIN001"); // nama = username, nim tetap sebagai ADMIN001
        this.username = username;
        this.password = password;
    }

    // Getter untuk username
    public String getUsername() {
        return username;
    }

    // Getter untuk password
    public String getPassword() {
        return password;
    }

    // Override method login dari User
    @Override
    public void login() {
        System.out.println("Admin " + username + " berhasil login!");
    }

    // Override method untuk menampilkan menu Admin
    @Override
    public void displayAppMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline

                switch (choice) {
                    case 1:
                        manageItems(scanner); // Kelola laporan barang
                        break;
                    case 2:
                        manageUsers(scanner); // Placeholder untuk fitur kelola mahasiswa
                        break;
                    case 0:
                        System.out.println("Logout berhasil.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    // Menu kelola laporan barang
    private void manageItems(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== KELOLA LAPORAN BARANG ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilihan: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        viewAllReportedItems();
                        break;
                    case 2:
                        markItemAsClaimed(scanner);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    // Menampilkan semua laporan barang
    private void viewAllReportedItems() {
        System.out.println("\n=== DAFTAR LAPORAN ===");
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            Item item = LoginSystem.reportedItems.get(i);
            System.out.println("\nIndex: " + i);
            System.out.println("Nama       : " + item.getItemName());
            System.out.println("Deskripsi  : " + item.getDescription());
            System.out.println("Lokasi     : " + item.getLocation());
            System.out.println("Status     : " + item.getStatus());
        }
    }

    // Menandai barang telah diambil (ubah status menjadi 'Claimed')
    private void markItemAsClaimed(Scanner scanner) {
        System.out.println("\n=== TANDAI BARANG DIAMBIL ===");
        viewAllReportedItems();

        if (LoginSystem.reportedItems.isEmpty()) {
            return;
        }

        System.out.print("\nMasukkan index barang: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < LoginSystem.reportedItems.size()) {
                Item item = LoginSystem.reportedItems.get(index);
                item.setStatus("Claimed");
                System.out.println("Status barang berhasil diubah!");
            } else {
                System.out.println("Index tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        }
    }

    // Placeholder untuk fitur kelola mahasiswa (belum diimplementasikan)
    private void manageUsers(Scanner scanner) {
        System.out.println("Fitur kelola mahasiswa belum diimplementasikan.");
    }

    /**
     * Verifikasi kredensial login admin.
     *
     * @param username username admin
     * @param password password admin
     * @return objek Admin jika cocok, null jika tidak
     */
    public static Admin verifyAdminCredentials(String username, String password) {
        for (User user : LoginSystem.userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    return admin;
                }
            }
        }
        return null;
    }
}
