package com.example.proyecto_coinmate.catalog

data class Coins(
    val id: String,
    val pais: String,
    val anno: String,
    val valor: String,
    val detalles: String,
    var comentarios: String,
    val imagen: String,
    var favourite: Boolean
)
