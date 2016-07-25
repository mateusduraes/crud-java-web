package dao;

import java.util.List;

public interface DAO<T> {

	public void adiciona(T object);
	
	public void remove (Integer id);
	
	public void altera (T object);
	
	public List<T> getLista();
}
