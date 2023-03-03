package capstone.markget_v0.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Chat {
    @Id @GeneratedValue
    @Column(name = "chat_id")
    private Long id;
    private String sender_id;
    private String receiver_id;
    private String message;
}
