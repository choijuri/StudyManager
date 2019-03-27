package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Comment;
import my.examples.studymanager.repository.CommentRepository;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getComment(Long studyContentId) {
        return commentRepository.getCommentByStudyContentId(studyContentId);
    }

    @Override
    @Transactional
    public void addComment(Comment comment, String userId) {
        comment.setUser(userRepository.getOne(userId));
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional
    public void modifyComment(Comment comment) {

    }
}
