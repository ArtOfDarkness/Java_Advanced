import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;

@Configuration
public class StudentDaoConfig {

	@Bean
	StudentDao studentDao() {
		return new StudentDaoImpl();
	}
}
