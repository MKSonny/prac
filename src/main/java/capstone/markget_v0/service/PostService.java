package capstone.markget_v0.service;

import capstone.markget_v0.domain.Post;
import capstone.markget_v0.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post findPostByPostId(Long post_id) {
        return postRepository.findOne(post_id);
    }

    public void savePost(Post post) {
        postRepository.savePost(post);
    }

    public List<Post> findPostByUserId(String user_id) {
        return postRepository.findByUserId(user_id);
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
