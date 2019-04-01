package my.examples.studymanager.service;

import my.examples.studymanager.domain.Comment;
import my.examples.studymanager.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public List<Comment> getComments(Long studyContentId);
    public Comment addComment(CommentDto comment);
    public void deleteComment(Long commentId);
    public void modifyComment(Long commentId, String commentContent);
}
