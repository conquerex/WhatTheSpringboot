package what.the.springboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import what.the.springboot.model.BaseUser

@Repository
interface BaseUserRepository : JpaRepository<BaseUser, Long> {
    //
}