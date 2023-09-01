package rs.ac.uns.ftn.svtvezbe07.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Comment;
import rs.ac.uns.ftn.svtvezbe07.repository.CommentRepositery;

@Service
@AllArgsConstructor

public class CommentService {

    private final CommentRepositery commentRepositery;

    @Transactional
    public Comment save(Comment comment) {
        return commentRepositery.save(comment);
    }

    @Transactional
    public void delete(Comment comment){commentRepositery.delete(comment);}

}

