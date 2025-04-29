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
    Deletar del = new Deletar();

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

    public void menuAluno() {
        //Função repeat utilizada para otimizar a decoração 
        System.out.println("-".repeat(34));
        System.out.println("|Escolha o que voce deseja fazer:|");
        System.out.println("|1- Contratar um plano           |");
        System.out.println("|2- Ver meu plano                |");
        System.out.println("|3- Fazer Pagamento              |");
        System.out.println("|4- Alterar Cadastro             |");
        System.out.println("|5- Desativar meu plano          |");
        System.out.println("|6-Sair                          |");
        System.out.println("-".repeat(34));
    }

    public String logar(String email_ver, String senha_ver) throws SQLException {

        

        Connection conexao = new Conexao().getConexao();

        String sql_logar = "SELECT tipo from usuario where email = ? AND senha = ?;";
        PreparedStatement comandoLogar = conexao.prepareStatement(sql_logar);
        comandoLogar.setString(1, email_ver);
        comandoLogar.setString(2, senha_ver);
        ResultSet rs = comandoLogar.executeQuery();

        if (rs.next()) {
            String tipo_uso = rs.getString("tipo");
            return tipo_uso;
        } else {

            return null;

        }

    }

    public void menuADM() throws SQLException {
        int opc_amd = 0;
        do {
            System.out.println("-".repeat(33));
            System.out.println("|------MENU ADMINISTRADOR:-------|");
            System.out.println("|1-Deletar usuarios              |");
            System.out.println("|2-Relatorio financeiro          |");
            System.out.println("|3-Folha salarial                |");
            System.out.println("|4- Relatorio Geral              |");
            System.out.println("|5-Cadastrar planos             |");
            System.out.println("|6- Quero Sair                   |");
            System.out.println("-".repeat(33));
            opc_amd = scan.nextInt();
            scan.nextLine();
            if (opc_amd == 1) {
                int opc1 = 0;
                do {
                    System.out.println("-".repeat(33));
                    System.out.println("|-------Deletar:-------|");
                    System.out.println("|1-Deletar Personal    |");
                    System.out.println("|2-Deletar ADM         |");
                    System.out.println("|3-Deletar Aluno       |");
                    System.out.println("|4-Sair                |");
                    opc1 = scan.nextInt();
                    if (opc1 == 1) {
                        System.out.println("Digite o email do Personal que queria Deletar");
                        del.deletarPersonal(scan.nextLine());

                    } else if (opc1 == 2) {
                        System.out.println("Digite o email do ADM que queira Deletar");
                        del.deletarAdm(scan.nextLine());
                    } else if (opc1 == 3) {
                        System.out.println("Digite o email do Aluno que queira Deletar");
                        del.deletarAluno(scan.nextLine());
                    } else if (opc1 == 4) {
                        System.out.println(":::");
                    } else {
                        System.out.println("Digite uma opção valida");
                    }
                } while (opc1 == 4);

            } else if (opc_amd == 2) {

            } else if (opc_amd == 3) {

            } else if (opc_amd == 4) {

            } else if (opc_amd == 5) {

            } else if (opc_amd == 6) {
                System.out.println("...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opc_amd == 6);
    }
    
    public void menuPersonal() throws SQLException {
        
        System.out.println("-".repeat(33));
        System.out.println("|---------MENU PERSONAL:--------|");
        System.out.println("|1- Ver meus alunos             |");
        System.out.println("|2- Ver meu salário             |");
        System.out.println("|3- Alterar meu cadastro        |");
        System.out.println("|4- Sair                        |");
        System.out.println("-".repeat(33));
        
    }
    
    public int retornoID(String email) throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql_relID = "select id from usuario  where email = ?;";
        PreparedStatement comando_relID = conexao.prepareStatement(sql_relID);
        comando_relID.setString(1, email);
        ResultSet rs = comando_relID.executeQuery();
        if(rs.next()){
            int id = rs.getInt("id");
            return id;
            
            
        }else{
            return 0;
        }
        
        
        
    }

}
