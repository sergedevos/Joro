package nl.joro.backend.db;

import java.sql.Connection;

import org.h2.jdbcx.JdbcConnectionPool;

public class DBConnection {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:./test", "sa", "sa");
			for (int i = 0; i < args.length; i++) {
				Connection conn = cp.getConnection();
				conn.createStatement().execute(args[i]);
				conn.close();
			}
			cp.dispose();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
