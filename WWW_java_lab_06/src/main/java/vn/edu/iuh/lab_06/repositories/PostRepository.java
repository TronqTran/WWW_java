package vn.edu.iuh.lab_06.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.lab_06.models.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post>findAllByPublishedTrue();
    Optional<Post> findByIdAndPublishedTrue(Long id);

    List<Post>findAllByPublishedTrueAndAuthorId(Long id);
}
