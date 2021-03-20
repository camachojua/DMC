package com.example.dmc.Persona

class Persona constructor(Nombre: String, Password: String, Apodo: String) {
    private val Nombre: String = Nombre;
    private val Password: String = Password;
    private val Apodo: String = Apodo;

    public fun checaPassword (Password: String): Boolean {
        if (Password === this.Password) return true;
        return false;
    }

    public fun getNombre(): String {
        return this.Nombre;
    }

    public fun getApodo(): String {
        return this.Apodo;
    }
}