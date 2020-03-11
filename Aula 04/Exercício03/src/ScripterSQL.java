import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScripterSQL {
	
	public static int rodarScript (String script) throws SQLException {
		Statement stmt = null;
		String connectionUrl = "jdbc:sqlite:SQL/BairroDB.db";
		
		Connection conn = DriverManager.getConnection(connectionUrl);
		int resultado;
		stmt = conn.createStatement();
		if (script.toUpperCase().contains("SELECT")) {
			ResultSet rs = stmt.executeQuery(script);
			int nrows = 0;
			while (rs.next())
				nrows++;
			resultado = nrows;
		} else {
			stmt.execute(script);
			resultado = stmt.getUpdateCount();
			
		}
		stmt.close();
		return resultado;
	}

}
