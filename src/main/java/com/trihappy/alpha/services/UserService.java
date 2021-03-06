package com.trihappy.alpha.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trihappy.alpha.domain.User;
import com.trihappy.alpha.dto.UserDTO;
import com.trihappy.alpha.repository.UserRepository;
import com.trihappy.alpha.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User recObj = findById(obj.getId());
		updateData(recObj, obj);
		return repo.save(recObj);
		
		
	}

	private void updateData(User recObj, User obj) {
		recObj.setName(obj.getName());
		recObj.setEmail(obj.getEmail());
		
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
