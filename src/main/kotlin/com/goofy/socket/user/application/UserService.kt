package com.goofy.socket.user.application

import com.goofy.socket.user.domain.User
import com.goofy.socket.user.infrastructure.UserRepository
import com.goofy.socket.user.model.UserRequest
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun getAll(): List<User> {
        return userRepository.findAll()
    }

    fun create(request: UserRequest): User {
        return userRepository.save(User(name = request.name))
    }

    fun bulk(): List<User> {
        val users = (1..10).map { seq ->
            User(name = "user-$seq")
        }

        return userRepository.saveAll(users)
    }
}
