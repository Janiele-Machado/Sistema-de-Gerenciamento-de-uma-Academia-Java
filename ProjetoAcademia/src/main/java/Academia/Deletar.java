
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
        
        String sql_delFinanca = "DELETE FROM financa WHERE usuario_id = (SELECT id FROM usuario WHERE email = ? AND tipo = 'aluno')";
        PreparedStatement comando_delFinanca = conexao.prepareStatement(sql_delFinanca);
        comando_delFinanca.setString(1, email);
        comando_delFinanca.executeUpdate();
        
        
        String sql_delAssinatura = "DELETE FROM assinatura WHERE aluno_id = (SELECT id FROM usuario WHERE email = ? AND tipo = 'aluno')";
        PreparedStatement comando_delAssinatura = conexao.prepareStatement(sql_delAssinatura);
        comando_delAssinatura.setString(1, email);
        comando_delAssinatura.executeUpdate();

        
        String sql_delAluno = "DELETE FROM aluno WHERE fk_usu_aluno = (SELECT id FROM usuario WHERE email = ? AND tipo = 'aluno')";
        PreparedStatement comando_delAluno = conexao.prepareStatement(sql_delAluno);
        comando_delAluno.setString(1, email);
        comando_delAluno.executeUpdate();

        
        String sql_delUsuario = "DELETE FROM usuario WHERE email = ? AND tipo = 'aluno'";
        PreparedStatement comando_delUsuario = conexao.prepareStatement(sql_delUsuario);
        comando_delUsuario.setString(1, email);
        comando_delUsuario.executeUpdate();
        
        
        System.out.println("Aluno excluído com sucesso");
                        
       
        
    }
    
     public void deletarPersonal(String email) throws SQLException{ //Como regra de negocio não se pode deletar um personal que tenha alunos
        Connection conexao = new Conexao().getConexao();
        String sql_delF = "DELETE FROM financa WHERE usuario_id = (SELECT id FROM usuario WHERE email = ? AND tipo = 'personal')";
        PreparedStatement comando_delF = conexao.prepareStatement(sql_delF);
        comando_delF.setString(1, email);
        comando_delF.executeUpdate();

       
        String sql_delA = "DELETE FROM assinatura WHERE aluno_id = (SELECT id FROM usuario WHERE email = ? AND tipo = 'personal')";
        PreparedStatement comando_delA = conexao.prepareStatement(sql_delA);
        comando_delA.setString(1, email);
        comando_delA.executeUpdate();

        
        String sql_delP = "DELETE FROM personal WHERE fk_usu_personal = (SELECT id FROM usuario WHERE email = ? AND tipo = 'personal')";
        PreparedStatement comando_delP = conexao.prepareStatement(sql_delP);
        comando_delP.setString(1, email);
        comando_delP.executeUpdate();

        
        String sql_delU = "DELETE FROM usuario WHERE email = ? AND tipo = 'personal'";
        PreparedStatement comando_delU = conexao.prepareStatement(sql_delU);
        comando_delU.setString(1, email);
        comando_delU.executeUpdate();

        
        System.out.println("Personal excluído com sucesso");
        
                        
       
        
    }
    
     public void deletarAdm(String email) throws SQLException{
          Connection conexao = new Conexao().getConexao();
          conexao.setAutoCommit(false); // Transação manual
     try{  
         
         String sql_delAdm = "DELETE FROM adm WHERE fk_usu_adm = (SELECT id FROM usuario WHERE email = ? AND tipo = 'adm')";
         PreparedStatement comando_dellA = conexao.prepareStatement(sql_delAdm);
         comando_dellA.setString(1, email);
         comando_dellA.executeUpdate();
         
         String sql_delF = "DELETE FROM financa WHERE usuario_id = (SELECT id FROM usuario WHERE email = ? AND tipo = 'adm')";
         PreparedStatement comando_dellF = conexao.prepareStatement(sql_delF);
         comando_dellF.setString(1, email);
         comando_dellF.executeUpdate();
         
         
         String sql_delU = " DELETE FROM usuario WHERE email = ? AND tipo = 'adm';";
         PreparedStatement comando_dellu = conexao.prepareStatement(sql_delU);
         comando_dellu.setString(1, email);
         comando_dellu.executeUpdate();
         System.out.println("adm excluído com sucesso");
         
         
     } catch(SQLException e){
         conexao.rollback(); // Reverte em caso de erro
         e.printStackTrace();
          System.out.println("falha");
         
         
     }finally{
         conexao.setAutoCommit(true);
        conexao.close();
     }
                 
         
         
     }
    
}
