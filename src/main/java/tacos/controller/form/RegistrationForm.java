package tacos.controller.form;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.model.TacoAppUser;

/**
 * todo Document type RegistrationForm
 */
@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public TacoAppUser toUser(PasswordEncoder passwordEncoder) {
        return new TacoAppUser(
            username, passwordEncoder.encode(password),
            fullname, street, city, state, zip, phone);
    }
}
