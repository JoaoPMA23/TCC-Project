package com.example.teste

public class CreateUser(
    val name: String,
    val email: String,
    val password: String,
    val code: String,
    val isSharing: String,
    val lat: String,
    val lng: String,
    val imageUrl: String
) {
    constructor() : this("", "", "", "", false, 0.0, 0.0, "") {
        // Pode inicializar propriedades adicionais, se necessário
    }
}
