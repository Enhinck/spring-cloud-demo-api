package com.enhinck.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.enhinck.demo.model.Authority;
import com.enhinck.demo.model.AuthorityName;
import com.enhinck.demo.model.User;

@Service
public class UserService {

	public User findByUsername(String username) {
		User user = new User();
		user.setUsername("admin");
		user.setId(1L);
		user.setPassword("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
		user.setEnabled(true);
		List<Authority> authorities = new ArrayList<>();

		Authority authoritie = new Authority();
		authoritie.setName(AuthorityName.ROLE_ADMIN);
		authoritie.setId(1L);
		authorities.add(authoritie);
		user.setAuthorities(authorities);
		return user;
	}

}
