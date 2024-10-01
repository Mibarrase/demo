package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Tienda;

@Repository
public interface TiendaRepositorio extends JpaRepository<Tienda, Long> {

}