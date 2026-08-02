package org.example.kotlinchating.crud.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "users")
data class User (
    @Id
    var userId : String,
    var username : String,
    var userpassword : String,
    var userAge : Long
    )