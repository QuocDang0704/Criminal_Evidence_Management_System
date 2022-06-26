package fis.quocdb3.security.service;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.repository.DetectiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    DetectiveRepository detectiveRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Detective detective = detectiveRepository.findDetectiveByPersonUsername(username);
            return UserDetailsImpl.build(detective);
        } catch (Exception e) {
            log.error("Error loadUserByUsername");
            throw new IllegalArgumentException("Error loadUserByUsername");
        }
    }
}
