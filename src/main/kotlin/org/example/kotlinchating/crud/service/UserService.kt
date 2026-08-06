package org.example.kotlinchating.crud.service

import org.example.kotlinchating.crud.dto.UserUpdateRequest
import org.example.kotlinchating.crud.entity.User
import org.example.kotlinchating.crud.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
){
    fun create(user : User): User {
        if(userRepository.existsById(user.userId)){
            throw IllegalArgumentException("이미 가입된 유저입니다: ${user.userId}")
        }
        val toSave = user.copy(userpassword = passwordEncoder.encode(user.userpassword)!!)
        return userRepository.save(toSave)
    }

    fun findAll(): List<User>{
        return userRepository.findAll()
    }

    fun findById(userId: String): User{
        return userRepository.findById(userId).get()
    }
    fun update(userId: String, request: UserUpdateRequest): User {
        val existing = findById(userId)
        val toSave = existing.copy(
            username = request.username ?: existing.username,
            userpassword = request.userpassword?.let { passwordEncoder.encode(it)!! } ?: existing.userpassword,
            userAge = request.userAge ?: existing.userAge
        )
        return userRepository.save(toSave)
    }

    fun delete(userId: String){
        userRepository.deleteById(userId)
    }
}