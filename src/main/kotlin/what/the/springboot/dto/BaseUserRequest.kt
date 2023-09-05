package what.the.springboot.dto

import what.the.springboot.vo.RoleType

data class BaseUserRequest(
    val username: String, // 로그인 아이디
    val password: String,
    val mobilePhoneNo: String,
    val roleType: RoleType,
)
