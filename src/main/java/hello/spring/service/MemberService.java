package hello.spring.service;

import hello.spring.domain.Member;
import hello.spring.repository.MemberRepository;
import hello.spring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        // 변수 추출하기(Optional 부르는 단축키): 컨트롤 + 알트 + v
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // 위처럼 Optional을 바로 반환하는 것은 권장하지 않음.

        // 중복 회원 검증 -> 아래 함수 코드는 클래스 내부 코드였지만 하나의 기능을 하기 때문에 함수로 묶음.
        // 컨트롤 + 알트 + m
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).
                ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
