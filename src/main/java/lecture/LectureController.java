package lecture;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LectureController {
	
	@Autowired
	private LectureService lectureService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Lecture> getAllUsers(){
		return lectureService.getAllLectures();
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public User getUserById(@PathVariable("id") int id){
//		return userService.getUserById(id);
//	}
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public void deleteUserById(@PathVariable("id") int id){
//		userService.deletUserById(id);
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void updateUser(@RequestBody User user){
//		userService.updateUser(user);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void insertUser(@RequestBody User user){
//		userService.insertUser(user);
//	}
}
