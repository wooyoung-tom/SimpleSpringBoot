package wooyoung.tom.simplespringboot.market.entity

import javax.persistence.*

@Entity
@Table(name = "market_user")
data class MarketUserEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

)
