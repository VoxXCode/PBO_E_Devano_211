package com.praktikum.users;

/**
 * Kelas abstrak User yang menjadi superclass bagi Admin dan Mahasiswa.
 * Kelas ini mendefinisikan atribut dasar (nama dan NIM) dan method-method
 * yang akan dioverride oleh subclass.
 */
public abstract class User {
    private String nama; // Menyimpan nama pengguna (Admin/Mahasiswa)
    private String nim;  // Menyimpan NIM pengguna

    /**
     * Konstruktor untuk inisialisasi nama dan NIM pengguna
     * @param nama Nama pengguna
     * @param nim  NIM pengguna
     */
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk NIM
    public String getNim() {
        return nim;
    }

    // Setter untuk NIM
    public void setNim(String nim) {
        this.nim = nim;
    }

    /**
     * Method login harus diimplementasikan oleh setiap subclass
     * (Admin dan Mahasiswa) untuk menangani proses login spesifik.
     */
    public abstract void login();

    /**
     * Menampilkan informasi umum dari pengguna.
     * Method ini bisa digunakan bersama oleh subclass.
     */
    public void displayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }

    /**
     * Method abstrak untuk menampilkan menu aplikasi masing-masing role.
     * Akan diimplementasikan secara berbeda oleh Admin dan Mahasiswa.
     */
    public abstract void displayAppMenu();
}
