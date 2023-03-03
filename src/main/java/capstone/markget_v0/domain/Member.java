package capstone.markget_v0.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name =  "member_id")
    private Long id;
    private String user_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id")
    private Track track;
    private String username;
//    @OneToMany
//    private List<Post> liked = new ArrayList<>();
//
//    public void addLiked(Post post) {
//        liked.add(post);
//    }
}