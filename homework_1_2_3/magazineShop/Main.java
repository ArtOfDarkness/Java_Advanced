import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import magazineShop.dao.DAOException;
import magazineShop.dao.MagazineDAO;
import magazineShop.dao.SubscribeDAO;
import magazineShop.dao.UserDAO;
import magazineShop.domain.User;

public class Main {

	public static void main(String[] args) throws DAOException {
		List<User> userList = new ArrayList<>();
		userList.add(new User("Іван", "Шевченко", "sheva@gmail.com", "123456", "USER"));
		userList.add(new User("Тарас", "Тарасов", "tera@gmail.com", "123456", "USER"));

		UserDAO userDAO = new UserDAO();
		userList.forEach(user -> {
			try {
				System.out.println(userDAO.insert(user.getFirstName(), user.getLastName(), user.getEmail(),
						user.getPassword(), user.getAccessLevel()));
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});

		System.out.println(userDAO.readByID(2));
		System.out.println(userDAO.readByEmail("sheva@gmail.com"));
		userDAO.updateByID(1, "Стас", "Стасов", "sheva@gmail.com", "123456", "АDMIN");
		userDAO.updateByEmail("Тарік", "Тарасов", "tera@gmail.com", "123456", "USER");
		userDAO.delete(1);
		userDAO.readAll().forEach(System.out::println);

		MagazineDAO magazineDAO = new MagazineDAO();
		System.out.println(
				magazineDAO.insert("Playboy", "Саша Грей вернулась в секс індустрію!",
						LocalDate.parse("2021-10-03"), 6005));
		magazineDAO.readAll().forEach(System.out::println);

		SubscribeDAO subscribeDAO = new SubscribeDAO();
		System.out.println(subscribeDAO.insert(2, 1, true, LocalDate.parse("2021-10-13"), 12));
		subscribeDAO.readAll().forEach(System.out::println);
	}
}
