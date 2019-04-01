package my.examples.studymanager.controller.api;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Comment;
import my.examples.studymanager.dto.CommentDto;
import my.examples.studymanager.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestBody CommentDto commentDto){
        Comment comment = commentService.addComment(commentDto);
        return comment;
    }

    @GetMapping
    public List<Comment> getComments(@RequestParam(name = "studyContentId") Long studyContentId){
        List<Comment> list = commentService.getComments(studyContentId);
        return list;
    }
}
