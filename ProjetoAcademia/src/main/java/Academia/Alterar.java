package Academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Alterar {

    public void alterarAluno(Aluno aluno) throws SQLException {

        Connection conexao = new Conexao().getConexao();

        String sqlAlterarUsuario = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";
        String sqlAlterarAluno = "UPDATE aluno SET objetivo=? WHERE fk_usu_aluno=?";

        try {
            //Atualizando tabela usuarios
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlAlterarUsuario);

            comandoUsuario.setString(1, aluno.getNome());
            comandoUsuario.setString(2, aluno.getEmail());
            comandoUsuario.setString(3, aluno.getSenha());
            comandoUsuario.setInt(4, aluno.getId());
            comandoUsuario.executeUpdate();

            //Atualizando tabela aluno
            PreparedStatement comandoAluno = conexao.prepareStatement(sqlAlterarAluno);
            
            comandoAluno.setString(1, aluno.getObjetivo());
            comandoAluno.setInt(2, aluno.getId());
            comandoAluno.executeUpdate();

            System.out.println("Alteracao realizada com sucesso!");

            comandoUsuario.close();
            comandoAluno.close();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar aluno: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void alterarPersonal(Personal personal) throws SQLException {

        Connection conexao = new Conexao().getConexao();

        String sqlAlterar = "UPDATE  usuario SET nome=?, email=?, senha=?, cpf=?, data_nascimento=? WHERE  usuario.id=?";
        String sqlAlterarPersonal = "UPDATE personal SET especialidade=? WHERE fk_usu_personal=?";

        try {

            //Parte de atualizar a tabela usuários
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlAlterar);

            comandoUsuario.setString(1, personal.getNome());
            comandoUsuario.setString(2, personal.getEmail());
            comandoUsuario.setString(3, personal.getSenha());
            comandoUsuario.setString(4, personal.getCpf());
            comandoUsuario.setDate(5, personal.getDataNasc());
            comandoUsuario.setInt(6, personal.getId());

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

        String sqlAlterar = "UPDATE usuario SET nome=?, email=?, senha=? WHERE usuario.id=?";
        String sqlAlterarAdm = "UPDATE adm SET telefone_comercial=?, setor=?, descricao=? WHERE fk_usu_adm=?";

        try {

            // Parte de atualizar tabela usuários
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlAlterar);

            comandoUsuario.setString(1, adm.getNome());
            comandoUsuario.setString(2, adm.getEmail());
            comandoUsuario.setString(3, adm.getSenha());
            comandoUsuario.setInt(4, adm.getId());

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
