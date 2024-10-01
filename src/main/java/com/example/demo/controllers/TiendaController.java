package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Tienda;
import com.example.demo.services.TiendaService;

@RequestMapping ("/api/tiendadb")
@RestController
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    // Obtener todas las tiendas
    @GetMapping
    public List<com.example.demo.models.Tienda> obtenerTiendas() {
        return tiendaService.obtenerTodos();
    }

    // Obtener tienda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tienda> obtenerTiendaPorId(@PathVariable Long id) {
        return tiendaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva tienda
    @PostMapping
    public Tienda crearTienda(@RequestBody Tienda tienda) {
        return tiendaService.crearTienda(tienda);
    }

    // Actualizar una tienda existente
    @PutMapping("/{id}")
    public ResponseEntity<Tienda> actualizarTienda(@PathVariable Long id, @RequestBody Tienda detallesTienda) {
        return tiendaService.obtenerPorId(id)
                .map(tienda -> {
                    tienda.setNombre(detallesTienda.getNombre());
                    tienda.setMascota(detallesTienda.getMascota()); 
                    return ResponseEntity.ok(tiendaService.actualizarTienda(tienda));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Eliminar una tienda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTienda(@PathVariable Long id) {
        Optional<Tienda> tienda = tiendaService.obtenerPorId(id);
        
        if (tienda.isPresent()) {
            tiendaService.eliminarTienda(id);
            return ResponseEntity.ok().build(); 
        } else {
            return ResponseEntity.notFound().build();  
        }
    }
}
