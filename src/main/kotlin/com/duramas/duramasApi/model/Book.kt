package com.duramas.duramasApi.model

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var bookId: Long = 0,
    var nombre: String = "",
    var nombreAutor: String = "",
    var edicion: String = "",
    var precio: Double = 0.0
)
