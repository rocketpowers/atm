package atmPackages.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import atmPackages.model.Users;
import atmPackages.repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
public class atmController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/user/save")
	// private ResponseEntity<String> save(@RequestBody @Valid Users users) {
	private Users save(@RequestBody @Valid Users users) {

		return userRepository.save(users);
		// return userRepository.save ResponseEntity.ok (users);
		// return ResponseEntity.ok("valid client =>" + users.toString());
	}

	@GetMapping("/user/list")
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public Users getUserbyid(@PathVariable UUID id) {
		return userRepository.findById(id).get();

	}

	@PutMapping("/user/update")
	public Users update(@RequestBody Users editUser) {
		return userRepository.save(editUser);
	}
	
	
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable UUID id) {
		userRepository.deleteById(id);
		
	}
	
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;

	}

}
