package hello.spring;

import hello.spring.repository.MemberRepository;
import hello.spring.repository.MemoryMemberRepository;
import hello.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 자바 코드로 빈 등록하기
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}