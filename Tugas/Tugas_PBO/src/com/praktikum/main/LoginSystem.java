package com.praktikum.main;

import java.util.Scanner; // Untuk input pengguna
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User; // Import User sebagai tipe variabel umum

/**
 * Kelas utama untuk menjalankan sistem login Admin dan Mahasiswa.
 */
public class LoginSystem {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in); // Membuat objek Scanner untuk membaca input
        User userObj = null;  // Variabel userObj bertipe User (abstrak) untuk menampung objek Admin atau Mahasiswa

        // Menampilkan menu login awal
        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Masukkan Pilihan: ");
        int pilihan = objInput.nextInt(); // Membaca input angka dari pengguna
        objInput.nextLine(); // Konsumsi newline agar input berikutnya tidak terlewat

        // Proses login jika memilih Admin
        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = objInput.nextLine(); // Membaca username dari input

            System.out.print("Masukkan password: ");
            String password = objInput.nextLine(); // Membaca password dari input

            Admin adminObj = new Admin(username, password); // Membuat objek Admin
            adminObj.login(); // Memanggil method login()

            // Jika login berhasil, simpan objek ke dalam variabel bertipe User
            if (username.equals("Admin211") && password.equals("password211")) {
                userObj = adminObj; // Polymorphism: menyimpan objek Admin ke variabel User
            }

        } else if (pilihan == 2) {
            // Proses login jika memilih Mahasiswa
            System.out.print("Masukkan Nama: ");
            String nama = objInput.nextLine(); // Membaca nama Mahasiswa

            System.out.print("Masukkan NIM: ");
            String nim = objInput.nextLine(); // Membaca NIM Mahasiswa

            Mahasiswa mahasiswaObj = new Mahasiswa(nama, nim); // Membuat objek Mahasiswa
            mahasiswaObj.login(); // Memanggil method login()

            // Jika login berhasil, simpan objek ke dalam variabel bertipe User
            if (nama.equalsIgnoreCase("Devano Aghanza Putra Pradessah") &&
                nim.equals("202410370110211")) {
                userObj = mahasiswaObj; // Polymorphism: menyimpan objek Mahasiswa ke variabel User
            }

        } else {
            // Penanganan jika input pilihan tidak valid
            System.out.println(">> Pilihan tidak valid. Silakan pilih 1 atau 2.");
        }

        // Jika login berhasil (userObj tidak null), tampilkan menu aplikasi berdasarkan peran
        if (userObj != null) {
            userObj.displayAppMenu(); // Polymorphic call: akan memanggil method sesuai instance (Admin/Mahasiswa)
        } else {
            // Jika login gagal
            System.out.println("Login gagal. Tidak ada user yang dapat diproses.");
        }

        objInput.close(); // Menutup scanner setelah semua input selesai untuk mencegah resource leak
    }
}
