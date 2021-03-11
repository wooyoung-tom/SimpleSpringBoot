package wooyoung.tom.simplespringboot.repository;

import wooyoung.tom.simplespringboot.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    // 메모리 내부에 있기 때문에 서버가 꺼지면 데이터가 날라간다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
