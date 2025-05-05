package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitrixWebhookController {

    @Autowired
    private UserBitrixRepository userBitrixRepository;

    // Endpoint para recibir el webhook de Bitrix24 cuando se crea un usuario
    @PostMapping("/bitrix/webhook/new-user")
    public ResponseEntity<String> handleNewUser(
            @RequestBody UserBitrix userBitrix, // Bitrix24 envía los datos del usuario en el body
            @RequestHeader("X-Bitrix-Signature") String signature // Para validar la autenticidad (opcional)
    ) {
        // Valida la firma si es necesario (depende de la configuración de Bitrix24)
        // if (!isValidSignature(signature)) {
        //     return new ResponseEntity<>("Firma inválida", HttpStatus.UNAUTHORIZED);
        // }

        // Guarda el usuario en la base de datos
        userBitrixRepository.save(userBitrix);
        return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
    }

    // Método de ejemplo para validar la firma (ajusta según la documentación de Bitrix24)
    private boolean isValidSignature(String signature) {
        // Implementa lógica de validación aquí
        return true; // Temporalmente retorna true para pruebas
    }
}