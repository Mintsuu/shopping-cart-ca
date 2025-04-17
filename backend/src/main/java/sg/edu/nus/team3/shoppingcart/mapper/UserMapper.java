package sg.edu.nus.team3.shoppingcart.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sg.edu.nus.team3.shoppingcart.model.User;
import sg.edu.nus.team3.shoppingcart.model.dto.RegisterRequest;
import sg.edu.nus.team3.shoppingcart.model.dto.UpdateUserRequest;
import sg.edu.nus.team3.shoppingcart.repository.UserRepository;

/**
 * @author Dion Yao
 */

@Component
public class UserMapper {

	@Autowired
	private UserRepository userRepo;
	
	public User toUser(RegisterRequest dto) {
		
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setHandPhoneNo(dto.getHandPhoneNo());
		user.setAddress(dto.getAddress());
		
		return user;
	}
	
	
	public User toUser(int userId, UpdateUserRequest dto) {
		
		User user = userRepo.findById(userId).orElseThrow();
		user.setEmail(dto.getEmail());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setHandPhoneNo(dto.getHandPhoneNo());
		user.setAddress(dto.getAddress());
		
		return user;
	}
	
	
	
}
