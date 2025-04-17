package sg.edu.nus.team3.shoppingcart.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.team3.shoppingcart.exception.InvalidLoginException;
import sg.edu.nus.team3.shoppingcart.mapper.UserMapper;
import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.model.dto.LoginRequest;
import sg.edu.nus.team3.shoppingcart.model.dto.RegisterRequest;
import sg.edu.nus.team3.shoppingcart.model.dto.UpdateUserRequest;
import sg.edu.nus.team3.shoppingcart.repository.UserRepository;
import sg.edu.nus.team3.shoppingcart.service.UserService;

/**
@author Dion Yao
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserMapper userMap;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);

	}

	@Override
	public boolean loginAttempt(LoginRequest request) {

		String email = request.getEmail();
		String passwordInput = request.getPassword();

		// Returns true of login attempt is successful when the user can be found by email and matches() returns true, and false if not
		Optional<User> userOpt = userRepo.findUserByEmail(email);

		if (userOpt.isEmpty() || !passwordEncoder.matches(passwordInput, userOpt.get().getPassword())) {
			return false;
		}

		return true;
	}


	@Override
	public boolean loginAttempt(String email, String passwordInput) {

		// Returns true of login attempt is successful when the user can be found by email and matches() returns true, and false if not
		Optional<User> userOpt = userRepo.findUserByEmail(email);

		if (userOpt.isEmpty() || !passwordEncoder.matches(passwordInput, userOpt.get().getPassword())) {
			return false;
		}

		return true;

	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findUserById(id).orElseThrow();
	}


	@Override
	public boolean existsByEmail(String email) {
		Optional<User> userOpt = userRepo.findUserByEmail(email);

		if (userOpt.isEmpty()) {
			return false;
		}

		return true;
	}

	@Override
	public User registerCustomer(RegisterRequest request) {

		User custToRegister = userMap.toUser(request);
		// Hashing the user input password with PasswordEncoder
		String hashedPassword = passwordEncoder.encode(custToRegister.getPassword());

		// Encrypted version of password replaces original plaintext password
		custToRegister.setPassword(hashedPassword);

		// Role set to customer
		custToRegister.setRole("customer");

		return userRepo.save(custToRegister);
	}

	@Override
	public User registerStaff(RegisterRequest request) {

		// UserMapper turns the Dto into a User object
		User staffToRegister = userMap.toUser(request);
		
		// Hashing the user input password with PasswordEncoder
		String hashedPassword = passwordEncoder.encode(staffToRegister.getPassword());

		// Encrypted version of password is stored instead of original password in plaintext
		staffToRegister.setPassword(hashedPassword);
		
		// Role set to staff. Will be able to access admin dashboard, and perform staff RUD functions on any account.
		staffToRegister.setRole("staff");

		
		return userRepo.save(staffToRegister);
	}

	@Override
	public void deleteUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow();

		userRepo.delete(user);

	}

	@Override
	public User updateUser(int userId, UpdateUserRequest request) {
		
		// UserMapper turns the Dto into a User first, BUT not password
		User user = userMap.toUser(userId, request);

		if (request.getPassword() != null && !request.getPassword().isEmpty()) {
			user.setPassword(passwordEncoder.encode(request.getPassword()));
		}

		return userRepo.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	// Only for testing
	@Override
	public User registerUser(User user) {
		return userRepo.save(user);
	}
	
	
	/* Hiroyo's temp
	//temporary method?
	@Override
	public User findUserById(int userId) {
		return userRepo.findById(userId).orElse(null);
	}
	*/

}
