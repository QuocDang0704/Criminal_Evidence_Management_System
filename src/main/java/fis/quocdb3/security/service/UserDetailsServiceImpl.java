package fis.quocdb3.security.service;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.repository.DetectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    DetectiveRepository detectiveRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Detective detective = detectiveRepository.findDetectiveByPersonUsername(username);
        return UserDetailsImpl.build(detective);
    }
}
