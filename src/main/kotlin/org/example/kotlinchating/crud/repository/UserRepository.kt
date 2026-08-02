package org.example.kotlinchating.crud.repository

import org.example.kotlinchating.crud.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
    fun findByUsername(username:String): User?
    fun existsByUsername(username: String): Boolean
}