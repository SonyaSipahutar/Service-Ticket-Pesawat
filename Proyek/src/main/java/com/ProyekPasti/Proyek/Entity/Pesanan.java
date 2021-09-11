package com.ProyekPasti.Proyek.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Pesanan {
    @Id
    @Column(name="no_ktp")
    private String no_ktp;
    @Column(name="nama_Lengkap")
    private String nama_Lengkap;
    @Column(name="no_telp")
    private String no_telp;
    @Column(name="alamat")
    private String alamat;
    @Column(name="keberangkatan")
    private String keberangkatan;
    @Column(name="tujuan")
    private String tujuan;
    @Column(name="tanggal") // Mencatat waktu dibuat akun
    private Timestamp tanggal;
    @Column(name="kelas")
    private String kelas;
    @Column(name="email")
    private String email;
 
	public Pesanan(){}

    public Pesanan(String no_ktp,String nama_Lengkap,String no_telp, String alamat, String keberangkatan, String tujuan, Timestamp tanggal, String kelas, String email){
    this.no_ktp=no_ktp;
    this.nama_Lengkap=nama_Lengkap;
    this.no_telp=no_telp;
    this.alamat=alamat;
    this.keberangkatan=keberangkatan;
    this.tujuan=tujuan;
    this.tanggal=tanggal;
    this.kelas=kelas;
    this.email=email;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getNama_Lengkap() {
        return nama_Lengkap;
    }

    public void setNama_Lengkap(String nama_Lengkap) {
        this.nama_Lengkap = nama_Lengkap;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKeberangkatan() {
        return keberangkatan;
    }

    public void setKeberangkatan(String keberangkatan) {
        this.keberangkatan = keberangkatan;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Timestamp gettanggal() {
        return tanggal;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal= tanggal;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
