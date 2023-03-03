package capstone.markget_v0.controller;
import capstone.markget_v0.domain.Member;
import capstone.markget_v0.domain.Post;
import capstone.markget_v0.service.MemberService;
import capstone.markget_v0.service.PostService;
import capstone.markget_v0.session.SessionConst;
import capstone.markget_v0.session.SessionManager;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;
    private final SessionManager sessionManager;

    //@PostMapping("/members/new")
    public void create(@RequestBody CreateMemberRequest request) {
        Member member = new Member();
        member.setUser_id(request.getUser_id());

        memberService.join(member);
    }

    // @PostMapping("/members/new")
    public void createV2(@RequestBody CreateMemberRequest request, HttpServletResponse response) {
        Member member = new Member();
        member.setUser_id(request.getUser_id());

        // 세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
        sessionManager.createSession(member, response);

        memberService.join(member);
    }
    @PostMapping("/members/new")
    public void createV3(@RequestBody CreateMemberRequest request, HttpServletRequest httpServletRequest) {

        log.info("@PostMapping(\"/members/new\")");

        Member member = new Member();
        member.setUser_id(request.getUser_id());

        Post post = new Post();
        post.setPost_title("hello world1");
        post.setWho_posted(member);

        Post post2 = new Post();
        post2.setPost_title("hello world2");
        post2.setWho_posted(member);

        memberService.join(member);

        postService.savePost(post);
        postService.savePost(post2);

//         세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
        HttpSession session = httpServletRequest.getSession();
        if (session == null) {
            log.info("session is null ;;");
        }
        else {
            log.info("session is not null?");
        }
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);
//        SessionConst.POST_ENDED = true;
    }

    // @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        sessionManager.expire(request);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logoutV2(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @Data
    static class CreateMemberRequest {
        private String user_id;
    }
}
