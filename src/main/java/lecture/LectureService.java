package lecture;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
	
	@Autowired
	private LectureDao lectureDao;
	
	public Collection<Lecture> getAllLectures() {
		return lectureDao.getAllLectures();
	}
}
