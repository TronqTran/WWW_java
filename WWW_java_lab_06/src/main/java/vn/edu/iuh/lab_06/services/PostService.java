package vn.edu.iuh.lab_06.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_06.models.Post;
import vn.edu.iuh.lab_06.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void save(Post post){ postRepository.save(post); }

    public List<Post> getAllPublish(){
        return postRepository.findAllByPublishedTrue();
    }

    public Optional<Post>findByIdAndPublishTrue(Long id){
        return postRepository.findByIdAndPublishedTrue(id);
    }

    public List<Post>findByAuthorId(long id){
        return postRepository.findAllByPublishedTrueAndAuthorId(id);
    }
}