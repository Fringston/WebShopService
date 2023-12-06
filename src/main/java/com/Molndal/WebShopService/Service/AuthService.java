package com.Molndal.WebShopService.Service;

import com.Molndal.WebShopService.Models.LoginResponse;
import com.Molndal.WebShopService.Models.Role;
import com.Molndal.WebShopService.Models.User;
import com.Molndal.WebShopService.Repository.RoleRepository;
import com.Molndal.WebShopService.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Clara Brorson
 * This class is a service for the authentication of the user and admin.
 * It has two methods, one for registering a user and one for logging in a user/admin.
 * It also has a method for encrypting the password.
 */

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public ResponseEntity<User> register(String username, String password) {
        String encryptedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return ResponseEntity.ok(userRepository.save( new User(0L, username, encryptedPassword, authorities) ));
    }

    public ResponseEntity<LoginResponse> login (String username, String password) {
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return ResponseEntity.ok(new LoginResponse(userRepository.findByUsername(username).get(), token));

        } catch(AuthenticationException e){
            return ResponseEntity.ok(new LoginResponse(null, ""));
        }
    }

}
