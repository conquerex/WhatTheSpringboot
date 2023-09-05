package what.the.springboot.vo

enum class RoleType(override val description: String) : EnumDescription {
    USER("회원"),
    ADMIN("관리자"),
    INACTIVE_USER("휴면 회원")
}