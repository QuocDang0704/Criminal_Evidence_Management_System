package fis.quocdb3.payload.request;

import fis.quocdb3.domain.enums.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignupRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    private Rank rank;
}
