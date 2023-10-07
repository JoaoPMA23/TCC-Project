package com.example.teste

class CreateUser {
    var name: String = ""
    var email: String = ""
    var password: String = ""
    var code: String = ""
    var isSharing: String = ""
    var lat: String = ""
    var lng: String = ""
    var imageUrl: String = ""

    constructor() {}

    constructor(name: String, email: String, password: String, code: String, isSharing: String, lat: String, lng: String, imageUrl: String) {
        this.name = name
        this.email = email
        this.password = password
        this.code = code
        this.isSharing = isSharing
        this.lat = lat
        this.lng = lng
        this.imageUrl = imageUrl
    }
}
//Neste código Kotlin, as propriedades da classe CreateUser são declaradas diretamente no corpo da classe, e os modificadores de acesso public não são necessários, pois as propriedades são públicas por padrão em Kotlin. Além disso, os nomes das propriedades foram alterados para seguir a convenção de nomenclatura camelCase usada em Kotlin.







