package mk.ukim.finki.emt.lab.lab.service;

import mk.ukim.finki.emt.lab.lab.model.User;
import mk.ukim.finki.emt.lab.lab.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, Role role);
}
