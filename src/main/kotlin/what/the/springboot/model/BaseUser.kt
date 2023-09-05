package what.the.springboot.model

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.Where
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import what.the.springboot.dto.BaseUserRequest
import what.the.springboot.vo.RoleType
import java.time.LocalDateTime

@Entity
@Where(clause = "deleted_yn = 'N'")
@Comment("기본 회원 정보")
class BaseUser private constructor(request: BaseUserRequest, passwordEncoder: PasswordEncoder) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Comment("로그인 아이디")
    @Column(nullable = false)
    var username: String = request.username
        protected set

    @Comment("비밀번호")
    @Column(nullable = false)
    var password: String = passwordEncoder.encode(request.password)
        protected set

    @Comment("휴대전화번호")
    @Column(nullable = false)
    var mobilePhoneNo: String = request.mobilePhoneNo
        protected set

    @Comment("role 유형 (USER: 회원, ADMIN: 관리자)")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var roleType: RoleType = request.roleType
        protected set

    @Comment("가입일시")
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @Comment("수정일시")
    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    companion object {
        fun create(request: BaseUserRequest): BaseUser {
            val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
            return BaseUser(request, passwordEncoder)
        }
    }
}