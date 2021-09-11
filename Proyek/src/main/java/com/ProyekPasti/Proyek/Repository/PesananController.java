package com.ProyekPasti.Proyek.Repository;

import com.ProyekPasti.Proyek.Entity.Pesanan;
import com.ProyekPasti.Proyek.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/Pesanan")
public class PesananController {
    @Autowired
    private PesananInterface tiketRepository;
    private final Date sysDate = new Date();
    private final Timestamp sqlTime = new Timestamp(sysDate.getTime());


    @PostMapping(path = "/masukkanData",produces = MediaType.APPLICATION_JSON_VALUE)  // JSON tipe data Global
    public Response<?,?,?> insertData(@RequestBody Pesanan data){
        if(tiketRepository.existsById(data.getNo_ktp())){
            return new Response<>(HttpStatus.BAD_REQUEST.value(),"Nomor KTP sudah Terdaftar!");
        }

        // update tanggal
        data.setTanggal(sqlTime);

        // Menyimpan ke Database
        tiketRepository.save(data);

        return new Response<>(HttpStatus.CREATED.value(),data,"Berhasil!");
    }

    @GetMapping(path = "/ambilDataById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> getById(@RequestParam("no_ktp") String no_ktp){
        if(tiketRepository.existsById(no_ktp)){
            Pesanan tiketDB = tiketRepository.findById(no_ktp).get();
            return new Response<>(HttpStatus.OK.value(),tiketDB,"Berhasil!");
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value(),"Nomor KTP tidak ditemukan!");
    }

    @GetMapping(path = "/ambilSemuaData",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> getAll(){
        List<Pesanan> listTiket = tiketRepository.findAll();
        return new Response<>(HttpStatus.OK.value(),listTiket,"Berhasil!");
    }

    @PostMapping(path = "/perbaharuiData",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> updateData(@RequestBody Pesanan updateData){
        if(tiketRepository.existsById(updateData.getNo_ktp())){
            // ambil Data Lama
            Pesanan oldData = tiketRepository.findById(updateData.getNo_ktp()).get();

            // update Data
            oldData.setTanggal(updateData.gettanggal());
            oldData.setTujuan(updateData.getTujuan());

            // update updatedAt
            oldData.setTanggal(sqlTime);

            // Save ke database
           tiketRepository.save(oldData);
            return new Response<>(HttpStatus.OK.value(),oldData,"Berhasil!");
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value(),"Data berhasil di masukkan!");
    }

    @PostMapping(path = "/hapusData",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> deleteData(@RequestParam String no_ktp){
        if(tiketRepository.existsById(no_ktp)){
            tiketRepository.deleteById(no_ktp);
            return new Response<>(HttpStatus.OK.value(),"Berhasil Dihapus!");
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value(),"Data berhasil di hapus!");
    }
}
