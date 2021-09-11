package com.ProyekPasti.Proyek.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListTiket {
	
	@Id
    @Column(name="idTiket")
    private String idTiket;
	@Column(name="keberangkatan")
    private String keberangkatan;
    @Column(name="tujuan")
    private String tujuan;
    @Column(name="Kelas")
    private String kelas;
    @Column(name="Tanggal") 
    private Timestamp tanggal;
    
    public ListTiket(){}
    
    public ListTiket(String idTiket, String keberangkatan, String tujuan, String kelas, Timestamp tanggal) {
		super();
		this.idTiket = idTiket;
		this.keberangkatan = keberangkatan;
		this.tujuan = tujuan;
		this.kelas = kelas;
		this.tanggal = tanggal;
	}
    
    public String getIdTiket() {
		return idTiket;
	}
	public void setIdTiket(String idTiket) {
		this.idTiket = idTiket;
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
	public String getKelas() {
		return kelas;
	}
	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	public Timestamp getTanggal() {
		return tanggal;
	}
	public void setTanggal(Timestamp tanggal) {
		this.tanggal = tanggal;
	}

}
