package com.ProyekPasti.Proyek.Repository;

import com.ProyekPasti.Proyek.Entity.Login;
import com.ProyekPasti.Proyek.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/ambilDataById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?,?,?> getById(@RequestParam("email") String userEmail){
        if(userRepository.existsById(userEmail)){
            Login userDB = userRepository.findById(userEmail).get();
            return new Response<>(HttpStatus.OK.value(),userDB,"Berhasil!");
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value(),"User tidak ditemukan!");
    }

}
