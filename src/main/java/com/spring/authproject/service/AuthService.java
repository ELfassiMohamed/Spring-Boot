package com.spring.authproject.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.authproject.dto.ReqRes;
import com.spring.authproject.entity.ourUsers;
import com.spring.authproject.repository.ourUsersRepo;

@Service
public class AuthService {

	@Autowired
	private ourUsersRepo ourUsersRepo;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public ReqRes signUp(ReqRes registrationRequest) {
			ReqRes resp = new ReqRes();
			try {
				ourUsers ourUsers = new ourUsers();
				ourUsers.setEmail(registrationRequest.getEmail());
				ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
				ourUsers.setRole(registrationRequest.getRole());
				ourUsers ourUsersResult = ourUsersRepo.save(ourUsers);
				if (ourUsersResult != null && ourUsersResult.getId()>0) {
	                resp.setOurUsers(ourUsersResult);
	                resp.setMessage("User Saved Successfully");
	                resp.setStatusCode(200);
	            }
			}catch(Exception e) { resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
	}
	
	public ReqRes signIn(ReqRes signinRequest){
        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));
            var user = ourUsersRepo.findByEmail(signinRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
        ourUsers users = ourUsersRepo.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenReqiest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
	
}
