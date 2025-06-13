package Academia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

  public Object[][] gerarBalancoArray() throws SQLException {
    Connection conexao = new Conexao().getConexao();

    double totalEntradas = 0.0;

    // Somar apenas entradas (Mensalidades)
    String sql_financas = "SELECT valor, categoria FROM financa";
    PreparedStatement comandoFinancas = conexao.prepareStatement(sql_financas);
    ResultSet rsFinancas = comandoFinancas.executeQuery();

    while (rsFinancas.next()) {
        double valor = rsFinancas.getDouble("valor");
        String categoria = rsFinancas.getString("categoria");

        if ("Mensalidade".equalsIgnoreCase(categoria)) {
            totalEntradas += valor;
        }
    }

    // Salários de administradores
    String sql_salariosAdm = "SELECT salario FROM usuario INNER JOIN adm ON usuario.id = adm.fk_usu_adm";
    PreparedStatement comandoAdm = conexao.prepareStatement(sql_salariosAdm);
    ResultSet rsAdm = comandoAdm.executeQuery();

    double totalSalariosAdm = 0.0;
    while (rsAdm.next()) {
        totalSalariosAdm += rsAdm.getDouble("salario");
    }

    // Salários de personal + bônus
    String sql_salariosPersonal = "SELECT salario, bonus_por_aluno FROM usuario INNER JOIN personal ON usuario.id = personal.fk_usu_personal";
    PreparedStatement comandoPersonal = conexao.prepareStatement(sql_salariosPersonal);
    ResultSet rsPersonal = comandoPersonal.executeQuery();

    double totalSalariosPersonal = 0.0;
    while (rsPersonal.next()) {
        double salario = rsPersonal.getDouble("salario");
        double bonus = rsPersonal.getDouble("bonus_por_aluno");
        totalSalariosPersonal += (salario + bonus);
    }

    double totalSaidas = totalSalariosAdm + totalSalariosPersonal;
    double balancoTotal = totalEntradas - totalSaidas;

    // Monta os dados como um array de objetos (linhas, colunas)
    Object[][] dados = {
        {"Total de Entradas", totalEntradas},
        {"Total de Saídas", totalSaidas},
        {"Salários de Administradores", totalSalariosAdm},
        {"Salários de Personais (com bônus)", totalSalariosPersonal},
        {"Balanço Final", balancoTotal}
    };

    rsFinancas.close();
    rsAdm.close();
    rsPersonal.close();
    conexao.close();

    return dados;
}
        public Aluno dados_aluno(int idUsuario) throws SQLException {
    Connection conexao = new Conexao().getConexao();
    
    String sql = "SELECT * FROM usuario INNER JOIN aluno ON usuario.id = aluno.fk_usu_aluno WHERE usuario.id = ?;";
    PreparedStatement comando = conexao.prepareStatement(sql);
    comando.setInt(1, idUsuario);

    ResultSet rs = comando.executeQuery();

     

    if (rs.next()) {
        Aluno alu = new Aluno();
        
        int id = rs.getInt("id");
        alu.setNome(rs.getString("nome"));
        alu.setEmail(rs.getString("email"));
        alu.setCpf(rs.getString("cpf"));
        alu.setDataNasc(rs.getDate("data_nascimento"));
        alu.setMatricula(rs.getString("matricula"));
        alu.setObjetivo(rs.getString("objetivo"));
        alu.setStatus(rs.getString("status"));
        return alu;

        
    }

    rs.close();
    comando.close();
    conexao.close();

    return null;
}
        public Personal dados_personal(int idUsuario) throws SQLException {
    Connection conexao = new Conexao().getConexao();

    String sql = "SELECT * FROM usuario INNER JOIN personal ON usuario.id = personal.fk_usu_personal WHERE usuario.id = ?;";
    PreparedStatement comando = conexao.prepareStatement(sql);
    comando.setInt(1, idUsuario);

    ResultSet rs = comando.executeQuery();

    if (rs.next()) {
        Personal personal = new Personal();

        personal.setId(rs.getInt("id"));
        personal.setNome(rs.getString("nome"));
        personal.setEmail(rs.getString("email"));
        personal.setCpf(rs.getString("cpf"));
        personal.setDataNasc(rs.getDate("data_nascimento"));
        personal.setSalario(rs.getDouble("salario"));
        personal.setBonus_por_aluno(rs.getDouble("bonus_por_aluno"));
        personal.setEspecialidade(rs.getString("especialidade"));
        personal.setQtd_aluno(rs.getInt("quant_alunos"));
       
        return personal;
    }

    rs.close();
    comando.close();
    conexao.close();

    return null;
}
        public Adm dados_adm(int idUsuario) throws SQLException {
    Connection conexao = new Conexao().getConexao();

    String sql = "SELECT * FROM usuario INNER JOIN adm ON usuario.id = adm.fk_usu_adm WHERE usuario.id = ?;";
    PreparedStatement comando = conexao.prepareStatement(sql);
    comando.setInt(1, idUsuario);

    ResultSet rs = comando.executeQuery();

    if (rs.next()) {
        Adm adm = new Adm();

        adm.setId(rs.getInt("id"));
        adm.setNome(rs.getString("nome"));
        adm.setEmail(rs.getString("email"));
        adm.setCpf(rs.getString("cpf"));
        adm.setDataNasc(rs.getDate("data_nascimento"));

        adm.setSalario(rs.getDouble("salario"));
        adm.setNumero_comercial(rs.getString("telefone_comercial"));
        adm.setDesc(rs.getString("descricao"));
        adm.setSetor(rs.getString("setor"));

        return adm;
    }

    rs.close();
    comando.close();
    conexao.close();

    return null;
}
public Object[][] relatorioAluno() throws SQLException {
    List<Object[]> linhas = new ArrayList<>();

    Connection conexao = new Conexao().getConexao();
    String sql = "SELECT * FROM usuario INNER JOIN aluno ON usuario.id = fk_usu_aluno";
    PreparedStatement comando = conexao.prepareStatement(sql);
    ResultSet rs = comando.executeQuery();

    while (rs.next()) {
        Object[] linha = {
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("email"),
            rs.getString("cpf"),
            rs.getDate("data_nascimento"),
            rs.getString("matricula"),
            rs.getString("objetivo"),
            rs.getString("status")
        };
        linhas.add(linha);
    }

    rs.close();
    conexao.close();

    // Converter List<Object[]> para Object[][]
    Object[][] dados = new Object[linhas.size()][];
    for (int i = 0; i < linhas.size(); i++) {
        dados[i] = linhas.get(i);
    }

    return dados;
}



}
