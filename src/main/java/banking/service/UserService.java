package banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import banking.entity.CustomUserDetails;
import banking.entity.Users;
import banking.repository.UsersRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// Kiểm tra xem user có tồn tại trong database không?
        Users user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new CustomUserDetails(user);
	}

}
