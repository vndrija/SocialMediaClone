package rs.ac.uns.ftn.svtvezbe07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.svtvezbe07.constructor.UserConstructor;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Role;
import rs.ac.uns.ftn.svtvezbe07.model.entity.User;
import rs.ac.uns.ftn.svtvezbe07.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User geOne(Long userId) { return userRepository.getOne(userId);};
    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isEmpty()) {
            return user.get();
        }
        return null;
    }
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUser(UserConstructor userr) {

        Optional<User> user = userRepository.findByUsername(userr.getUsername());

        if(user.isPresent()){
            return null;
        }

        User newUser = new User();
        newUser.setUsername(userr.getUsername());
        newUser.setPassword(passwordEncoder.encode(userr.getPassword()));
        newUser.setRole(Role.USER);
        newUser.setFirstName(userr.getFirstName());
        newUser.setLastName(userr.getLastName());
        newUser.setEmail(userr.getEmail());
        newUser = userRepository.save(newUser);

        return newUser;
    }
}

