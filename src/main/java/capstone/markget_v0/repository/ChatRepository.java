package capstone.markget_v0.repository;

import capstone.markget_v0.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ChatRepository {
    private final EntityManager em;

    public void saveMessage(Chat chat) {
        em.persist(chat);
    }
}
