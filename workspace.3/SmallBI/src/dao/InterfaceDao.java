package dao;

import java.util.List;


public interface InterfaceDao <T>{	
	public void createObj(T t);
	public List<T> listObj();
	public void updateObj(T t);
	public void removeObj(T t);
	public T getObjById(Integer t);
}
