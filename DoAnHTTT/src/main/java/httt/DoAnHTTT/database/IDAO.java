package httt.DoAnHTTT.database;

import java.util.List;

public interface IDAO<E> {
	public E getByKey(String key);
	public E getByKeyS(List<String> key);
	public boolean insert(E key);
	public boolean update(E key);
	public boolean delete(E key);
}
