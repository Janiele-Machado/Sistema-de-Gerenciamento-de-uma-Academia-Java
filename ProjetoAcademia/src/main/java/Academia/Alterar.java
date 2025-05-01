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

    public void alterarPersonal(Personal personal, int id, String nome, String cpf, String email, String dataNasc, 
            String senha, String tipo, String especialidade) {
        
        personal.setNome(nome);
        personal.setCpf(cpf);
        personal.setEmail(email);
        personal.setDataNasc(dataNasc);
        personal.setSenha(senha);
        personal.setTipo(tipo);
        personal.setEspecialidade(especialidade);
        
    }
    
    public void alterarPersonal(Personal personal) throws SQLException {
        
        Connection conexao = new Conexao().getConexao();
        
        String sqlAlterar = "UPDATE  usuarios  SET nome=?, cpf=?, email=?, data_nascimento=?, senha=?, tipo=? WHERE  usuario.id=?";
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

            System.out.println("Alteração realizada com sucesso!");

            comandoUsuario.close();
            comandoPersonal.close();
            
        } catch (SQLException e) {
            System.out.println("Erro na alteracao: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
}
