package wooyoung.tom.simplespringboot.user

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "market_user")
data class MarketUserEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username")
    val userName: String,

    @JsonIgnore
    @Column(name = "password")
    val password: String,

    /**
     * TODO favorite, review, order 연관관계 설정
     *  모두 user_id 로 불러올 수 있음
     */
)