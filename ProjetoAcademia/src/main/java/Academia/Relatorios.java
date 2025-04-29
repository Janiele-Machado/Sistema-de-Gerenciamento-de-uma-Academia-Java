package Academia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author samue
 */
public class Relatorios {

    public void Relatorio_personal() throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relP = " Select * from usuario inner join personal on  usuario.id = personal.fk_usu_personal;";
        PreparedStatement comando_rel = conexao.prepareStatement(sql_relP);
        ResultSet rs = comando_rel.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String cpf = rs.getString("cpf");
            Date dataNascimento = rs.getDate("data_nascimento");
            double salario = rs.getDouble("salario");
            String especialidade = rs.getString("especialidade");

            System.out.println("ID: " + id
                    + ", Nome: " + nome
                    + ", Email: " + email
                    + ", CPF: " + cpf
                    + ", Nascimento: " + dataNascimento
                    + ", Salário: " + salario
                    + ", Especialidade: " + especialidade);

        }
        rs.close();

        conexao.close();

    }

}
