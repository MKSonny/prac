package capstone.markget_v0.repository;

import capstone.markget_v0.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final EntityManager em;

    public void savePost(Post post) {
        em.persist(post);
    }

    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findAll() {
        return em.createQuery("select p from Post p")
                .getResultList();
    }

    public List<Post> findByUserId(String user_id) {
        String jpql = "select p from Post p join p.who_posted m where m.user_id = :user_id";

        return em.createQuery(jpql, Post.class)
                .setParameter("user_id", user_id)
                .getResultList();
    }
}
