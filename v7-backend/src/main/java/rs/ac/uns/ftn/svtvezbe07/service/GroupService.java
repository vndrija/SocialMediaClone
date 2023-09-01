package rs.ac.uns.ftn.svtvezbe07.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Group;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Post;
import rs.ac.uns.ftn.svtvezbe07.repository.GroupRepositery;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class GroupService {

    public final GroupRepositery groupRepositery;


    public List<Group> getAll() {
        return groupRepositery.findAll();
    }
    public Group getGroup(Long id) {
        return groupRepositery.findById(id).get();
    }
    @Transactional
    public Group save(Group group) {
        return groupRepositery.save(group);
    }
    public Group getGroupByPost(Post post) {
        List<Group> groups = getAll();
        for (Group group : groups) {
            List<Post> posts = group.getPosts();
            if (posts.contains(post)) {
                return group;
            }
        }
        return null;
    }


    @Transactional
    public void delete(Long id) {
        groupRepositery.deleteById(id);
    }


}

