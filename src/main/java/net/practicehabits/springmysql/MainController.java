package net.practicehabits.springmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // This class is a Controller
@RequestMapping(path="/demo")
public class MainController {
	@Autowired  // This means to get the bean called userRepository
			// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name,
			@RequestParam String email) {
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
	
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUser() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
