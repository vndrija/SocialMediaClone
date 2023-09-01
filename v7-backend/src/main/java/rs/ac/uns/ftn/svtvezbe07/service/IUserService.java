package rs.ac.uns.ftn.svtvezbe07.service;

import rs.ac.uns.ftn.svtvezbe07.constructor.UserConstructor;
import rs.ac.uns.ftn.svtvezbe07.model.entity.User;

public interface IUserService {
    User geOne(Long userId);

    User findByUsername(String username);


    User createUser(UserConstructor userDTO);

}
