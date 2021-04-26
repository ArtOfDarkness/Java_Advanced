import magazineShop.dao.DAOAbstractCRUD;
import magazineShop.dao.DAOException;
import magazineShop.domain.User;

public interface UserService extends DAOAbstractCRUD<User>{
	
	User readByEmail(String email) throws DAOException;

	boolean updateByEmail(User t) throws DAOException;

}
