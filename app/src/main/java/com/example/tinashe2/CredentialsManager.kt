package com.example.tinashe2

class CredentialsManager {
    private val users = mutableMapOf<String, String>()

    fun login(email: String, password: String): Boolean {
        return users[email.lowercase()] == password
    }

    fun register(email: String, password: String): Boolean {
        val key = email.lowercase()
        if (users.containsKey(key)) return false
        users[key] = password
        return true
    }
}
