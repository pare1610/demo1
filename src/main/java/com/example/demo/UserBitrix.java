package com.example.demo;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table (name= "User_Bitrix")
public class UserBitrix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSQL") // Especifica el nombre de la columna en la base de datos
    private Long idSql;

    @Column(name = "ID") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("ID") // Si el JSON de Bitrix24 usa "ID"
    private String idBitrix;

    @Column(name = "NAME") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("NAME") // Si el JSON de Bitrix24 usa "NAME"
    private String nombre;

    @Column(name = "LAST_NAME") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("LAST_NAME") // Si el JSON de Bitrix24 usa "LAST_NAME"
    private String apellido;

    @Column(name = "EMAIL") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("EMAIL") // Si el JSON de Bitrix24 usa "EMAIL"
    private String email;

    // Constructores (sin argumentos y con argumentos)
    public UserBitrix() {
    }

    public UserBitrix(String idBitrix, String nombre, String apellido, String email) {
        this.idBitrix = idBitrix;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Getters
    public Long getIdSql() {
        return idSql;
    }

    public String getIdBitrix() {
        return idBitrix;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setIdSql(Long idSql) {
        this.idSql = idSql;
    }

    public void setIdBitrix(String idBitrix) {
        this.idBitrix = idBitrix;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
