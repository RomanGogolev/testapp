package org.student.testapp.dao;

/**
 * Created by roman on 07.11.16.
 */

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.sql.SQLException;

public class CustomUserDetails implements UserDetailsService{

    public UserManager create() throws SQLException, ClassNotFoundException {
        return new UserManager();
    }

    //Create user from db by username and sent to springSec for check
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try {
            return create().getUser(username);
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

}
