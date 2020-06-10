package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import domain.BankAccountException;

public class OracleConnection {
	private Connection con;

	public OracleConnection() throws BankAccountException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new BankAccountException("Datenbank nicht gefunden!" + e.getMessage());
		}
	}

	public void open() throws BankAccountException {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL", "DEMO", "oracle");
		} catch (SQLException e) {
			throw new BankAccountException("Datenbank könnte nicht geöffnet werden!" + e.getMessage());
		}
	}

	public void close() throws BankAccountException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new BankAccountException("Datenbank könnte nicht geschloßen werden!" + e.getMessage());
		}
	}

	public Connection getConnection() {
		return con;
	}
}
