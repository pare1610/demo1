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

    @Column(name = "id") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("id") // Si el JSON de Bitrix24 usa "ID"
    private String id;

    @Column(name = "name") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("name") // Si el JSON de Bitrix24 usa "NAME"
    private String name;

    @Column(name = "last_name") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("last_name") // Si el JSON de Bitrix24 usa "LAST_NAME"
    private String last_name;

    @Column(name = "email") // Especifica el nombre de la columna en la base de datos
    @JsonProperty("email") // Si el JSON de Bitrix24 usa "EMAIL"
    private String email;

    // Constructores (sin argumentos y con argumentos)
    public UserBitrix() {
    }

    public UserBitrix(String id, String name, String last_name, String email) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    // Getters
    public Long getIdSql() {
        return idSql;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setIdSql(Long idSql) {
        this.idSql = idSql;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
