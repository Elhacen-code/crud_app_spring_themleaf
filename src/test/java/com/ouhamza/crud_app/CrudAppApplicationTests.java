package com.ouhamza.crud_app;

import java.util.Optional;

import com.ouhamza.crud_app.dao.RoleRepo;
import com.ouhamza.crud_app.dao.UserReop;
import com.ouhamza.crud_app.model.Role;
import com.ouhamza.crud_app.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudAppApplicationTests {

	@Autowired
	private UserReop userReop;
	@Autowired
	private RoleRepo roleReop;

	@Test
	void contextLoads() {

		User user = userReop.getById(3);

		Role roleEditor = roleReop.getById(3);
		user.addRole(roleEditor);
	
		userReop.save(user);
		
	}

	// Role role = roleReop.getById(3) ;
	// Role role1 = roleReop.getById(4) ;



	// User user = new User("sdmh@gmail.com", "32204361");

	// //User user = userReop.getById(8);

	// user.addRole(role);
	// user.addRole(role1);
	
	// userReop.save(user);


	
	// Role role = roleReop.getById(1) ;

	// //User user = new User("elhassen@gmail.com", "32204361");

	// User user = userReop.getById(8);

	// user.addRole(role);
	
	// userReop.save(user);
	
}
