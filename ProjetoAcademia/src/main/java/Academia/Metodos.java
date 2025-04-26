package Academia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Janiele
 */
public class Metodos {

    Scanner scan = new Scanner(System.in);

    public void menuPrincipal() {
        //Função repeat utilizada para otimizar a decoração 
        System.out.println("-".repeat(44)); //A funçao repete o que está dentro das aspas
        System.out.println("|Seja Bem Vindo ao Nosso Sistema de Academia|");
        System.out.println("|Escolha uma Opcao:                         |");
        System.out.println("|1- Cadastrar                               |");
        System.out.println("|2- Logar                                   |");
        System.out.println("|3- Sair                                    |");
        System.out.println("-".repeat(44));
    }

    public void menuCadastro() {
        //Função repeat utilizada para otimizar a decoração 
        System.out.println("-".repeat(33));
        System.out.println("|Escolha o seu tipo de Cadastro:|");
        System.out.println("|1- Sou Aluno                   |");
        System.out.println("|2- Sou Admistrador             |");
        System.out.println("|3- Sou Personal                |");
        System.out.println("|4- Quero Sair                  |");
        System.out.println("-".repeat(33));
    }

    public String logar() throws SQLException {
        System.out.println("Email:");
        String email_ver = scan.nextLine();
        System.out.println("Senha:");
        String senha_vre = scan.nextLine();

        Connection conexao = new Conexao().getConexao();

        String sql_logar = "SELECT tipo from `academiaatualizado1.sql`.usuario where email = ? AND senha = ?;";
        PreparedStatement comandoLogar = conexao.prepareStatement(sql_logar);
        comandoLogar.setString(1, email_ver);
        comandoLogar.setString(2, senha_vre);
        ResultSet rs = comandoLogar.executeQuery();

        if (rs.next()) {
            String tipo_uso = rs.getString("tipo");
            return tipo_uso;
        } else {

            return null;

        }

    }

}
