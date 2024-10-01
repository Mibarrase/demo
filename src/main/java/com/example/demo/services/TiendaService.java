package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Tienda;
import com.example.demo.repositorios.TiendaRepositorio;

@Service
public class TiendaService {
    @Autowired
    private TiendaRepositorio tiendaRepositorio;

    public List<Tienda> obtenerTodos() {
        return tiendaRepositorio.findAll(); 
    }

    public Optional<Tienda> obtenerPorId(Long id) {
        return tiendaRepositorio.findById(id);
    }

    public Tienda crearTienda(Tienda tienda) {
        return tiendaRepositorio.save(tienda);
    }

    public Tienda actualizarTienda(Tienda tienda) {
        return tiendaRepositorio.save(tienda);
    }

    public void eliminarTienda(Long id) {
        tiendaRepositorio.deleteById(id);
    }
}
