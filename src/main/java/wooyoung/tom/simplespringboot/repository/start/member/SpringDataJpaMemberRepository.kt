package wooyoung.tom.simplespringboot.repository.start.member

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SpringDataJpaMemberRepository: JpaRepository<Member, Long>, MemberRepository {

    override fun findByName(name: String): Optional<Member>
}