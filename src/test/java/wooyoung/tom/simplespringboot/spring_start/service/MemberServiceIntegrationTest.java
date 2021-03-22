package wooyoung.tom.simplespringboot.spring_start.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import wooyoung.tom.simplespringboot.spring_start.repository.Member;
import wooyoung.tom.simplespringboot.spring_start.repository.MemberRepository;
import wooyoung.tom.simplespringboot.spring_start.service.MemberService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    // 테스트를 다른 곳에서 가져다 쓸 것이 아니라,
    // 테스트를 위해서만 주입을 받기 때문에 @Autowired 를 필드에서 사용해도 무관하다고 생각해도 된다.
    @Autowired
    MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // then
    }
}