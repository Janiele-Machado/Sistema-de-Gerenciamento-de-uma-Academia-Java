
package Academia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samuel
 */
public class Deletar {
    
    
    public void deletarAluno(String email) throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql_delA = "DELETE financa, assinatura, usuario, aluno FROM usuario LEFT JOIN financa ON financa.usuario_id = usuario.id LEFT JOIN assinatura ON assinatura.aluno_id = usuario.id LEFT JOIN aluno ON aluno.fk_usu_aluno = usuario.id WHERE usuario.email = ? AND usuario.tipo = 'aluno'; ";
            
        PreparedStatement comando_del = conexao.prepareStatement(sql_delA);
        comando_del.setString(1, email);
        comando_del.executeUpdate();
        
        System.out.println("Aluno excluido com sucesso");
        comando_del.close();
        
                
       
        
    }
    
    
}
