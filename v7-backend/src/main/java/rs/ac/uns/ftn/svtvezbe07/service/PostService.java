package rs.ac.uns.ftn.svtvezbe07.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Group;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Post;
import rs.ac.uns.ftn.svtvezbe07.repository.GroupRepositery;
import rs.ac.uns.ftn.svtvezbe07.repository.PostRepositery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j


public class PostService {
    public final PostRepositery postRepositery;

    public final GroupRepositery groupRepositery;

    public List<Post> getAll() {
        return postRepositery.findAll();
    }
    public Post getPost(Long id) {
        return postRepositery.findById(id).get();
    }
    @Transactional
    public Post save(Post post) {
        return postRepositery.save(post);
    }


    @Transactional
    public void delete(Long id) {
        postRepositery.deleteById(id);
    }



    public List<Post> getGroupPosts(Long id) {
        Group group = groupRepositery.findById(id).get();
        return group.getPosts();
    }

}

