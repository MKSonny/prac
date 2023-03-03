package capstone.markget_v0.repository;

import capstone.markget_v0.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Member findMemberByUserId(String user_id) {
        return em.createQuery("select m from Member m where m.user_id = :user_id", Member.class)
                .setParameter("user_id", user_id)
                .getSingleResult();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    // 찜 목록 추가 함수
//    public void addLiked(Post post, Long id) {
//        Member member = em.find(Member.class, id);
//        member.addLiked(post);
//    }

    // 사용자가 게시한 게시물들을 모두 조회하는 방법에 있어 어려움을 겪음

}
