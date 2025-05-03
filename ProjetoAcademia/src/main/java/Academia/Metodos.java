package Academia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Janiele
 */
public class Metodos {

    Scanner scan = new Scanner(System.in);
    Deletar del = new Deletar();
    Relatorios rel = new Relatorios();

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
        System.out.println("|---------MENU ALUNO:----------- |");
        System.out.println("|Escolha o que voce deseja fazer:|");
        System.out.println("|1- Contratar um plano           |");
        System.out.println("|2- Ver meu plano                |");
        System.out.println("|3- Fazer Pagamento              |");
        System.out.println("|4- Alterar Cadastro             |");
        System.out.println("|5- Desativar meu plano          |");
        System.out.println("|6-Sair                          |");
        System.out.println("-".repeat(34));
    }

    public void opcPlanos() {
        System.out.println("-".repeat(54));
        System.out.println("|Escolha qual Plano Voce Deseja Contratar:          |");
        System.out.println("|Opcao 1: Plano Comum                               |");
        System.out.println("|Tipo: Mensal                                       |");
        System.out.println("|Valor: 120 reais                                   |");
        System.out.println("|Sem Instrutor ):                                   |\n");
        System.out.println("|Opcao 2: Plano Premium                             |");
        System.out.println("|Tipo: Trimestral(Por tres meses)                   |");
        System.out.println("|Valor: 100 reais                                   |");
        System.out.println("|Com direito a um instrutor de sua preferencia      |\n");
        System.out.println("|Opcao 3: Plano Premium Plus                        |");
        System.out.println("|Tipo: anual(Por doze meses)                        |");
        System.out.println("|Valor: 90 reais                                    |");
        System.out.println("|Com direito a um instrutor de sua preferencia      |");
        System.out.println("-".repeat(54));

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

            return "";

        }

    }

    public void menuADM(int id) throws SQLException, Exception {
        int opc_amd = 0;
        do {
            System.out.println("-".repeat(33));
            System.out.println("|------MENU ADMINISTRADOR:-------|");
            System.out.println("|1-Deletar usuarios              |");
            System.out.println("|2-Relatorio financeiro          |");
            System.out.println("|3-Folha salarial                |");
            System.out.println("|4- Relatorio Geral              |");
            System.out.println("|5- Realizar Pagamentos          |");
            System.out.println("|6- Quero atualizar o bonus      |");
            System.out.println("|7- Quero Sair                   |");
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
                    scan.nextLine();
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
                } while (opc1 != 4);

            } else if (opc_amd == 2) {
                rel.gerarBalanco();
                
                

            } else if (opc_amd == 3) {
                rel.Relatorio_salarios();

            } else if (opc_amd == 4) {
                int opc4 = 0;
                do {
                    System.out.println("-".repeat(33));
                    System.out.println("|-------Relatorio:-------|");
                    System.out.println("|1-Relatorio Personal    |");
                    System.out.println("|2-Relatorio ADM         |");
                    System.out.println("|3-Relatorio Aluno       |");
                    System.out.println("|4-Sair                  |");
                    opc4 = scan.nextInt();
                    if (opc4 == 1) {
                        rel.Relatorio_personal();

                    } else if (opc4 == 2) {
                        rel.Relatorio_adm();

                    } else if (opc4 == 3) {
                        rel.Relatorio_aluno();
                    } else if (opc4 == 4) {
                        System.out.println(":::");

                    } else {
                        System.out.println("Digite uma opção valida");
                    }
                } while (opc_amd != 4);
            } else if (opc_amd == 5) {
                //realizar pagamentos 
                System.out.println("Tem Certeza que deseja realizar um pagamento? Digite S para sim e N para nao:");
                String op1 = scan.nextLine();

                if (op1.equalsIgnoreCase("s")) {
                    System.out.println("-------------------PAGAMENTO--------------------");
                    System.out.println("Digite por favor o valor que voce deseja pagar: ");
                    double valor = scan.nextDouble();
                    scan.nextLine();
                    String desc = "Salario";
                    this.fazerPagamentos(id, valor, desc);

                } else {
                    System.out.println("saindo...");

                }
            } else if (opc_amd == 6) {
               System.out.println("Tem Certeza que deseja realizar um pagamento de bonus ? Digite S para sim e N para nao:");
                String op1 = scan.nextLine();

                if (op1.equalsIgnoreCase("s")) {
                    System.out.println("-------------------PAGAMENTO de BONUS--------------------");
                    System.out.println("Digite por favor o email do personal que queria repassar o bonus  ");
                    this.calcularBonos(scan.nextLine());
                    

                } else {
                    System.out.println("saindo...");

                }
                //bonus

            } else if (opc_amd == 7) {
                System.out.println("...");

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opc_amd != 7);
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
    
    public void listarAlunos(int idPersonal) throws SQLException {
        Conexao conexao = new Conexao();
        Connection con = conexao.getConexao();

        String sqlListar = """
            SELECT usuario.nome, usuario.email, aluno.objetivo
            FROM assinatura
            JOIN aluno ON assinatura.aluno_id = aluno.id
            JOIN usuario ON aluno.fk_usu_aluno = usuario.id
            WHERE assinatura.personal_id = ? AND assinatura.ativa = 'sim';
        """;

        PreparedStatement ps = con.prepareStatement(sqlListar);
        ps.setInt(1, idPersonal);

        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Alunos Ativos ---");
        while (rs.next()) {
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Objetivo: " + rs.getString("objetivo"));
            System.out.println("--------------------------");
        }

        rs.close();
        ps.close();
        con.close();
    }


    public static int retornoID(String email) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relID = "select id from usuario  where email = ?;";
        PreparedStatement comando_relID = conexao.prepareStatement(sql_relID);
        comando_relID.setString(1, email);
        ResultSet rs = comando_relID.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            return id;

        } else {
            return 0;
        }

    }

    public void  calcularBonos(String email) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_cal = "SELECT personal.quant_alunos FROM usuario JOIN personal ON personal.fk_usu_personal = usuario.id WHERE usuario.email = ?; ";
        PreparedStatement comandocal = conexao.prepareStatement(sql_cal);
        comandocal.setString(1, email);
        ResultSet rs = comandocal.executeQuery();
        double bonus;
        if (rs.next()) {
            int quant = rs.getInt("quant_alunos");
             bonus = 50 * quant; // 50 por aluno pode se tornar dinamico
        } else {
            bonus=0.0;
            
        }
        if(bonus>0){
            try{
            int id =retornoID(email);
            LocalDate data_pag= LocalDate.now();
            String categoria="bonus";
            String sql_insertB = "INSERT INTO `financa` (`usuario_id`, `valor`, `data_pagamento`, `categoria`) VALUES (?, ?, ?, ?);";
            PreparedStatement comandocal2 = conexao.prepareStatement(sql_insertB);
            comandocal2.setInt(1, id);
            comandocal2.setDouble(2, bonus);
            comandocal2.setDate(3, java.sql.Date.valueOf(data_pag));
            comandocal2.setString(4, categoria);
            comandocal2.executeUpdate();
            
                
            String sql_insertP = "UPDATE personal SET bonus_por_aluno = ? WHERE fk_usu_personal = ?;";    
            PreparedStatement  comandocal3 = conexao.prepareStatement(sql_insertP);
            comandocal3.setDouble(1,bonus);
            comandocal3.setInt(2, id);
            comandocal3.executeUpdate();
            
            System.out.println("Bonus Depositado");
            
            }catch(SQLException e){
                System.out.println(e);
                
            }
        }else{
            System.out.println("Sem bonos");
        }

    }
    

    public void contratarPlano(int idAluno) throws Exception {
        double valor = 120;
        String nome = "Plano Comum";
        int duracao = 1;
        String ativa = "sim";
        LocalDate data_inicio = LocalDate.now(); // pega a data atual do dia da contratação
        LocalDate data_fim = data_inicio.plus(1, ChronoUnit.MONTHS);//add um mês a data de contratação
        Date dataInicioSQL = Date.valueOf(data_inicio);
        Date dataFimSQL = Date.valueOf(data_fim);

        // conecta com o banco  
        Connection conexao = new Conexao().getConexao();

        //INSERT INTO `assinatura` (`aluno_id`, `nome_plano`, `duracao_meses`, `valor`, `data_inicio`, `data_fim`, `ativa`) VALUES ('3', 'Plano Comum', '1', '100', '2025-04-30', '2025-05-30', 'sim');
        String sqlAss = "INSERT INTO `assinatura` (`aluno_id`, `nome_plano`, `duracao_meses`, `valor`, `data_inicio`, `data_fim`, `ativa`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            // Começar uma transação para garantir consistência
            conexao.setAutoCommit(false);

            // Inserindo dados na tabela aluno
            PreparedStatement comandoAss = conexao.prepareStatement(sqlAss);
            comandoAss.setInt(1, idAluno);
            comandoAss.setString(2, nome);
            comandoAss.setInt(3, duracao);
            comandoAss.setDouble(4, valor);
            comandoAss.setDate(5, dataInicioSQL);
            comandoAss.setDate(6, dataFimSQL);
            comandoAss.setString(7, ativa);
            comandoAss.executeUpdate();

            // Confirmar a transação
            conexao.commit();
            System.out.println("Plano Contratado com sucesso!");

            // Fechar as conexões
            comandoAss.close();
            conexao.setAutoCommit(true);

        } catch (Exception e) {
            try {
                // Em caso de erro, desfaz a transação
                conexao.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao reverter a transação: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao contratar: " + e.getMessage()); //retorno para o caso de dar erro no processo;
        }
    }

    public void contratarPlano(int idAluno, int id_personal, double valor, int duracao, String nome, int qtd) throws Exception {

        String ativa = "sim";
        LocalDate data_inicio = LocalDate.now(); // pega a data atual do dia da contratação
        LocalDate data_fim = data_inicio.plus(duracao, ChronoUnit.MONTHS);//add os meses a data de contratação
        Date dataInicioSQL = Date.valueOf(data_inicio);
        Date dataFimSQL = Date.valueOf(data_fim);
        qtd = qtd + 1;

        // conecta com o banco  
        Connection conexao = new Conexao().getConexao();

        //INSERT INTO `academia_db`.`assinatura` (`aluno_id`, `personal_id`, `nome_plano`, `duracao_meses`, `valor`, `data_inicio`, `data_fim`, `ativa`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1');
        String sqlAss = "INSERT INTO `assinatura` (`aluno_id`, `personal_id`, `nome_plano`, `duracao_meses`, `valor`, `data_inicio`, `data_fim`, `ativa`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        String sqlqtd = "UPDATE `personal` SET `quant_alunos` = ? WHERE (`id` = ?);";
        try {
            // Começar uma transação para garantir consistência
            conexao.setAutoCommit(false);

            // Inserindo dados na tabela aluno
            PreparedStatement comandoAss = conexao.prepareStatement(sqlAss);
            comandoAss.setInt(1, idAluno);
            comandoAss.setInt(2, id_personal);
            comandoAss.setString(3, nome);
            comandoAss.setInt(4, duracao);
            comandoAss.setDouble(5, valor);
            comandoAss.setDate(6, dataInicioSQL);
            comandoAss.setDate(7, dataFimSQL);
            comandoAss.setString(8, ativa);
            comandoAss.executeUpdate();

            PreparedStatement comandoQtd = conexao.prepareStatement(sqlqtd);
            comandoQtd.setInt(1, qtd);
            comandoQtd.setInt(2, id_personal);
            comandoQtd.executeUpdate();

            // Confirmar a transação
            conexao.commit();
            System.out.println("Plano Contratado com sucesso!");

            // Fechar as conexões
            comandoAss.close();
            comandoQtd.close();
            conexao.setAutoCommit(true);

        } catch (Exception e) {
            try {
                // Em caso de erro, desfaz a transação
                conexao.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao reverter a transação: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao contratar: " + e.getMessage()); //retorno para o caso de dar erro no processo;
        }
    }

    public int obterIdAluno(int id) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relID = "Select id from aluno where fk_usu_aluno = ? ";
        PreparedStatement comando_relID = conexao.prepareStatement(sql_relID);
        comando_relID.setInt(1, id);
        ResultSet rs = comando_relID.executeQuery();
        if (rs.next()) {
            int id_aluno = rs.getInt("id");
            return id_aluno;

        } else {
            return 0;
        }
    }

    public void listarPersonal() throws SQLException {

        Connection conexao = new Conexao().getConexao();
        String sqlListar = "SELECT usuario.nome, personal.especialidade FROM personal inner join usuario on usuario.id = personal.fk_usu_personal;";
        try {
            PreparedStatement comandoListar = conexao.prepareStatement(sqlListar);
            ResultSet rs2 = comandoListar.executeQuery();

            while (rs2.next()) {

                System.out.println("Nome: " + rs2.getString("nome"));
                System.out.println("Especialidade: " + rs2.getString("especialidade"));
                System.out.println("-----------------------------------------------");
            }

            comandoListar.close();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {

            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    public int obterIdPersonal(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relID = "select personal.id from personal inner join usuario on usuario.id = personal.fk_usu_personal where usuario.nome = ?;";
        PreparedStatement comando_relID = conexao.prepareStatement(sql_relID);
        comando_relID.setString(1, nome);
        ResultSet rs = comando_relID.executeQuery();
        if (rs.next()) {
            int id_personal = rs.getInt("id");
            return id_personal;

        } else {
            return 0;
        }
    }

    public int descobrirQTDalunos(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_cal = "SELECT personal.quant_alunos FROM usuario JOIN personal ON personal.fk_usu_personal = usuario.id WHERE usuario.nome = ?; ";
        PreparedStatement comandocal = conexao.prepareStatement(sql_cal);
        comandocal.setString(1, nome);
        ResultSet rs = comandocal.executeQuery();
        if (rs.next()) {
            int quant = rs.getInt("quant_alunos");
            return quant;
        } else {
            return -1;
        }

    }

    public void fazerPagamentos(int idUsuario, double valor, String categoria) throws Exception {

        LocalDate data_pagamento = LocalDate.now(); // pega a data atual do dia do pagamento

        Date dataPgSQL = Date.valueOf(data_pagamento);

        // conecta com o banco  
        Connection conexao = new Conexao().getConexao();

        //INSERT INTO `academia_db`.`financa` (`usuario_id`, `valor`, `data_pagamento`, `categoria`) VALUES ('x', 'x', 'x', 'x');
        String sqlPg = "INSERT INTO `financa` (`usuario_id`, `valor`, `data_pagamento`, `categoria`) VALUES (?, ?, ?, ?);";
        try {
            // Começar uma transação para garantir consistência
            conexao.setAutoCommit(false);

            // Inserindo dados na tabela aluno
            PreparedStatement comandoPg = conexao.prepareStatement(sqlPg);
            comandoPg.setInt(1, idUsuario);
            comandoPg.setDouble(2, valor);
            comandoPg.setDate(3, dataPgSQL);
            comandoPg.setString(4, categoria);
            comandoPg.executeUpdate();

            // Confirmar a transação
            conexao.commit();
            System.out.println("Pagamento Realizado com sucesso!");

            // Fechar as conexões
            comandoPg.close();
            conexao.setAutoCommit(true);

        } catch (Exception e) {
            try {
                // Em caso de erro, desfaz a transação
                conexao.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao reverter a transação: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao pagar: " + e.getMessage()); //retorno para o caso de dar erro no processo;
        }
        
    }

}
