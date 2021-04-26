import java.util.Map;

import magazineShop.dao.DAOAbstractCRUD;
import magazineShop.dao.DAOException;
import magazineShop.domain.Magazine;

public interface MagazineService extends DAOAbstractCRUD<Magazine> {
	
	public Map<Integer, Magazine> readAllMap() throws DAOException;

}
