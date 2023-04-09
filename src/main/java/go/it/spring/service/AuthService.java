package go.it.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    public User getPrincipal() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return (User) authentication.getPrincipal();
    }

    public boolean hasAuthority(String authority) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(e -> e.equals(authority));
    }

    public void validateAuthority(String authority) {
        if (!hasAuthority(authority)) {
            System.out.println("Thread id " + Thread.currentThread().getId());
            System.out.println(authority + " is missing");

            throw new AccessDeniedException("403 returned. No " + authority);
        }
    }
}
