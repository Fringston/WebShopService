package com.Molndal.WebShopService.Service;

import com.Molndal.WebShopService.Models.History;
import com.Molndal.WebShopService.Models.User;
import com.Molndal.WebShopService.Repository.HistoryRepository;
import com.Molndal.WebShopService.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Service-klass för att hantera användare.
 * Innehåller metoder för att hämta användare från databasen.
 *
 * @author Jafar
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Hämtar användare från databasen om den finns
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
   /**
    * Denna metod hämtar inloggad användare från databasen
    *
    * @return inloggad användare
    */
    public User getCurrentUser() { //Hämtar inloggad användare
        //skapar en variabel som hämtar inloggad användare
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //hämtar användaren från databasen
        Optional<User> userOptional = userRepository.findByUsername(username);
        //returnerar användaren
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
    /**
     * Denna metod hämtar alla användare från databasen
     *
     * @return en lista med alla användare
     **/
    public List<User> getAllUsers(){ //Hämtar alla användare
        return userRepository.findAll();

    }
}
