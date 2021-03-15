package wooyoung.tom.simplespringboot.repository.member

import wooyoung.tom.simplespringboot.domain.Member
import java.util.*
import javax.persistence.EntityManager

open class JpaMemberRepository(
    private val entityManager: EntityManager
) : MemberRepository {

    override fun save(member: Member): Member {
        entityManager.persist(member)
        return member
    }

    override fun findById(id: Long?): Optional<Member> {
        val member = entityManager.find(Member::class.java, id)
        return Optional.ofNullable(member)
    }

    override fun findByName(name: String?): Optional<Member> {
        return entityManager.createQuery("SELECT m from Member m WHERE m.name = :name", Member::class.java)
            .setParameter("name", name)
            .resultList.stream().findAny()
    }

    override fun findAll(): MutableList<Member> {
        return entityManager.createQuery("SELECT m FROM Member m", Member::class.java).resultList
    }
}