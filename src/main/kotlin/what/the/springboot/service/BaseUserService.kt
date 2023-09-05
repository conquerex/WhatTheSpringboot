package what.the.springboot.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import what.the.springboot.dto.BaseUserRequest
import what.the.springboot.model.BaseUser
import what.the.springboot.repository.BaseUserRepository

@Service
@Transactional
class BaseUserService(
    private val baseUserRepository: BaseUserRepository,
) {
    fun createBaseUser(baseUserRequest: BaseUserRequest) {
        baseUserRepository.save(BaseUser.create(baseUserRequest))
    }

}