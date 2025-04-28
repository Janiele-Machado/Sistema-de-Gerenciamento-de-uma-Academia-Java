
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
    
     public void deletarPersonal(String email) throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql_delP = "DELETE financa, assinatura, usuario, personal FROM usuario LEFT JOIN financa ON financa.usuario_id = usuario.id LEFT JOIN assinatura ON assinatura.aluno_id = usuario.id LEFT JOIN personal ON personal.fk_usu_personal = usuario.id WHERE usuario.email = ? AND usuario.tipo = 'personal';";
        PreparedStatement comando_del1 = conexao.prepareStatement(sql_delP);
        comando_del1.setString(1, email);
        comando_del1.executeUpdate();
        
        System.out.println("Personal excluido com sucesso");
        comando_del1.close();
                        
       
        
    }
    
     public void deletarAdm(String email) throws SQLException{
          Connection conexao = new Conexao().getConexao();
          conexao.setAutoCommit(false); // Transação manual
     try{  
         
         String sql_delAdm = "DELETE FROM adm WHERE fk_usu_adm = (SELECT id FROM usuario WHERE email = ? AND tipo = 'adm'";
         PreparedStatement comando_dellA = conexao.prepareStatement(sql_delAdm);
         comando_dellA.setString(1, email);
         comando_dellA.executeUpdate();
         
         String sql_delU = " DELETE FROM usuario WHERE email = 'manu@gmail.com' AND tipo = 'adm';";
         PreparedStatement comando_dellu = conexao.prepareStatement(sql_delU);
         comando_dellu.setString(1, email);
         comando_dellu.executeUpdate();
         
     } catch(SQLException e){
         conexao.rollback(); // Reverte em caso de erro
         e.printStackTrace();
         
         
     }finally{
         conexao.setAutoCommit(true);
        conexao.close();
     }
                 
         
         
     }
    
}
