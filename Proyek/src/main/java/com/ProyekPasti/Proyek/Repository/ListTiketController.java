package com.ProyekPasti.Proyek.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProyekPasti.Proyek.Response;
import com.ProyekPasti.Proyek.Entity.ListTiket;

@RestController
@RequestMapping("/ListTiket")
public class ListTiketController {

	@Autowired
    private ListTiketInterface tiketRepository;
    private final Date sysDate = new Date();
    private final Timestamp sqlTime = new Timestamp(sysDate.getTime());


    @PostMapping(path = "/masukkanData",produces = MediaType.APPLICATION_JSON_VALUE)  // JSON tipe data Global
    public Response<?,?,?> insertData(@RequestBody ListTiket data){
        if(tiketRepository.existsById(data.getIdTiket())){
            return new Response<>(HttpStatus.BAD_REQUEST.value(),"Nomor KTP sudah Terdaftar!");
        }

        // update tanggal
        data.setTanggal(sqlTime);

        // Menyimpan ke Database
        tiketRepository.save(data);

        return new Response<>(HttpStatus.CREATED.value(),data,"Berhasil!");
    }

    @GetMapping(path = "/ambilDataById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> getById(@RequestParam("idTiket") String idTiket){
        if(tiketRepository.existsById(idTiket)){
            ListTiket tiketDB = tiketRepository.findById(idTiket).get();
            return new Response<>(HttpStatus.OK.value(),tiketDB,"Berhasil!");
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value(),"Nomor KTP tidak ditemukan!");
    }

    @GetMapping(path = "/ambilSemuaData",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> getAll(){
        List<ListTiket> listTiket = tiketRepository.findAll();
        return new Response<>(HttpStatus.OK.value(),listTiket,"Berhasil!");
    }

    @PostMapping(path = "/perbaharuiData",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> updateData(@RequestBody ListTiket updateData){
        if(tiketRepository.existsById(updateData.getIdTiket())){
            // ambil Data Lama
            ListTiket oldData = tiketRepository.findById(updateData.getIdTiket()).get();

            // update Data
            oldData.setKelas(updateData.getKelas());
            oldData.setKeberangkatan(updateData.getKeberangkatan());
            oldData.setTanggal(updateData.getTanggal());
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
    public Response<?,?,?> deleteData(@RequestParam String idTiket){
        if(tiketRepository.existsById(idTiket)){
            tiketRepository.deleteById(idTiket);
            return new Response<>(HttpStatus.OK.value(),"Berhasil Dihapus!");
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value(),"Data berhasil di hapus!");
    }
}
