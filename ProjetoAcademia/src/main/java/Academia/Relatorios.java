package Academia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author samuel
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

    public void Relatorio_aluno() throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relA = " Select * from usuario inner join aluno on  usuario.id = fk_usu_aluno;";
        PreparedStatement comando_al = conexao.prepareStatement(sql_relA);
        ResultSet rs = comando_al.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String cpf = rs.getString("cpf");
            Date dataNascimento = rs.getDate("data_nascimento");
            String matricula = rs.getString("matricula");
            String objetivo = rs.getString("objetivo");
            String status = rs.getString("status");

            System.out.println("ID: " + id
                    + ", Nome: " + nome
                    + ", Email: " + email
                    + ", CPF: " + cpf
                    + ", Nascimento: " + dataNascimento
                    + ", matricula: " + matricula
                    + ", objetivo:" + objetivo
                    + ", status: " + status);

        }
        rs.close();

        conexao.close();
    }

    public void Relatorio_adm() throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relAdm = " Select * from usuario inner join adm on  usuario.id = fk_usu_adm;";
        PreparedStatement comando_adm = conexao.prepareStatement(sql_relAdm);
        ResultSet rs = comando_adm.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String cpf = rs.getString("cpf");
            Date dataNascimento = rs.getDate("data_nascimento");
            double salario = rs.getDouble("salario");
            String telefone = rs.getString("telefone_comercial");
            String descricao = rs.getString("descricao");
            String setor = rs.getString("setor");

            System.out.println("ID: " + id
                    + ", Nome: " + nome
                    + ", Email: " + email
                    + ", CPF: " + cpf
                    + ", Nascimento: " + dataNascimento
                    + ", Salário: " + salario
                    + ", telefone:  " + telefone
                    + ", descricao: " + descricao
                    + ", setor:  " + setor);

        }
        rs.close();

        conexao.close();
    }

    public void Relatorio_salarios() throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relSal = "SELECT nome, tipo, salario FROM usuario INNER JOIN adm a ON usuario.id = fk_usu_adm;";
        PreparedStatement comandorelS = conexao.prepareStatement(sql_relSal);
        ResultSet rs = comandorelS.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("nome");
            String tipo = rs.getString("tipo");
            double salario = rs.getDouble("salario");

            System.out.println("---------------------------------------------------");
            System.out.println("nome: " + nome);
            System.out.println("Funcionario: " + tipo);
            System.out.println("Salario: " + salario);
            System.out.println("-----------------------------------------------------");

        }
        String sql_relSal1 = "SELECT nome, tipo, salario, bonus_por_aluno FROM usuario INNER JOIN personal a ON usuario.id = fk_usu_personal;";
        PreparedStatement comandorelS1 = conexao.prepareStatement(sql_relSal1);
        ResultSet rs1 = comandorelS1.executeQuery();
        while (rs1.next()) {
            String nome = rs1.getString("nome");
            String tipo = rs1.getString("tipo");
            double salario = rs1.getDouble("salario");
            double bonus = rs1.getDouble("bonus_por_aluno");

            System.out.println("---------------------------------------------------");
            System.out.println("nome: " + nome);
            System.out.println("Funcionario: " + tipo);
            System.out.println("Salario: " + salario);
            System.out.println("bonus: " + bonus);
            System.out.println("-----------------------------------------------------");

        }

        rs.close();
        rs1.close();
        conexao.close();
    }

    public void gerarBalanco() throws SQLException {
        Connection conexao = new Conexao().getConexao();

        String sql_financas = "SELECT valor, categoria FROM financa";
        PreparedStatement comandoFinancas = conexao.prepareStatement(sql_financas);
        ResultSet rsFinancas = comandoFinancas.executeQuery();

        double totalEntradas = 0.0;
        double totalSaidas = 0.0;

        while (rsFinancas.next()) {
            double valor = rsFinancas.getDouble("valor");
            String categoria = rsFinancas.getString("categoria");

            if ("mensalidade".equals(categoria)) {
                totalEntradas += valor;

            } else if ("Salario".equals(categoria)) {
                totalSaidas += valor;
            }
        }

        String sql_salariosAdm = "SELECT salario FROM usuario INNER JOIN adm ON usuario.id = adm.fk_usu_adm";
        PreparedStatement comandoAdm = conexao.prepareStatement(sql_salariosAdm);
        ResultSet rsAdm = comandoAdm.executeQuery();

        double totalSalariosAdm = 0.0;
        while (rsAdm.next()) {
            totalSalariosAdm += rsAdm.getDouble("salario");
        }

        String sql_salariosPersonal = "SELECT salario, bonus_por_aluno FROM usuario INNER JOIN personal ON usuario.id = personal.fk_usu_personal";
        PreparedStatement comandoPersonal = conexao.prepareStatement(sql_salariosPersonal);
        ResultSet rsPersonal = comandoPersonal.executeQuery();

        double totalSalariosPersonal = 0.0;
        while (rsPersonal.next()) {
            double salarioPersonal = rsPersonal.getDouble("salario");
            double bonus = rsPersonal.getDouble("bonus_por_aluno");
            totalSalariosPersonal += (salarioPersonal + bonus); // Salário + bônus
        }

        double balancoTotal = totalEntradas - totalSaidas - totalSalariosAdm - totalSalariosPersonal;

        System.out.println("---------------------------------------------------");
        System.out.println("Balanço Financeiro:");
        System.out.println("Total de Entradas: R$ " + totalEntradas);
        System.out.println("Total de Saídas: R$ " + totalSaidas );
        System.out.println("Total de Salários de Administradores: R$ " + totalSalariosAdm);
        System.out.println("Total de Salários de Personal Trainers (incluindo bônus): R$ " + totalSalariosPersonal);
        System.out.println("Total de Pagamentos de Alunos: R$ " + totalEntradas);
        System.out.println("---------------------------------------------------");
        System.out.println("Balanço Final: R$ " + balancoTotal);
        System.out.println("---------------------------------------------------");

        rsFinancas.close();
        rsAdm.close();
        rsPersonal.close();
        conexao.close();
    }

}
