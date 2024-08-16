package com.goofy.socket.user.resource

import com.goofy.socket.user.application.UserService
import com.goofy.socket.user.model.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserResource(
    private val userService: UserService,
) {
    @GetMapping("/api/v1/users")
    fun getUsers() = userService.getAll()

    @PostMapping("/api/v1/users")
    fun create(
        @RequestBody request: UserRequest,
    ) = userService.create(request)

    @PostMapping("/api/dev/v1/users")
    fun devBulkCreate() = userService.bulk()
}
