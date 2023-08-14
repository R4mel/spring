package hello.spring.repository;

import hello.spring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // member 와 result 가 같으면 test case success!
        //System.out.println("result = " + (result == member));
        Assertions.assertEquals(result, member);
        Assertions.assertThat(member).isEqualTo(result);
    }
}
