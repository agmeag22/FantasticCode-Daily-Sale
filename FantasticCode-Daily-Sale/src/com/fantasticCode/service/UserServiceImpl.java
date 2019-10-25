package com.fantasticCode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fantasticCode.entities.User;
import com.fantasticCode.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository ;
	
	

	public List<User> findAll(int page) {
		// TODO Auto-generated method stub
		return userRepository.findAll(PageRequest.of(page, 10, new Sort(Direction.ASC, "iduser"))).getContent();
	}
	
	public User findOne(Integer user) {
		// TODO Auto-generated method stub
		return userRepository.findById(user).get();
	}
	/*
	public boolean findOneUser(String username, String password) throws DataAccessException {
		boolean result=false;
		if(userRepository.findOneUser(username, password)==1) result=true;
		return result;
	}
		
	public long countAll() {
		// TODO Auto-generated method stub
		return userRepository.count();
	}

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional
	@Override
	public void delete(User user) {
		userRepository.delete(user);
		
	}

	@Transactional
    public User savedUser(User user) {
        return userRepository.save(user);
    }
*/
	
}
