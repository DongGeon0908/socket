package com.goofy.socket.user.infrastructure

import arrow.atomic.AtomicLong
import com.goofy.socket.user.domain.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository {
    private val usersById = mutableMapOf<Long, User>()
    private val id = AtomicLong(0)

    fun save(user: User): User {
        return usersById.getOrPut(user.id) {
            User(
                id = id.incrementAndGet(),
                name = user.name
            )
        }
    }

    fun saveAll(users: List<User>): List<User> {
        return users.map { user -> save(user) }
    }

    fun findById(id: Long): User? {
        return usersById[id]
    }

    fun findAll(): List<User> {
        return usersById.values.toList()
    }
}
