package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.*;

@RestController
@RequestMapping("/api/deals")
public class DealController {

    @PostMapping
    public ResponseEntity<String> receiveDeal(@RequestBody DealDTO deal){

        System.out.println("Deal recibido: "+ deal);
        return ResponseEntity.ok("Deal recibido: "+ deal);
    }

    public static class DealDTO {
        public Long dealId;
        public String title;

        @Override
        public String toString() {
            return "DealDTO [dealId=" + dealId + ", title=" + title + "]";
        }
    }
}
