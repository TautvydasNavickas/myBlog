package lt.codeacademy.demo.service.imple;


import lt.codeacademy.demo.entity.Comment;
import lt.codeacademy.demo.repository.CommentRepository;
import lt.codeacademy.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public record CommentServiceImp(
        CommentRepository commentRepository) implements CommentService {

    @Autowired
    public CommentServiceImp {
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }
}
