//package com.webapp.sambram;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.webapp.sambram.Dto.LoginDto;
//import com.webapp.sambram.Dto.SignUpDto;
//import com.webapp.sambram.Entities.Role;
//import com.webapp.sambram.Entities.Usr01;
//import com.webapp.sambram.repositories.RoleRepository;
//import com.webapp.sambram.repositories.Usr01Repository;
//
//@Controller
//@RequestMapping(value = "/auth")
//public class AutController {
//
//	public class AuthController {
//
//	    @Autowired
//	    private AuthenticationManager authenticationManager;
//
//	    @Autowired
//	    private Usr01Repository userRepository;
//
//	    @Autowired
//	    private RoleRepository roleRepository;
//
//	    @Autowired
//	    private PasswordEncoder passwordEncoder;
//
//	    @PostMapping("/signin")
//	    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
//	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//	                loginDto.getUserMail(), loginDto.getPassword()));
//
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//	    }
//	    
//	    @GetMapping("/signup")
//	    public String registerUserGet()
//	    {
//	    	return "User_Registration";	    }
//
//	    @PostMapping("/signup")
//	    public String registerUser(@RequestBody SignUpDto signUpDto){
//
//	        
//
//	        // add check for email exists in DB
//	        if(userRepository.existsByEmail(signUpDto.getUserMail())){
//	           return "User_Registration";
//	        }
//
//	        // create user object
//	        Usr01 user = new Usr01();
//	        user.setFirstName(signUpDto.getFirstName());
//	        user.setLastName(signUpDto.getLastName());
//	        user.setMiddleName(signUpDto.getMiddleName());
//	        user.setEmail(signUpDto.getUserMail());
//	        user.setPhone1(signUpDto.getPhone1());
//	        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//
//	        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
//	        user.setRoles(Collections.singleton(roles));
//
//	        userRepository.save(user);
//
//	        return "User_Registration";
//
//	    }
//	}
//}
