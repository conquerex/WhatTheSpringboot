package what.the.springboot.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import what.the.springboot.dto.BaseUserRequest
import what.the.springboot.service.BaseUserService

@RestController
@RequestMapping("/base-user")
class BaseUserController(
    private val baseUserService: BaseUserService,
) {
    @PostMapping("/create")
    fun create(@RequestBody baseUserRequest: BaseUserRequest) {
        baseUserService.createBaseUser(baseUserRequest)
    }
}