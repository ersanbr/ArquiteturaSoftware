package business;

import java.util.List;

public interface InterfaceBusiness <T>{
	public void save(T t);
	public List<T> list();
	public T getObj(Integer t);
	public void update(T t);
	public void delete(Integer t);
}
