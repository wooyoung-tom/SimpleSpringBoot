package wooyoung.tom.simplespringboot.spring_start.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wooyoung.tom.simplespringboot.spring_start.repository.Member;
import wooyoung.tom.simplespringboot.spring_start.repository.MemberRepository;
import wooyoung.tom.simplespringboot.spring_start.repository.SpringDataJpaMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final SpringDataJpaMemberRepository memberRepository;

    public MemberService(SpringDataJpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 중복 회원 검증
        validateDuplicateMEmber(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMEmber(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조희
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

//    public Optional<Member> findOne(Long memberId) {
//        return memberRepository.findById(memberId);
//    }
}
