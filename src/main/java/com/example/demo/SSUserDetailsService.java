package com.example.demo;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;

@Transactional
public class SSUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SSUserDetailsService.class);
	
	private UserRepository userRepository;
	
	public SSUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try 
		{
			User user = userRepository.findByUsername(username);
			if (user == null) {
				LOGGER.debug("user not found with the provided username");
				return null;
			}
			LOGGER.debug(" user from username " + user.toString());
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
		} 
		catch (Exception e) 
		{
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
			authorities.add(grantedAuthority);
		}
		
		LOGGER.debug("user authorities are " +)authorities.toString());
		return authorities;
	}

}
