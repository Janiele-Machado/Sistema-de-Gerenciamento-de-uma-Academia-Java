package Academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Alterar {

    public void alterarAluno(Aluno aluno) throws SQLException {

        Connection conexao = new Conexao().getConexao();

        String sqlAlterarUsuario = "UPDATE usuarios SET nome=?, cpf=?, email=?, data_nascimento=?, senha=?, tipo=? WHERE id=?";
        String sqlAlterarAluno = "UPDATE aluno SET status=?, matricula=?, objetivo=? WHERE fk_usu_aluno=?";

        try{
            //Atualizando tabela usuarios
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlAlterarUsuario);

            comandoUsuario.setString(1, aluno.getNome());
            comandoUsuario.setString(2, aluno.getCpf());
            comandoUsuario.setString(3, aluno.getEmail());
            comandoUsuario.setDate(4, aluno.getDataNasc());
            comandoUsuario.setString(5, aluno.getSenha());
            comandoUsuario.setString(6, aluno.getTipo());
            comandoUsuario.setInt(7, aluno.getId());
            comandoUsuario.executeUpdate();

            //Atualizando tabela aluno
            PreparedStatement comandoAluno = conexao.prepareStatement(sqlAlterarAluno);

            comandoAluno.setString(1, aluno.getStatus());
            comandoAluno.setString(2, aluno.getMatricula());
            comandoAluno.setString(3, aluno.getObjetivo());
            comandoAluno.setInt(4, aluno.getId());
            comandoAluno.executeUpdate();

            System.out.println("Alteracao realizada com sucesso!");

            comandoUsuario.close();
            comandoAluno.close();
        } catch (SQLException e){
            System.out.println("Erro ao alterar aluno: " + e.getMessage());
            e.printStackTrace();
        }


    }
    public Aluno buscarAlunoPorId(int id){
        Aluno aluno = new Aluno();

        String sqlUsuario = "SELECT * FROM aluno WHERE id=?";
        String sqlAluno = "SELECT * FROM aluno WHERE fk_usu_aluno=?";

        try(Connection conexao = new Conexao().getConexao()){

            PreparedStatement stmUsuario = conexao.prepareStatement(sqlUsuario);
            stmUsuario.setInt(1, id);
            ResultSet rstUsuario = stmUsuario.executeQuery();

            if(rstUsuario.next()){
                aluno.setId(rstUsuario.getInt("id"));
                aluno.setNome(rstUsuario.getString("nome"));
                aluno.setCpf(rstUsuario.getString("cpf"));
                aluno.setEmail(rstUsuario.getString("email"));
                aluno.setDataNasc(rstUsuario.getNString("data_nascimento"));
                aluno.setSenha(rstUsuario.getString("senha"));
                aluno.setTipo(rstUsuario.getString("tipo"));
            }

            PreparedStatement stmAluno = conexao.prepareStatement(sqlAluno);
            stmAluno.setInt(1, id);
            ResultSet rstAluno = stmAluno.executeQuery();

            if(rstAluno.next()){
                aluno.setStatus(rstAluno.getString("status"));
                aluno.setMatricula(rstAluno.getString("matricula"));
                aluno.setObjetivo(rstAluno.getString("objetivo"));
            }

            stmUsuario.close();
            stmAluno.close();

        } catch (SQLException e) {
            System.out.println("Erro na busca do aluno: " + e.getMessage());
            e.printStackTrace();
        }

        return aluno;
    }



    public static void alterarPersonal(Personal personal) throws SQLException {

        Connection conexao = new Conexao().getConexao();

        String sqlAlterar = "UPDATE  usuarios SET nome=?, cpf=?, email=?, data_nascimento=?, senha=?, tipo=? WHERE  usuario.id=?";
        String sqlAlterarPersonal = "UPDATE personal SET especialidade=? WHERE fk_usu_personal=?";

        try {

            //Parte de atualizar a tabela usuários
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlAlterar);

            comandoUsuario.setString(1, personal.getNome());
            comandoUsuario.setString(2, personal.getCpf());
            comandoUsuario.setString(3, personal.getEmail());
            comandoUsuario.setDate(4, personal.getDataNasc());
            comandoUsuario.setString(5, personal.getSenha());
            comandoUsuario.setString(6, personal.getTipo());
            comandoUsuario.setInt(7, personal.getId());

            comandoUsuario.executeUpdate();

            //Parte de atualizar a tabela personal
            PreparedStatement comandoPersonal = conexao.prepareStatement(sqlAlterarPersonal);

            comandoPersonal.setString(1, personal.getEspecialidade());
            comandoPersonal.setInt(2, personal.getId());

            comandoPersonal.executeUpdate();

            System.out.println("Alteracao realizada com sucesso!");

            comandoUsuario.close();
            comandoPersonal.close();

        } catch (SQLException e) {
            System.out.println("Erro na alteracao: " + e.getMessage());
            e.printStackTrace();
        }

    }


    public void alterarAdm(Adm adm) throws SQLException {
        Connection conexao = new Conexao().getConexao();

        String sqlAlterar = "UPDATE usuarios SET nome=?, cpf=?, email=?, data_nascimento=?, senha=?, tipo=? WHERE usuario.id=?";
        String sqlAlterarAdm = "UPDATE adm SET telefone_comercial=?, setor=?, descricao=? WHERE fk_usu_adm=?";

        try {
            
            // Parte de atualizar tabela usuários
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlAlterar);
            
            comandoUsuario.setString(1, adm.getNome());
            comandoUsuario.setString(2, adm.getCpf());
            comandoUsuario.setString(3, adm.getEmail());
            comandoUsuario.setDate(4, adm.getDataNasc());
            comandoUsuario.setString(5, adm.getSenha());
            comandoUsuario.setString(6, adm.getTipo());
            comandoUsuario.setInt(7, adm.getId());
            
            comandoUsuario.executeUpdate();

            // Parte de atualizar tabela ADM
            PreparedStatement comandoAdm = conexao.prepareStatement(sqlAlterarAdm);
            
            comandoAdm.setString(1, adm.getNumero_comercial());
            comandoAdm.setString(2, adm.getSetor());
            comandoAdm.setString(3, adm.getDesc());
            comandoAdm.setInt(4, adm.getId());
            
            comandoAdm.executeUpdate();

            System.out.println("Alteracao realizada com sucesso!");

            comandoUsuario.close();
            comandoAdm.close();
            
        } catch (SQLException e) {
            System.out.println("Erro na alteracao: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
