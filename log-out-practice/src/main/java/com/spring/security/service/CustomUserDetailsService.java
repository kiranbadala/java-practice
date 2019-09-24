/**
 * 
 */
package com.spring.security.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.security.repository.UserRepository;

/**
 * @author I342610
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		com.spring.security.model.User user = userRepo.findByEmail(email);
		UserDetails userDet = null;
		if(user.getEmail().contains("admin"))
				userDet = User.withUsername(user.getEmail()).password(user.getPassword()).authorities(getAuthorities("ROLE_ADMIN")).build();
		else
				userDet = User.withUsername(user.getEmail()).password(user.getPassword()).authorities(getAuthorities("ROLE_USER")).build();
		return userDet;
	}

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

}
