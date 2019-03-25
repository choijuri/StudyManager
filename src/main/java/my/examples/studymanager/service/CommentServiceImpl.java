package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Comment;
import my.examples.studymanager.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getComment(Long studyContentId) {
        return null;
    }

    @Override
    public void addComment(Comment comment, String userId) {

    }

    @Override
    public boolean deleteComment(Long commentId) {
        return false;
    }

    @Override
    public boolean modifyComment(Comment comment) {
        return false;
    }
}
