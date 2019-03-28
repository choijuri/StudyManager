package my.examples.studymanager.service;

import my.examples.studymanager.domain.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getComment(Long studyContentId);
    public void addComment(Comment comment, Long userId);
    public void deleteComment(Long commentId);
    public void modifyComment(Long commentId, String commentContent);
}
