package lecture;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class LectureDao {
	private static Map<Integer, Lecture> lectures;

	static{
		lectures = new HashMap<Integer, Lecture>(){
			private static final long serialVersionUID = -1198867491991735227L;
			{
				put(1, new Lecture("lec name 1", "lec url 1", "lec desc 1"));
				put(2, new Lecture("lec name 2", "lec url 2", "lec desc 2"));
				put(3, new Lecture("lec name 3", "lec url 3", "lec desc 3"));
			}
		};	
	}
	public Collection<Lecture> getAllLectures() {
		return lectures.values();
	}
}
