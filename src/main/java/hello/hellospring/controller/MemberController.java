package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
//import io.swagger.v3.oas.annotations.Hidden;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("sel/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PutMapping("update/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        return memberService.updateMember(id, updatedMember);
    }

//    @Hidden'
    @DeleteMapping("delete/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }


//    @DeleteMapping("/{id}")
//    public void deleteMember(@PathVariable Long id) {
//        System.out.println("삭제할 회원 ID: " + id);
//
//        try {
//            memberService.deleteMember(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
