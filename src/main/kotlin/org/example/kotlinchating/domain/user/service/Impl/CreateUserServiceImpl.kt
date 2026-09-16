package org.example.kotlinchating.domain.user.service.Impl

import jakarta.transaction.Transactional
import org.example.kotlinchating.domain.user.entity.User
import org.example.kotlinchating.domain.user.presentation.data.request.UserRequest
import org.example.kotlinchating.domain.user.presentation.data.response.UserCreateResponse
import org.example.kotlinchating.domain.user.repository.UserInterface
import org.example.kotlinchating.domain.user.service.CreateUserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Transactional
class CreateUserServiceImpl(
    private val userInterface: UserInterface,
    private val passwordEncode : PasswordEncoder
) : CreateUserService{
    override fun createUser(request: UserRequest) : UserCreateResponse {
        val encodedpassword = passwordEncode.encode(request.password)!!;
        val user = User.create(request ,encodedpassword)
        userInterface.save(user)

        return UserCreateResponse(
            id = user.id,
            name = user.name,
            sex = user.sex,
            role = user.role,
        )
    }
}