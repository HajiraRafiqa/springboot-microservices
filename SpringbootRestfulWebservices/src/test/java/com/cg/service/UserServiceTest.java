package com.cg.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import com.cg.dto.UserDto;
import com.cg.entity.User;
import com.cg.exception.EmailAlreadyExistsException;
import com.cg.mapper.AutoUserMapper;
import com.cg.repository.UserRepository;
import com.cg.service.impl.UserServiceImpl;


public class UserServiceTest {
	
	
    private UserRepository userRepository;
    private ModelMapper modelMapper;
	private UserService userService;


	@BeforeEach
	public void setUp() throws Exception {
		
		userRepository = mock(UserRepository.class);
		
		userService = new UserServiceImpl(userRepository, modelMapper);
		
	}

	@Test
	public void createUser() {
		User user = new User();
		user.setId((long) 1);
		user.setFirstName("A");
		user.setLastName("B");
		user.setEmail("AB@gmail.com");
		
		UserDto	userdto = AutoUserMapper.MAPPER.mapToUserDto(user);		
		
		assertThrows(EmailAlreadyExistsException.class, () -> userService.createUser(userdto));
	}

}
