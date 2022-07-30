package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tacos.model.TacoAppUser;
import tacos.repository.UserRepository;

/**
 * todo Document type TacoAppUserService
 */
@Service
public class TacoAppUserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public TacoAppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TacoAppUser user = userRepository.findByUsername(username);
        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException(
            "User '" + username + "' was not found"
        );
    }
}
