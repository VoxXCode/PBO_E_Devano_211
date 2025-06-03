package com.praktikum.users;

import java.util.Scanner;

/**
 * Kelas abstrak User yang menjadi superclass bagi Admin dan Mahasiswa.
 */
public abstract class User {
    private String nama; // Nama pengguna (Admin atau Mahasiswa)
    private String nim;  // NIM pengguna

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Method abstrak login yang harus diimplementasikan oleh subclass
    public abstract void login();

    // Method menampilkan info dasar user (bisa digunakan oleh subclass)
    public void displayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }

    // **Perbaikan:** method abstrak displayAppMenu menerima Scanner sebagai parameter
    public abstract void displayAppMenu(Scanner scanner);
}
