package com.smp;

//CLASS PARENT: Perangkat_Sekolah 
class Perangkat_Sekolah {

    //Enkapsulasi
    private String nama;
    private String alamat;

    // constructor buat ngisi nama dan alamat
    public Perangkat_Sekolah(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    // ----- getter dan setter -----
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    //method tampilkanInformasi 
    public void tampilkanInformasi() {
        System.out.println("Nama   : " + nama);
        System.out.println("Alamat : " + alamat);
    }
}

// CLASS CHILD: Guru 
class Guru extends Perangkat_Sekolah {

    // atribut guru
    private String nip;
    private String mataPelajaranDiampu;

    // constructor: nama & alamat dikirim ke parent pakai super()
    public Guru(String nama, String alamat, String nip, String mataPelajaranDiampu) {
        super(nama, alamat);
        this.nip = nip;
        this.mataPelajaranDiampu = mataPelajaranDiampu;
    }

    //getter dan setter
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMataPelajaranDiampu() {
        return mataPelajaranDiampu;
    }

    public void setMataPelajaranDiampu(String mataPelajaranDiampu) {
        this.mataPelajaranDiampu = mataPelajaranDiampu;
    }

    //override method tampilkanInformasi dari parent 
    @Override
    public void tampilkanInformasi() {
        System.out.println("=== Informasi Guru ===");
        System.out.println("Nama                : " + getNama());
        System.out.println("Alamat              : " + getAlamat());
        System.out.println("NIP                 : " + nip);
        System.out.println("Mata Pelajaran      : " + mataPelajaranDiampu);
    }
}

//CLASS CHILD: Murid 
class Murid extends Perangkat_Sekolah {

    // atribut tambahan khusus murid
    private String nis;
    private String kelas;

    // constructor, nama & alamat dikirim ke parent
    public Murid(String nama, String alamat, String nis, String kelas) {
        super(nama, alamat);
        this.nis = nis;
        this.kelas = kelas;
    }

    //getter dan setter
    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    //override method tampilkanInformasi
    @Override
    public void tampilkanInformasi() {
        System.out.println("=== Informasi Murid ===");
        System.out.println("Nama   : " + getNama());
        System.out.println("Alamat : " + getAlamat());
        System.out.println("NIS    : " + nis);
        System.out.println("Kelas  : " + kelas);
    }
}

//CLASS CHILD: MataPelajaran
class MataPelajaran extends Perangkat_Sekolah {

    // atribut tambahan khusus mata pelajaran
    private String kodePelajaran;
    private int jumlahJam;

    // constructor, nama & alamat dikirim ke parent
    public MataPelajaran(String nama, String alamat, String kodePelajaran, int jumlahJam) {
        super(nama, alamat);
        this.kodePelajaran = kodePelajaran;
        this.jumlahJam = jumlahJam;
    }

    //getter dan setter 
    public String getKodePelajaran() {
        return kodePelajaran;
    }

    public void setKodePelajaran(String kodePelajaran) {
        this.kodePelajaran = kodePelajaran;
    }

    public int getJumlahJam() {
        return jumlahJam;
    }

    public void setJumlahJam(int jumlahJam) {
        this.jumlahJam = jumlahJam;
    }

    // override method tampilkanInformasi 
    @Override
    public void tampilkanInformasi() {
        System.out.println("=== Informasi Mata Pelajaran ===");
        System.out.println("Nama Pelajaran : " + getNama());
        System.out.println("Alamat         : " + getAlamat());
        System.out.println("Kode Pelajaran : " + kodePelajaran);
        System.out.println("Jumlah Jam     : " + jumlahJam + " jam pelajaran");
    }
}

// MAIN CLASS: SMP 
public class SMP {

    public static void main(String[] args) {

        //buat objek sekolah, guru, murid, dan mata pelajaran 
        Perangkat_Sekolah sekolah = new Perangkat_Sekolah("SMP Bina Bangsa", "Bekasi");
        Guru guru = new Guru("Rizal Santoso", "Bekasi", "G001", "Matematika");
        Murid murid = new Murid("Andi Pratama", "Bekasi", "M001", "VII-A");
        MataPelajaran mapel = new MataPelajaran("Matematika", "Bekasi", "MTK01", 4);

        //tampilkan informasi tiap objek satu-satu 
        System.out.println("=== Informasi Sekolah ===");
        sekolah.tampilkanInformasi();
        System.out.println();

        guru.tampilkanInformasi();
        System.out.println();

        murid.tampilkanInformasi();
        System.out.println();

        mapel.tampilkanInformasi();
        System.out.println();

        // polymorphism
        // objek Guru, Murid, MataPelajaran disimpan di variabel bertipe Perangkat_Sekolah
        Perangkat_Sekolah[] daftar = new Perangkat_Sekolah[3];
        daftar[0] = guru;
        daftar[1] = murid;
        daftar[2] = mapel;

        // dipanggil lewat perulangan, tiap objek otomatis jalanin
        // tampilkanInformasi() class-nya masing-masing
        System.out.println(" Hasil Polymorphism (lewat perulangan) ");
        for (Perangkat_Sekolah p : daftar) {
            p.tampilkanInformasi();
            System.out.println();
        }
    }
}