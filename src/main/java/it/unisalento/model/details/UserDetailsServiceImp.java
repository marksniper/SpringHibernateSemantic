package it.unisalento.model.details;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User.UserBuilder builder;
        if (it.unisalento.model.details.User.getInstance().getUsername() != null) {

            builder = User.withUsername(it.unisalento.model.details.User.getInstance().getUsername());
            builder.password(it.unisalento.model.details.User.getInstance().getPassword());
            builder.roles(it.unisalento.model.details.User.getInstance().getPassword());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}