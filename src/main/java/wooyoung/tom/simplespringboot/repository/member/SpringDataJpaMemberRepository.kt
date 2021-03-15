package wooyoung.tom.simplespringboot.repository.member

import org.springframework.data.jpa.repository.JpaRepository
import wooyoung.tom.simplespringboot.domain.Member
import java.util.*

interface SpringDataJpaMemberRepository: JpaRepository<Member, Long>, MemberRepository {

    override fun findByName(name: String): Optional<Member>
}