package pe.edu.unsaac.in.qillqana.server.dao.dbfactory;

import java.sql.Connection;

public interface ConnectionFactory {
	public Connection getConnection();
}
