package lt.codeacademy.demo.service.imple;


import lt.codeacademy.demo.entity.Post;
import lt.codeacademy.demo.entity.User;
import lt.codeacademy.demo.repository.PostRepository;
import lt.codeacademy.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public record PostServiceImp(PostRepository postRepository) implements PostService {

    @Autowired
    public PostServiceImp {
    }

    @Override
    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
        return postRepository.findByUserOrderByCreateDateDesc(user, PageRequest.of(subtractPageByOne(page), 5));
    }

    @Override
    public Page<Post> findAllOrderedByDatePageable(int page) {
        return postRepository.findAllByOrderByCreateDateDesc(PageRequest.of(subtractPageByOne(page), 5));
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    private int subtractPageByOne(int page) {
        return (page < 1) ? 0 : page - 1;
    }
}
