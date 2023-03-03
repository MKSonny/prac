package capstone.markget_v0.session;

import capstone.markget_v0.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {
    SessionManager sessionManager = new SessionManager();

    @Test
    public void sessionTest() throws Exception {
        MockHttpServletResponse response = new MockHttpServletResponse();
        // 서버에서 세션을 다만들고 쿠키까지 다만들어서 response 에 담아넣음
        Member member = new Member();
        sessionManager.createSession(member, response);
        // 요청에 응답 쿠키가 저장되어 있는지 확인, 웹브라우저의 요청
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        // 세션 조회
        Object result = sessionManager.getSession(request);
        Assertions.assertThat(result).isEqualTo(member);

        // 세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        Assertions.assertThat(expired).isNull();
    }
}