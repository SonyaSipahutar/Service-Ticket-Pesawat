package com.ProyekPasti.Proyek.Repository;

import com.ProyekPasti.Proyek.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Login, String> {}
