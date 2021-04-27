import java.util.List;

import domain.Student;

public interface StudentDao {

	Student create(Student student);
	
	Student readById(int id);
	
	List<Student> readAll();
	
	Student update(Student student);
	
	void delete(int id);
	
}
