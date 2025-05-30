package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
// Importa la anotación `JsonProperty` de Jackson para mapear campos JSON a atributos de la clase.

import jakarta.persistence.*;
// Importa las anotaciones de JPA (Java Persistence API) para la persistencia de datos en una base de datos.

// Declara la entidad que representa una tabla en la base de datos.
@Entity
@Table(name = "User_Bitrix") 
// Especifica que esta clase está mapeada a la tabla "User_Bitrix" en la base de datos.
public class UserBitrix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Indica que el atributo `idSql` es la clave primaria y su valor se genera automáticamente.
    @Column(name = "IDSQL") 
    // Mapea este atributo a la columna "IDSQL" de la tabla en la base de datos.
    private Long idSql; 
    // Representa el identificador único en la base de datos.

    @Column(name = "id") 
    // Mapea este atributo a la columna "id" en la base de datos.
    @JsonProperty("id") 
    // Indica que este atributo se mapeará al campo "id" en un JSON (usado por Bitrix24).
    private String id; 
    // Representa el identificador del usuario proveniente de Bitrix24.

    @Column(name = "name") 
    // Mapea este atributo a la columna "name" en la base de datos.
    @JsonProperty("name") 
    // Indica que este atributo se mapeará al campo "name" en un JSON (usado por Bitrix24).
    private String name; 
    // Representa el nombre del usuario.

    @Column(name = "last_name") 
    // Mapea este atributo a la columna "last_name" en la base de datos.
    @JsonProperty("last_name") 
    // Indica que este atributo se mapeará al campo "last_name" en un JSON (usado por Bitrix24).
    private String last_name; 
    // Representa el apellido del usuario.

    @Column(name = "email") 
    // Mapea este atributo a la columna "email" en la base de datos.
    @JsonProperty("email") 
    // Indica que este atributo se mapeará al campo "email" en un JSON (usado por Bitrix24).
    private String email; 
    // Representa el correo electrónico del usuario.

    // Constructor por defecto (sin argumentos).
    public UserBitrix() {
    }

    // Constructor con argumentos para inicializar todos los atributos.
    public UserBitrix(String id, String name, String last_name, String email) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    // Métodos getter para obtener los valores de los atributos.
    public Long getIdSql() {
        return idSql; 
        // Devuelve el valor de `idSql` (clave primaria en la base de datos).
    }

    public String getId() {
        return id; 
        // Devuelve el identificador del usuario proveniente de Bitrix24.
    }

    public String getName() {
        return name; 
        // Devuelve el nombre del usuario.
    }

    public String getLast_name() {
        return last_name; 
        // Devuelve el apellido del usuario.
    }

    public String getEmail() {
        return email; 
        // Devuelve el correo electrónico del usuario.
    }

    // Métodos setter para modificar los valores de los atributos.
    public void setIdSql(Long idSql) {
        this.idSql = idSql; 
        // Establece el valor de `idSql` (clave primaria en la base de datos).
    }

    public void setId(String id) {
        this.id = id; 
        // Establece el identificador del usuario proveniente de Bitrix24.
    }

    public void setName(String name) {
        this.name = name; 
        // Establece el nombre del usuario.
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name; 
        // Establece el apellido del usuario.
    }

    public void setEmail(String email) {
        this.email = email; 
        // Establece el correo electrónico del usuario.
    }
}
