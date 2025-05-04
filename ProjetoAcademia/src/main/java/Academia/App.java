package Academia;

import java.sql.Date;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    // pra que serve tantos codigos?
    // se a vida nao é programada
    // e as melhores coisas
    // nao tem logica

    public static String geradorMatricula() {
        Random rand = new Random();

        // Gera os primeiros 4 dígitos (entre 1000 e 9999)
        int primeiraParte = 1000 + rand.nextInt(9000);

        // Gera os segundos 4 dígitos (entre 1000 e 9999)
        int segundaParte = 1000 + rand.nextInt(9000);

        return "MAT" + String.valueOf(primeiraParte) + String.valueOf(segundaParte); //retorna a matricula gerada;
    }

    public static void main(String[] args) throws SQLException, Exception {
        Metodos metodos = new Metodos();
        Scanner scan = new Scanner(System.in);
        int opc_principal = 0;

        while (opc_principal != 3) {
            try {
                metodos.menuPrincipal();
                opc_principal = scan.nextInt();
                scan.nextLine();

                if (opc_principal == 1) {
                    int opc_cadastro = 0;
                    while (opc_cadastro != 4) {

                        metodos.menuCadastro();
                        opc_cadastro = scan.nextInt();
                        scan.nextLine();

                        switch (opc_cadastro) {
                            case 1:
                                try {
                                    Aluno a1 = new Aluno();
                                    System.out.println("Ola, Insira os dados pra prosseguir com seu Cadastro:");
                                    System.out.println("Digite seu nome Completo:");
                                    a1.setNome(scan.nextLine());
                                    System.out.println("Digite seu Email:");
                                    a1.setEmail(scan.nextLine());
                                    System.out.println("Digite seu CPF:");
                                    a1.setCpf(scan.nextLine());
                                    System.out.println("Digite sua data de nascimento:");
                                    a1.setDataNasc(scan.nextLine());
                                    System.out.println("Digite seu Objetivo:");
                                    a1.setObjetivo(scan.nextLine());
                                    System.out.println("Agora, digite sua senha para acessar o sistema:");
                                    a1.setSenha(scan.nextLine());
                                    a1.setTipo("aluno");
                                    a1.setMatricula(geradorMatricula());
                                    a1.setStatus("ativo");
                                    Cadastro cad_aluno = new Cadastro();
                                    cad_aluno.inserir(a1);
                                } catch (Exception e) {
                                    System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
                                    e.printStackTrace();
                                }

                                break;
                            case 2:
                                try {
                                    Adm a1 = new Adm();
                                    System.out.println("Ola, Insira os dados pra prosseguir com seu Cadastro:");
                                    System.out.println("Digite seu nome Completo:");
                                    a1.setNome(scan.nextLine());
                                    System.out.println("Digite seu Email:");
                                    a1.setEmail(scan.nextLine());
                                    System.out.println("Digite seu CPF:");
                                    a1.setCpf(scan.nextLine());
                                    System.out.println("Digite sua data de nascimento:");
                                    a1.setDataNasc(scan.nextLine());
                                    System.out.println("Digite seu Número comercial:");
                                    a1.setNumero_comercial(scan.nextLine());
                                    System.out.println("Digite o seu Setor:");
                                    a1.setSetor(scan.nextLine());
                                    System.out.println("Descreva a sua area de atuacao:");
                                    a1.setDesc(scan.nextLine());
                                    System.out.println("Agora, digite sua senha para acessar o sistema:");
                                    a1.setSenha(scan.nextLine());
                                    a1.setTipo("adm");
                                    a1.setSalario(1500);
                                    Cadastro cad_adm = new Cadastro();
                                    cad_adm.inserir(a1);
                                } catch (Exception e) {
                                    System.out.println("Erro ao cadastrar adm: " + e.getMessage());
                                    e.printStackTrace(); //exibir informações detalhadas sobre uma exceção 
                                }
                                break;
                            case 3:
                                try {
                                    Personal a1 = new Personal();
                                    System.out.println("Ola, Insira os dados pra prosseguir com seu Cadastro:");
                                    System.out.println("Digite seu nome Completo:");
                                    a1.setNome(scan.nextLine());
                                    System.out.println("Digite seu Email:");
                                    a1.setEmail(scan.nextLine());
                                    System.out.println("Digite seu CPF:");
                                    a1.setCpf(scan.nextLine());
                                    System.out.println("Digite sua data de nascimento:");
                                    a1.setDataNasc(scan.nextLine());
                                    System.out.println("Digite a sua especialidade:");
                                    a1.setEspecialidade(scan.nextLine());
                                    System.out.println("Agora, digite sua senha para acessar o sistema:");
                                    a1.setSenha(scan.nextLine());
                                    a1.setTipo("personal");
                                    a1.setSalario(1200);
                                    a1.setBonus_por_aluno(0);
                                    a1.setQtd_aluno(0);
                                    Cadastro cad_per = new Cadastro();
                                    cad_per.inserir(a1);
                                } catch (Exception e) {
                                    System.out.println("Erro ao cadastrar personal: " + e.getMessage());
                                    e.printStackTrace(); //exibir informações detalhadas sobre uma exceção 
                                }

                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opcao invalida");
                                ;
                        }
                    }

                } else if (opc_principal == 2) {
                    System.out.println("Email:");
                    String email_ver = scan.nextLine();
                    System.out.println("Senha:");
                    String senha_vre = scan.nextLine();
                    String met = metodos.logar(email_ver, senha_vre);
                    int id = metodos.retornoID(email_ver);// metodo do id

                    switch (met) {
                        case "aluno":
                            int opc_aluno = 0;
                            while (opc_aluno != 6) {
                                metodos.menuAluno();
                                opc_aluno = scan.nextInt();
                                scan.nextLine();

                                if (opc_aluno == 1) {
                                    metodos.opcPlanos();
                                    int opc_plano = scan.nextInt();
                                    scan.nextLine();

                                    if (opc_plano == 1) {
                                        System.out.println("Tem Certeza que deseja contratar o Plano Comum? Digite S para sim e N para nao:");
                                        String op1 = scan.nextLine();

                                        if (op1.equalsIgnoreCase("s")) {
                                            int id_aluno = metodos.obterIdAluno(id);
                                            metodos.contratarPlano(id_aluno);
                                        } else {
                                            System.out.println("saindo...");

                                        }

                                    } else if (opc_plano == 2) {
                                        System.out.println("Tem Certeza que deseja contratar o Plano Premium? Digite S para sim e N para nao:");
                                        String op1 = scan.nextLine();

                                        if (op1.equalsIgnoreCase("s")) {
                                            System.out.println("Escolha seu Personal: ");
                                            metodos.listarPersonal();
                                            System.out.println("Digite o nome completo do seu personal: ");
                                            String nome_personal = scan.nextLine();
                                            int id_personal = metodos.obterIdPersonal(nome_personal);
                                            int id_aluno = metodos.obterIdAluno(id);
                                            double valor = 100;
                                            String nome = "Plano Premium";
                                            int duracao = 3;
                                            int qtd_alunos = metodos.descobrirQTDalunos(nome_personal);
                                            metodos.contratarPlano(id_aluno, id_personal, valor, duracao, nome, qtd_alunos);

                                        } else {
                                            System.out.println("saindo...");

                                        }

                                    } else if (opc_plano == 3) {
                                        System.out.println("Tem Certeza que deseja contratar o Plano Premium Plus? Digite S para sim e N para nao:");
                                        String op1 = scan.nextLine();

                                        if (op1.equalsIgnoreCase("s")) {
                                            System.out.println("Escolha seu Personal: ");
                                            metodos.listarPersonal();
                                            System.out.println("Digite o nome completo do seu personal: ");
                                            String nome_personal = scan.nextLine();
                                            int id_personal = metodos.obterIdPersonal(nome_personal);
                                            int id_aluno = metodos.obterIdAluno(id);
                                            double valor = 90;
                                            String nome = "Plano Premium Plus";
                                            int duracao = 12;
                                            int qtd_alunos = metodos.descobrirQTDalunos(nome_personal);
                                            metodos.contratarPlano(id_aluno, id_personal, valor, duracao, nome, qtd_alunos);

                                        } else {
                                            System.out.println("saindo...");

                                        }

                                    } else {
                                        System.out.println("Opcao invalida tente novamente");
                                    }

                                } else if (opc_aluno == 2) {

                                } else if (opc_aluno == 3) { //Opc Pagamento
                                    System.out.println("Tem Certeza que deseja realizar um pagamento? Digite S para sim e N para nao:");
                                    String op1 = scan.nextLine();

                                    if (op1.equalsIgnoreCase("s")) {
                                        System.out.println("-------------------PAGAMENTO--------------------");
                                        System.out.println("Digite por favor o valor que voce deseja pagar: ");
                                        double valor = scan.nextDouble();
                                        scan.nextLine();
                                        String desc = "Mensalidade";
                                        metodos.fazerPagamentos(id, valor, desc);

                                    } else {
                                        System.out.println("saindo...");

                                    }

                                } else if (opc_aluno == 4) {
                                    Alterar novosMetodos = new Alterar();
                                    Aluno aluno = metodos.buscarAlunoPorId(id);

                                    boolean continuarAlterando = true;

                                    while (continuarAlterando) {
                                        System.out.println("--------ALTERAÇÃO DE DADOS--------");
                                        System.out.println("1. Alterar Nome                   ");
                                        System.out.println("2. Alterar CPF                    ");
                                        System.out.println("3. Alterar Email                  ");
                                        System.out.println("4. Alterar Senha                  ");
                                        System.out.println("0. Salvar Alterações/Sair         ");
                                        System.out.print("Escolha uma opção: ");
                                        int escolha = scan.nextInt();
                                        scan.nextLine();

                                        switch (escolha) {
                                            case 1:
                                                System.out.println("Digite o nome que deseja alterar: ");
                                                aluno.setNome(scan.nextLine());
                                                break;
                                            case 2:
                                                System.out.println("Digite o novo CPF que deseja colocar:");
                                                aluno.setCpf(scan.nextLine());
                                                break;
                                            case 3:
                                                System.out.println("Digite o novo email: ");
                                                aluno.setEmail(scan.nextLine());
                                                break;
                                            case 4:
                                                System.out.println("Digite a nova senha para realizar a atualização:");
                                                aluno.setSenha(scan.nextLine());
                                                break;
                                            case 0:
                                                novosMetodos.alterarAluno(aluno);
                                                System.out.println("Dados alterados com sucesso!");
                                                continuarAlterando = false;
                                                break;
                                        }

                                    }

                                } else if (opc_aluno == 5) {

                                } else if (opc_aluno == 6) {

                                } else {
                                    System.out.println("Opcao invalida");
                                }

                            }

                            break;

                        case "personal":
                            int opc_personal = 0;
                            while (opc_personal != 4) {
                                metodos.menuPersonal();
                                opc_personal = scan.nextInt();
                                scan.nextLine();

                                if (opc_personal == 1) {
                                    
                                    int idPersonal = Metodos.retornoID(email_ver);
                                    metodos.listarAlunos(idPersonal);

                                } else if (opc_personal == 2) {

                                    int idPersonal = Metodos.retornoID(email_ver);
                                    metodos.salarioPersonal(idPersonal);
                                    
                                } else if (opc_personal == 3) {
                                    
                                    int idPersonal = Metodos.retornoID(email_ver);
                                    Personal personal = metodos.buscarPersonalPorID(idPersonal);
                                    
                                    if (personal != null) {
                                        
                                        boolean alterando = true;
                                        
                                        while (alterando) {
                                            System.out.println("\n--- Escolha o campo que deseja alterar ---");
                                            System.out.println("1. Nome");
                                            System.out.println("2. CPF");
                                            System.out.println("3. Email");
                                            System.out.println("4. Data de Nascimento");
                                            System.out.println("5. Senha");
                                            System.out.println("6. Especialidade");
                                            System.out.println("7. Confirmar alterações");
                                            System.out.println("8. Cancelar");

                                            int escolha = scan.nextInt();
                                            scan.nextLine(); // limpar buffer

                                            switch (escolha) {
                                                case 1:
                                                    System.out.print("Novo nome: ");
                                                    personal.setNome(scan.nextLine());
                                                    break;
                                                case 2:
                                                    System.out.print("Novo CPF: ");
                                                    personal.setCpf(scan.nextLine());
                                                    break;
                                                case 3:
                                                    System.out.print("Novo email: ");
                                                    personal.setEmail(scan.nextLine());
                                                    break;
                                                case 4:
                                                    System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
                                                    personal.setDataNasc(scan.nextLine());
                                                    break;
                                                case 5:
                                                    System.out.print("Nova senha: ");
                                                    personal.setSenha(scan.nextLine());
                                                    break;
                                                case 6:
                                                    System.out.print("Nova especialidade: ");
                                                    personal.setEspecialidade(scan.nextLine());
                                                    break;
                                                case 7:
                                                    Alterar.alterarPersonal(personal);
                                                    alterando = false;
                                                    break;
                                                case 8:
                                                    System.out.println("Alteração cancelada.");
                                                    alterando = false;
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida.");
                                            }
                                        }
                                    } else {
                                        System.out.println("Personal não encontrado.");
                                    }

                                } else if (opc_personal == 4) {
                                    
                                    System.out.println("Saindo do menu de personal...");

                                } else {
                                    System.out.println("Opcao invalida");
                                }

                            }                           
                            break;

                        case "adm":
                            metodos.menuADM(id);
                            break;

                        default:
                            System.out.println("Falha no login tente novamente");

                    }

                } else if (opc_principal == 3) {

                    System.out.println("Obrigado por utilizar nosso sistema <3 ");
                } else {
                    System.out.println("Digite uma opcao valida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scan.next(); // Limpa o buffer do scanner para evitar um loop infinito
            }
        }

    }
}
