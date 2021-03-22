package wooyoung.tom.simplespringboot.spring_start.repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    // Null 을 처리하기 위하여 Optional 반환
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    List<Member> findAll();
}
