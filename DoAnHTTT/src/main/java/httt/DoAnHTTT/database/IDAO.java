package httt.DoAnHTTT.database;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<E> {
	public E getByKey(List<String> key);
}
