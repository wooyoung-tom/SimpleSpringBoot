package wooyoung.tom.simplespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wooyoung.tom.simplespringboot.repository.member.MemberRepository;
import wooyoung.tom.simplespringboot.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // DataSource 는 Spring 이 제공해준다.
//    private DataSource dataSource;
//
//    private EntityManager em;
//
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean
//    public MemberService memberService() {
//        // 아래에 있는 memberRepository Bean 주입
//        return new MemberService(memberRepository);
//    }
}
