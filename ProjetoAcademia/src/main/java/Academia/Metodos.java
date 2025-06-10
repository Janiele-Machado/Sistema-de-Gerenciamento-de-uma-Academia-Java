package Academia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
        System.out.println("|3- Registrar Pagamentos         |");
        System.out.println("|4- Alterar Cadastro             |");
        System.out.println("|5- Desativar meu plano          |");
        System.out.println("|6- Reativar meu plano           |");
        System.out.println("|7- Sair                         |");
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
        // Método para autenticar o usuário com email e senha.
        // Se encontrar no banco, retorna o tipo de usuário (aluno, adm ou personal).

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
        // Menu com as opções exclusivas do administrador.
        // Permite deletar usuários, ver relatórios, registrar pagamentos e alterar dados.

        do {
            System.out.println("-".repeat(33));
            System.out.println("|------MENU ADMINISTRADOR:-------|");
            System.out.println("|1-Deletar usuarios              |");
            System.out.println("|2-Relatorio financeiro          |");
            System.out.println("|3-Folha salarial                |");
            System.out.println("|4- Relatorio Geral              |");
            System.out.println("|5- Registrar Pagamentos         |");
            System.out.println("|6- Quero atualizar o bonus      |");
            System.out.println("|7- Quero atualizar meu cadastro |");
            System.out.println("|8- Quero Sair                   |");
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
                        System.out.println("Digite uma opcao valida");
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
                        System.out.println("Digite uma opcao valida");
                    }
                } while (opc_amd != 4);
            } else if (opc_amd == 5) {
                ///Essa funcionalidade tem o objetivo de apenas registrar o valor de pagamento de salarios para fins de relatórios financeiros, ele não realmente realiza pagamentos 
                System.out.println("Tem Certeza que deseja registrar um pagamento? Digite S para sim e N para nao:");
                String op1 = scan.nextLine();

                if (op1.equalsIgnoreCase("s")) {
                    System.out.println("-------------------REGISTRAR PAGAMENTO--------------------");
                    System.out.println("Digite por favor o valor que voce deseja registrar: ");
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
                System.out.println("Tem Certeza que deseja alterar seu cadastro? Digite S para sim e N para nao:");
                String op1 = scan.nextLine();
                if (op1.equalsIgnoreCase("s")) {
                    Adm a1 = new Adm();
                    a1.setId(id);
                    System.out.println("Ola, Insira os dados pra prosseguir com sua atualizacao do cadastro:");
                    System.out.println("Digite seu nome Completo:");
                    a1.setNome(scan.nextLine());
                    System.out.println("Digite seu Email:");
                    a1.setEmail(scan.nextLine());
                    System.out.println("Digite seu Numero comercial:");
                    a1.setNumero_comercial(scan.nextLine());
                    System.out.println("Digite o seu Setor:");
                    a1.setSetor(scan.nextLine());
                    System.out.println("Descreva a sua area de atuacao:");
                    a1.setDesc(scan.nextLine());
                    System.out.println("Agora, digite sua senha para acessar o sistema:");
                    a1.setSenha(scan.nextLine());
                    Alterar alt_adm = new Alterar();
                    alt_adm.alterarAdm(a1);
                } else {
                    System.out.println("saindo...");

                }

            } else if (opc_amd == 8) {
                System.out.println("...");

            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opc_amd != 8);
    }

    public void menuPersonal() throws SQLException {

        System.out.println("-".repeat(33));
        System.out.println("|---------MENU PERSONAL:--------|");
        System.out.println("|1- Ver meus alunos             |");
        System.out.println("|2- Ver meu salario             |");
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

    public Aluno buscarAlunoPorId(int id) {
        Aluno aluno = new Aluno();

        String sqlUsuario = "SELECT * FROM usuarios WHERE id=?";
        String sqlAluno = "SELECT * FROM aluno WHERE fk_usu_aluno=?";

        try (Connection conexao = new Conexao().getConexao()) {

            PreparedStatement stmUsuario = conexao.prepareStatement(sqlUsuario);
            stmUsuario.setInt(1, id);
            ResultSet rstUsuario = stmUsuario.executeQuery();

            if (rstUsuario.next()) {
                aluno.setId(rstUsuario.getInt("id"));
                aluno.setNome(rstUsuario.getString("nome"));
                aluno.setCpf(rstUsuario.getString("cpf"));
                aluno.setEmail(rstUsuario.getString("email"));
                aluno.setDataNasc(rstUsuario.getNString("data_nascimento"));
                aluno.setSenha(rstUsuario.getString("senha"));
                aluno.setTipo(rstUsuario.getString("tipo"));
            }

            PreparedStatement stmAluno = conexao.prepareStatement(sqlAluno);
            stmAluno.setInt(1, id);
            ResultSet rstAluno = stmAluno.executeQuery();

            if (rstAluno.next()) {
                aluno.setStatus(rstAluno.getString("status"));
                aluno.setMatricula(rstAluno.getString("matricula"));
                aluno.setObjetivo(rstAluno.getString("objetivo"));
            }

            stmUsuario.close();
            stmAluno.close();

        } catch (SQLException e) {
            System.out.println("Erro na busca do aluno: " + e.getMessage());
            e.printStackTrace();
        }

        return aluno;
    }

    public void salarioPersonal(int idPersonal) throws SQLException {

        Connection conexao = new Conexao().getConexao();

        String sqlDados = "SELECT salario, bonus_por_aluno,quant_alunos FROM personal WHERE personal.id = ?";
        PreparedStatement comandoDados = conexao.prepareStatement(sqlDados);
        comandoDados.setInt(1, idPersonal);
        ResultSet rsDados = comandoDados.executeQuery();

        if (rsDados.next()) {

            double salarioBase = rsDados.getDouble("salario");
            double bonusPorAluno = rsDados.getDouble("bonus_por_aluno");
            int qtdAlunos = rsDados.getInt("quant_alunos");

            double salarioFinal = salarioBase + (bonusPorAluno * qtdAlunos);

            System.out.println("===== Salario Atual =====");
            System.out.println("Salario base: R$" + salarioBase);
            System.out.println("Alunos ativos: " + qtdAlunos);
            System.out.println("Bonus por aluno: R$" + bonusPorAluno);
            System.out.println("Salario total: R$" + salarioFinal);
            System.out.println("=========================");

        } else {
            System.out.println("Dados do personal não encontrados.");
        }

        rsDados.close();
        comandoDados.close();
        conexao.close();
    }
    //metodo obsoleto

    public Personal buscarPersonalPorID(int idPersonal) throws SQLException {
        Personal personal = null;

        Connection conn = new Conexao().getConexao();

        String sql = "SELECT * FROM personal WHERE fk_usu_personal = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPersonal);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                personal = new Personal();

                personal.setId(rs.getInt("id"));
                personal.setNome(rs.getString("nome"));
                personal.setCpf(rs.getString("cpf"));
                personal.setEmail(rs.getString("email"));

                Date dataNasc = rs.getDate("dataNasc");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataNascString = formato.format(dataNasc);

                personal.setDataNasc(dataNascString);

                personal.setSenha(rs.getString("senha"));
                personal.setTipo(rs.getString("tipo"));
                personal.setEspecialidade(rs.getString("especialidade"));
                personal.setSalario(rs.getDouble("salario"));
                personal.setBonus_por_aluno(rs.getDouble("bonus_por_aluno"));
                personal.setQtd_aluno(rs.getInt("quant_alunos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar personal por ID.", e);
        }

        return personal;
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

    public void calcularBonos(String email) throws SQLException {
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
            bonus = 0.0;

        }
        if (bonus > 0) {
            try {
                int id = retornoID(email);
                LocalDate data_pag = LocalDate.now();
                String categoria = "bonus";
                String sql_insertB = "INSERT INTO `financa` (`usuario_id`, `valor`, `data_pagamento`, `categoria`) VALUES (?, ?, ?, ?);";
                PreparedStatement comandocal2 = conexao.prepareStatement(sql_insertB);
                comandocal2.setInt(1, id);
                comandocal2.setDouble(2, bonus);
                comandocal2.setDate(3, java.sql.Date.valueOf(data_pag));
                comandocal2.setString(4, categoria);
                comandocal2.executeUpdate();

                String sql_insertP = "UPDATE personal SET bonus_por_aluno = ? WHERE fk_usu_personal = ?;";
                PreparedStatement comandocal3 = conexao.prepareStatement(sql_insertP);
                comandocal3.setDouble(1, bonus);
                comandocal3.setInt(2, id);
                comandocal3.executeUpdate();

                System.out.println("Bonus Depositado");

            } catch (SQLException e) {
                System.out.println(e);

            }
        } else {
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
                System.out.println("Erro ao reverter a transacao: " + rollbackEx.getMessage());
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

    //método que recebe o id de usuario e retorna o id de aluno;
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

    //método que recebe o id de usuario e retorna o id de personal;
    public int obterIdPersonal(int id) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql_relID = "Select id from personal where fk_usu_personal = ? ";
        PreparedStatement comando_relID = conexao.prepareStatement(sql_relID);
        comando_relID.setInt(1, id);
        ResultSet rs = comando_relID.executeQuery();
        if (rs.next()) {
            int id_personal = rs.getInt("id");
            return id_personal;

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
            System.out.println("Pagamento Registrado com sucesso!");

            // Fechar as conexões
            comandoPg.close();
            conexao.setAutoCommit(true);

        } catch (Exception e) {
            try {
                // Em caso de erro, desfaz a transação
                conexao.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Erro ao reverter a transacao: " + rollbackEx.getMessage());
            }
            System.out.println("Erro ao registrar pagamentos: " + e.getMessage()); //retorno para o caso de dar erro no processo;
        }

    }

    public String verPlano(int idUsuario) throws SQLException {
        Connection conexao = new Conexao().getConexao();

        String sql = """
        SELECT assinatura.nome_plano, assinatura.duracao_meses, assinatura.valor,
               assinatura.data_inicio, assinatura.data_fim, assinatura.ativa
        FROM assinatura
        JOIN aluno ON assinatura.aluno_id = aluno.id
        WHERE aluno.fk_usu_aluno = ?;
    """;

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();

        StringBuilder sb = new StringBuilder();

        if (rs.next()) {
            sb.append("===== Detalhes do Plano Contratado =====\n");
            sb.append("Nome do plano: ").append(rs.getString("nome_plano")).append("\n");
            sb.append("Duração (meses): ").append(rs.getInt("duracao_meses")).append("\n");
            sb.append("Valor: R$").append(rs.getDouble("valor")).append("\n");
            sb.append("Início: ").append(rs.getDate("data_inicio")).append("\n");
            sb.append("Fim: ").append(rs.getDate("data_fim")).append("\n");
            sb.append("Ativo: ").append(rs.getString("ativa")).append("\n");
            sb.append("=========================================\n");
        } else {
            sb.append("Você não possui nenhum plano contratado.");
        }

        rs.close();
        ps.close();
        conexao.close();

        return sb.toString();
    }

    public void desativarPlano(int idUsuario) throws SQLException { // metodo para desativar o seu plano atual.
        Connection conexao = new Conexao().getConexao();

        String sql = """
        UPDATE assinatura
        JOIN aluno ON assinatura.aluno_id = aluno.id
        SET assinatura.ativa = 'nao'
        WHERE aluno.fk_usu_aluno = ? AND assinatura.ativa = 'sim';
    """;

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idUsuario);

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Sua assinatura foi desativada com sucesso.");
        } else {
            System.out.println("Voce nao possui nenhuma assinatura ativa.");
        }

        ps.close();
        conexao.close();
    }

    public void reativarPlano(int idUsuario) throws SQLException { // metodo para reativar plano desativado.
        Connection conexao = new Conexao().getConexao();

        String sql = """
        UPDATE assinatura
        JOIN aluno ON assinatura.aluno_id = aluno.id
        SET assinatura.ativa = 'sim'
        WHERE aluno.fk_usu_aluno = ? AND assinatura.ativa = 'nao';
    """;

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idUsuario);

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Assinatura reativada com sucesso!");
        } else {
            System.out.println("Voce não tem nenhuma assinatura desativada para reativar.");
        }

        ps.close();
        conexao.close();
    }
}
