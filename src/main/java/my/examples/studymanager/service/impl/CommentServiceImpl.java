package my.examples.studymanager.service.impl;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Comment;
import my.examples.studymanager.dto.CommentDto;
import my.examples.studymanager.repository.CommentRepository;
import my.examples.studymanager.repository.StudyContentRepository;
import my.examples.studymanager.repository.UserRepository;
import my.examples.studymanager.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final StudyContentRepository studyContentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getComments(Long studyContentId) {
        return commentRepository.getCommentByStudyContentId(studyContentId);
    }

    @Override
    @Transactional
    public Comment addComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setUser(userRepository.getOne(commentDto.getUserId()));
        comment.setStudyContent(studyContentRepository.getOne(commentDto.getStudyContentId()));
        comment.setCommentContent(commentDto.getContent());
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional
    public void modifyComment(Long commentId, String commentContent) {
        Comment comment = commentRepository.getOne(commentId);
        comment.setCommentContent(commentContent);
        commentRepository.save(comment);
    }
}
