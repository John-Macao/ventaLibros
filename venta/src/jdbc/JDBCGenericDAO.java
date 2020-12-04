package jdbc;

import dao.GenericDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID>  {
	protected ContextJDBC sql = ContextJDBC.getJDBC();
}
