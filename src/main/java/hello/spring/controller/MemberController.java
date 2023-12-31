package hello.spring.controller;

import hello.spring.domain.Member;
import hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired // memberService를 가져와서 연결해준다.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    // 의존성 주입에는 필드 주입, Setter 주입, 생성자 주입이 있다.
    // 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.

    @RequestMapping(value="/members/new", method = {RequestMethod.GET})
    public String createForm(){
        return "members/createMemberForm";
    }

    @RequestMapping(value="/members/new", method = {RequestMethod.POST})
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

            return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
