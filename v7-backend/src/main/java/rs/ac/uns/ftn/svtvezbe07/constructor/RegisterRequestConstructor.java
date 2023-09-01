package rs.ac.uns.ftn.svtvezbe07.constructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequestConstructor {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}


