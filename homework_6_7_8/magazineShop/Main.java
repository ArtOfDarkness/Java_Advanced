import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import magazineShop.dao.DAOException;
import magazineShop.domain.Magazine;
import magazineShop.domain.Subscribe;
import magazineShop.domain.User;
import magazineShop.service.MagazineService;
import magazineShop.service.SubscribeService;
import magazineShop.service.UserService;
import magazineShop.service.impl.MagazineServiceImpl;
import magazineShop.service.impl.SubscribeServiceImpl;
import magazineShop.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) throws DAOException {
		Logger log = Logger.getLogger(Main.class);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		log.trace("Starting application...");
		
		List<User> userList = new ArrayList<>();
		userList.add(new User("Іван", "Шевченко", "sheva@gmail.com", "123456", "USER"));
		userList.add(new User("Тарас", "Тарасов", "vas_ivanov@gmail.com", "123456", "USER"));

		UserService userService = UserServiceImpl.getUserService();
		userList.forEach(user -> {
			try {
				System.out.println(userService.insert(user));
			} catch (DAOException e) {
				log.error("Error occured!", e);
				e.printStackTrace();
			}
		});
		
		System.out.println(userService.readByID(2));
		System.out.println(userService.readByEmail("petrenko@gmail.com"));
		userService.updateByID(new User(1, "Стас", "Стасов", "sheva@gmail.com", "123456", "АDMIN"));
		userService.updateByEmail(new User("Тарік", "Тарасов", "tera@gmail.com", "123456", "USER"));
		userService.delete(1);
		userService.readAll().forEach(System.out::println);

		MagazineService magazineService = MagazineServiceImpl.getMagazineService();
		System.out.println(
				magazineService.insert(new Magazine("Playboy", "Саша Грей вернулась в секс індустрію!",
						LocalDate.parse("2021-10-03"), 6005)));
		magazineService.readAll().forEach(System.out::println);

		SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeService();
		System.out.println(subscribeService.insert(new Subscribe(2, 1, true, LocalDate.parse("2021-10-13"), 12)));
		subscribeService.readAll().forEach(System.out::println);
	}
}
