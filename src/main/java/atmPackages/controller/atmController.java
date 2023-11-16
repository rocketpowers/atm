package atmPackages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atmPackages.model.Users;
import atmPackages.repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("client")
public class atmController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/save")
	private Users save(@RequestBody @Valid Users users) {
		//private Users save(@RequestBody @Valid Users users) {

		return userRepository.save(users);
		
		//return  userRepository.save ResponseEntity.ok (users);
		
	}

}
