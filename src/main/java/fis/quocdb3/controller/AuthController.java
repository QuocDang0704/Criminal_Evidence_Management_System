package fis.quocdb3.controller;

import fis.quocdb3.domain.Detective;
import fis.quocdb3.domain.Person;
import fis.quocdb3.domain.enums.EmploymentStatus;
import fis.quocdb3.payload.request.LoginRequest;
import fis.quocdb3.payload.request.SignupRequest;
import fis.quocdb3.payload.response.JwtResponse;
import fis.quocdb3.repository.DetectiveRepository;
import fis.quocdb3.repository.PersonRepository;
import fis.quocdb3.security.jwt.JwtUtils;
import fis.quocdb3.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DetectiveRepository detectiveRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (personRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new IllegalArgumentException(String.format("Error: Username is already taken!", signUpRequest.getUsername()));
        }
        Person person = new Person();
        person.setCreateAt(LocalDateTime.now());
        person.setModifiedAt(LocalDateTime.now());
        person.setVersion(1);
        person.setFirstName(signUpRequest.getFirstName());
        person.setHiringDate(LocalDateTime.now());
        person.setLastName(signUpRequest.getLastName());
        person.setPassword(encoder.encode(signUpRequest.getPassword()));
        person.setUsername(signUpRequest.getUsername());
        personRepository.save(person);

        Detective detective = new Detective();
        detective.setCreateAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setVersion(1);
        detective.setArmed(true);
        detective.setBadgeNumber("0432132435");
        detective.setRank(signUpRequest.getRank());
        detective.setStatus(EmploymentStatus.ACTIVE);
        Person person1 =  personRepository.findAll()
                .stream().max(Comparator.comparing(Person::getId))
                .orElseThrow(() -> {throw new IllegalArgumentException(String.format("Error: Not fount id Person new"));});
        detectiveRepository.save(detective);

        return ResponseEntity.ok(String.format("User %s registered successfully!", signUpRequest.getUsername()));
    }

}
