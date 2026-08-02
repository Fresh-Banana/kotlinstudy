package org.example.kotlinchating.crud.controller

import org.example.kotlinchating.crud.dto.UserResponse
import org.example.kotlinchating.crud.dto.UserUpdateRequest
import org.example.kotlinchating.crud.dto.toResponse
import org.example.kotlinchating.crud.entity.User
import org.example.kotlinchating.crud.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (
    private val userService: UserService
){
    @PostMapping
    @RequestMapping("/users")
    fun create(@RequestBody user : User): UserResponse{
        return userService.create(user).toResponse()
    }

    @GetMapping("/user")
    fun findALl(): List<UserResponse>{
        return userService.findAll().map{ it.toResponse()}
    }

    @GetMapping("/users/{userid}")
    fun findById(@PathVariable userID: String) : UserResponse {
        return userService.findById(userID).toResponse()
    }

    @PutMapping("/users/{userid}")
    fun update(@PathVariable userID: String,@RequestBody request: UserUpdateRequest): UserResponse{
        return userService.update(userID, request).toResponse()
    }

    @DeleteMapping("/users/{userid}")
    fun delete(@PathVariable userID: String){
        userService.delete(userID)
    }
}