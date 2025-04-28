package Academia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Janiele
 */
public class Cadastro {

    public void inserir(Aluno aluno) throws Exception {
        // conecta com o banco  
        Connection conexao = new Conexao().getConexao();
        // Inserir usuário na tabela 'usuarios' (tabela genérica para usuários)
        //INSERT INTO `academia_db`.`usuario` (`nome`, `cpf`, `email`, `data_nascimento`, `senha`, `tipo`) 
        //VALUES ('Maria Gomes', '120.890.890-89', 'mary@gmail.com', 
        //'2005-09-23', 'kika233', 'aluno');

        String sqlUsuario = "INSERT INTO usuario(nome, cpf, email, data_nascimento, senha, tipo) VALUES(?, ?, ?, ?, ?, ?)";

        //INSERT INTO `academia_db`.`aluno` (`status`, `matricula`, `objetivo`, `fk_usu_aluno`) VALUES ('ativo', 'Mat2028888', 'PerderPeso', '5');
        String sqlAluno = "INSERT INTO aluno (`status`, `matricula`, `objetivo`,`fk_usu_aluno`) VALUES(?, ?, ?, ?)";
        try {
            // Começar uma transação para garantir consistência
            conexao.setAutoCommit(false);

            //inserindo dados na tabela usuários
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            comandoUsuario.setString(1, aluno.getNome());
            comandoUsuario.setString(2, aluno.getCpf());
            comandoUsuario.setString(3, aluno.getEmail());
            comandoUsuario.setDate(4, aluno.getDataNasc());
            comandoUsuario.setString(5, aluno.getSenha());
            comandoUsuario.setString(6, aluno.getTipo());
            comandoUsuario.executeUpdate();

            // Obter o id gerado automaticamente (pois o banco utiliza auto incremento)
            ResultSet rs = comandoUsuario.getGeneratedKeys();
            rs.next();
            int uso_aluno = rs.getInt(1);

            // Inserindo dados na tabela aluno
            PreparedStatement comandoAluno = conexao.prepareStatement(sqlAluno);
            comandoAluno.setString(1, aluno.getStatus());
            comandoAluno.setString(2, aluno.getMatricula());
            comandoAluno.setString(3, aluno.getObjetivo());
            comandoAluno.setInt(4, uso_aluno);
            comandoAluno.executeUpdate();

            // Confirmar a transação
            conexao.commit();
            System.out.println("Aluno cadastrado com sucesso!");

            // Fechar as conexões
            comandoUsuario.close();
            comandoAluno.close();
            conexao.setAutoCommit(true);

        } catch (Exception e) {
            try {
                // Em caso de erro, desfaz a transação
                conexao.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao reverter a transação: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage()); //retorno para o caso de dar erro no processo;
        }
    }
    
     public void inserir(Adm adm) throws Exception {
        // conecta com o banco  
        Connection conexao = new Conexao().getConexao();
        // Inserir usuário na tabela 'usuarios' (tabela genérica para usuários)
        //INSERT INTO `academia_db`.`usuario` (`nome`, `cpf`, `email`, `data_nascimento`, `senha`, `tipo`) 
        //VALUES ('Maria Gomes', '120.890.890-89', 'mary@gmail.com', 
        //'2005-09-23', 'kika233', 'aluno');

        String sqlUsuario = "INSERT INTO usuario(nome, cpf, email, data_nascimento, senha, tipo) VALUES(?, ?, ?, ?, ?, ?)";

        //INSERT INTO `academia_db`.`adm` (`salario`, `telefone_comercial`,`descricao`, `setor`, `fk_usu_adm`) VALUES (?, ?, ?, ?, ?);
        String sqlAdm = "INSERT INTO adm (`salario`, `telefone_comercial`,`descricao`, `setor`, `fk_usu_adm`) VALUES (?, ?, ?, ?, ?)";
        try {
            // Começar uma transação para garantir consistência
            conexao.setAutoCommit(false);

            //inserindo dados na tabela usuários
            PreparedStatement comandoUsuario = conexao.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            comandoUsuario.setString(1, adm.getNome());
            comandoUsuario.setString(2, adm.getCpf());
            comandoUsuario.setString(3, adm.getEmail());
            comandoUsuario.setDate(4, adm.getDataNasc());
            comandoUsuario.setString(5, adm.getSenha());
            comandoUsuario.setString(6, adm.getTipo());
            comandoUsuario.executeUpdate();

            // Obter o id gerado automaticamente (pois o banco utiliza auto incremento)
            ResultSet rs = comandoUsuario.getGeneratedKeys();
            rs.next();
            int uso_adm = rs.getInt(1);

            // Inserindo dados na tabela aluno
            PreparedStatement comandoAluno = conexao.prepareStatement(sqlAdm);
            comandoAluno.setDouble(1, adm.getSalario());
            comandoAluno.setString(2, adm.getNumero_comercial());
            comandoAluno.setString(3, adm.getDesc());
            comandoAluno.setString(4, adm.getSetor());
            comandoAluno.setInt(5, uso_adm);
            comandoAluno.executeUpdate();

            // Confirmar a transação
            conexao.commit();
            System.out.println("Administrador cadastrado com sucesso!");

            // Fechar as conexões
            comandoUsuario.close();
            comandoAluno.close();
            conexao.setAutoCommit(true);

        } catch (Exception e) {
            try {
                // Em caso de erro, desfaz a transação
                conexao.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao reverter a transação: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao cadastrar adm: " + e.getMessage()); //retorno para o caso de dar erro no processo;
        }
    }
}
