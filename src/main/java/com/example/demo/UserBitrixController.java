package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bitrix/users") // Puedes elegir una ruta base diferente
public class UserBitrixController {

    @Autowired
    private UserBitrixRepository userBitrixRepository;

    @GetMapping
    public ResponseEntity<List<UserBitrix>> listarUsersBitrix() {
        List<UserBitrix> users = userBitrixRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBitrix> obtenerUserBitrixPorId(@PathVariable Long id) {
        Optional<UserBitrix> user = userBitrixRepository.findById(id);
        return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UserBitrix> crearUserBitrix(@RequestBody UserBitrix userBitrix) {
        UserBitrix nuevoUser = userBitrixRepository.save(userBitrix);
        return new ResponseEntity<>(nuevoUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserBitrix> actualizarUserBitrix(@PathVariable Long id, @RequestBody UserBitrix userActualizado) {
        Optional<UserBitrix> userExistente = userBitrixRepository.findById(id);
        if (userExistente.isPresent()) {
            userActualizado.setIdSql(id); // Aseguramos que el ID sea el correcto para la actualización
            UserBitrix userGuardado = userBitrixRepository.save(userActualizado);
            return new ResponseEntity<>(userGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUserBitrix(@PathVariable Long id) {
        if (userBitrixRepository.existsById(id)) {
            userBitrixRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}