package com.praktikum.main;

// Import library yang dibutuhkan
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import com.praktikum.data.Item;

public class LoginSystem {
    // Daftar pengguna yang tersimpan di sistem
    public static ArrayList<User> userList = new ArrayList<>();
    
    // Daftar item yang telah dilaporkan (hilang/temuan)
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    // Scanner global untuk input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Menambahkan pengguna dan item default
        initializeDefaultUsers();

        try {
            // Tampilan awal menu login
            System.out.println("=== Sistem Login ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.print("Masukkan Pilihan: ");
            
            int pilihan = 0;
            boolean validInput = false;

            // Validasi input pilihan menu
            while (!validInput) {
                try {
                    pilihan = scanner.nextInt();
                    scanner.nextLine(); // Hapus newline dari buffer
                    
                    if (pilihan < 1 || pilihan > 2) {
                        throw new IllegalArgumentException();
                    }
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input harus berupa angka (1 atau 2)!");
                    scanner.nextLine(); // Bersihkan input
                    System.out.print("Silakan masukkan pilihan lagi: ");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Pilihan harus 1 atau 2!");
                    System.out.print("Silakan masukkan pilihan lagi: ");
                }
            }

            // Proses login sesuai pilihan
            if (pilihan == 1) {
                // Login sebagai Admin
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();

                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                // Verifikasi kredensial admin
                Admin admin = Admin.verifyAdminCredentials(username, password);
                if (admin != null) {
                    admin.login();
                    admin.displayAppMenu(scanner); // Tampilkan menu admin
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }

            } else if (pilihan == 2) {
                // Login sebagai Mahasiswa
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine().trim();
                
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine().trim();

                if (nama.isEmpty() || nim.isEmpty()) {
                    System.out.println("Error: Nama dan NIM tidak boleh kosong!");
                } else {
                    // Verifikasi kredensial mahasiswa
                    Mahasiswa mhs = Mahasiswa.verifyMahasiswaCredentials(nama, nim);
                    if (mhs != null) {
                        mhs.login();
                        mhs.displayAppMenu(scanner); // Tampilkan menu mahasiswa
                    } else {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                }
            }

        } finally {
            // Tutup scanner setelah program selesai
            scanner.close();
        }
    }

    /**
     * Inisialisasi data pengguna dan item awal.
     * Digunakan untuk testing atau default awal aplikasi.
     */
    private static void initializeDefaultUsers() {
        try {
            // Tambah admin default
            userList.add(new Admin("Admin211", "password211"));

            // Tambah mahasiswa default
            userList.add(new Mahasiswa("Devano", "211"));

            // Tambah item default
            reportedItems.add(new Item("Laptop", "Laptop Lenovo ThinkPad", "Lab Jaringan", "Reported"));
        } catch (Exception e) {
            System.err.println("Error saat inisialisasi data default: " + e.getMessage());
        }
    }
}
