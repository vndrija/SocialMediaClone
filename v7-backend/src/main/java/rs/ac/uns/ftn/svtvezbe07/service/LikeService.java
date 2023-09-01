package rs.ac.uns.ftn.svtvezbe07.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Like;
import rs.ac.uns.ftn.svtvezbe07.repository.LikeRepositery;

@Service
@AllArgsConstructor


public class LikeService {
    private final LikeRepositery likeRepositery;

    @Transactional
    public Like save(Like like) {
        return likeRepositery.save(like);
    }

    @Transactional
    public void delete(Like like){likeRepositery.delete(like);}

}

