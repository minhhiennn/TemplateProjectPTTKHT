package httt.DoAnHTTT.database;

import java.util.List;

public interface IDAO<E> {
	public E getByKey(List<String> key);
}
