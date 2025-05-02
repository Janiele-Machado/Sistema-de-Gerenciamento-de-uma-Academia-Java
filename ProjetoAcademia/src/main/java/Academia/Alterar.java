package Academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Alterar {

    public void alterarAluno(Aluno aluno, int id, String nome, String cpf, String email, String dataNasc,
            String senha, String tipo, String status, String matricula, String Objetivo) {

        aluno.setMatricula(matricula);
        aluno.setObjetivo(Objetivo);
        aluno.setStatus(status);

        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setDataNasc(dataNasc);
        aluno.setSenha(senha);
        aluno.setTipo(tipo);
    }
    
    public void alterarPersonal(Personal personal) throws SQLException {

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
