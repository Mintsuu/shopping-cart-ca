package sg.edu.nus.team3.shoppingcart.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import sg.edu.nus.team3.shoppingcart.model.User;

/**
@author Dion Yao
*/



public interface UserRepository extends JpaRepository<User, Integer> {

	// Method to retrieve User from database where the input email matches a database entry
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public Optional<User> findUserByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM User u WHERE u.id = :id")
	public Optional<User> findUserById(@Param("id") int id);
	
	
}
