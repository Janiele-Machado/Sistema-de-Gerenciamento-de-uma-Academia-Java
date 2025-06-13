
package Academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Janiele
 */
public class Conexao {
    
    public static final String SERVIDOR = "jdbc:mysql://localhost:3306/academia_db";
    public static final String USUARIO = "root";
    public static final String SENHA = "samuel1234";
    
    
    public Connection getConexao()throws SQLException {
        try {
            Connection conexao = DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
            if (conexao != null) {
                System.out.println("<3");
            }
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            throw e;  // Relança a exceção para que ela possa ser tratada externamente
        }
        
    }
    
}
