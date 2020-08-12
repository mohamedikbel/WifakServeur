package wifak.bank.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wifak.bank.spring.dao.UserRepository;
import wifak.bank.spring.entities.User;

@Service

public class CustomDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(),
				true, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities()

		);
		System.out.println(userDetails);
		return userDetails;

	}

	private Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		grantedAuthorities.add(grantedAuthority);

		return grantedAuthorities;
	}

}
