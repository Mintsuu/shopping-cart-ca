package sg.edu.nus.team3.shoppingcart.service;

import java.util.Optional;

import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.model.dto.LoginRequest;
import sg.edu.nus.team3.shoppingcart.model.dto.RegisterRequest;
import sg.edu.nus.team3.shoppingcart.model.dto.UpdateUserRequest;

/**
@author diony
*/

public interface UserService {
	
	public Optional<User> findUserByEmail(String email);
	
	public Optional<User> findUserById(int id);
	
	public boolean loginAttempt(LoginRequest request);
	
	public boolean loginAttempt(String email, String password);
	
	public boolean existsByEmail(String email);
	
	public User registerCustomer(RegisterRequest request);
	
	public User registerStaff(RegisterRequest request);
	
	public User updateUser(int userId, UpdateUserRequest request);
	
	public void deleteUser(int userId);
	
	public void registerUser(User user);
}
