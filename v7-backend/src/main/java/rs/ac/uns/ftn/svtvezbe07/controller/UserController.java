package rs.ac.uns.ftn.svtvezbe07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.svtvezbe07.model.dto.JwtAuthenticationRequest;
import rs.ac.uns.ftn.svtvezbe07.model.dto.UserDTO;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Role;
import rs.ac.uns.ftn.svtvezbe07.model.entity.User;
import rs.ac.uns.ftn.svtvezbe07.security.TokenUtils;
import rs.ac.uns.ftn.svtvezbe07.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {


    @Autowired
    UserService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @PutMapping("/updatepassword/{old}")
    public ResponseEntity<User> create(@RequestBody User newUser, @PathVariable("old") String oldPassword) {

        String encodedPassword = service.geOne(newUser.getUserId()).getPassword();

        boolean match = passwordEncoder.matches(oldPassword, encodedPassword);
        System.out.println(oldPassword);
        System.out.println(service.geOne(newUser.getUserId()).getPassword());
        if(match){
            newUser.setRole(Role.USER);
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            User updatedUser = service.save(newUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(newUser, HttpStatus.NOT_ACCEPTABLE);
        }

    }
}

