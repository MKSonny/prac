package capstone.markget_v0.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Post {
    @Id @GeneratedValue
    private Long postId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member who_posted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    protected Category category;
    private Integer price;

    private String post_title;
    private String post_text;
    // time
    // place
    // depart
    // image
    public Post() {
    }

    public Post(String post_title, String post_text) {
        this.post_title = post_title;
        this.post_text = post_text;
    }
}
