package com.iesvirgendelcarmen.proyecto_jugueteria

data class Juguete(
    var nombre: String, var imagen: String, var id: Long, var categoria: String, var descripcion: String, var precio: Double) : java.io.Serializable