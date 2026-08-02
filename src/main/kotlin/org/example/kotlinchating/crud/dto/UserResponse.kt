package org.example.kotlinchating.crud.dto

import org.example.kotlinchating.crud.entity.User

data class UserResponse (
    val userId : String,
    val username : String,
    val userAge : Long,
    )
fun User.toResponse() : UserResponse = UserResponse(userId, username, userAge)