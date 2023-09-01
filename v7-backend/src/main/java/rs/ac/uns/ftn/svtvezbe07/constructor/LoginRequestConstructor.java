package rs.ac.uns.ftn.svtvezbe07.constructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginRequestConstructor {
    private String username;
    private String password;

}
