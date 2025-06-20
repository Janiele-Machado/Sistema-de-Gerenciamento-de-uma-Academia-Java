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

    public static String geradorMatricula() { //Método que gera a matricula do aluno
        Random rand = new Random();

        // Gera os primeiros 4 dígitos (entre 1000 e 9999)
        int primeiraParte = 1000 + rand.nextInt(9000);

        // Gera os segundos 4 dígitos (entre 1000 e 9999)
        int segundaParte = 1000 + rand.nextInt(9000);

        return "MAT" + String.valueOf(primeiraParte) + String.valueOf(segundaParte); //retorna a matricula gerada;
    }

    //Método principal que efetua a execução do sistema 
   /*
 public static void main(String[] args) throws SQLException, Exception {
        Metodos metodos = new Metodos();
        Scanner scan = new Scanner(System.in);
        int opc_principal = 0;

        while (opc_principal != 3) {
            try {
                metodos.menuPrincipal(); //chama o menu principal
                opc_principal = scan.nextInt();
                scan.nextLine();

                if (opc_principal == 1) { //Opção Cadastro
                    int opc_cadastro = 0;
                    while (opc_cadastro != 4) {

                        metodos.menuCadastro();//chama o menu cadastro que contem as opções de cadastro no sistema
                        opc_cadastro = scan.nextInt();
                        scan.nextLine();

                        switch (opc_cadastro) { //Cadastro Aluno
                            case 1: //Cadastro Aluno
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
                                    System.out.println("Erro ao cadastrar aluno: " + e.getMessage()); //mensagem de erro caso não consiga cadastrar um aluno
                                    e.printStackTrace();//exibir informações detalhadas sobre uma exceção 
                                }

                                break;
                            case 2: //Cadastro Adm
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
                                    a1.setSalario(1500);//como regra de negocio colocamos como padrao o valor do salario de adm
                                    Cadastro cad_adm = new Cadastro();
                                    cad_adm.inserir(a1);
                                } catch (Exception e) {
                                    System.out.println("Erro ao cadastrar adm: " + e.getMessage());
                                    e.printStackTrace(); //exibir informações detalhadas sobre uma exceção 
                                }
                                break;
                            case 3: //Cadastro Personal
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
                                    a1.setSalario(1200);//como regra de negocio colocamos como padrao o valor do salario de personal
                                    a1.setBonus_por_aluno(0);
                                    a1.setQtd_aluno(0);
                                    Cadastro cad_per = new Cadastro();
                                    cad_per.inserir(a1);
                                } catch (Exception e) {
                                    System.out.println("Erro ao cadastrar personal: " + e.getMessage());
                                    e.printStackTrace(); //exibir informações detalhadas sobre uma exceção 
                                }

                                break;
                                    
                            case 4 :
                                System.out.println("Saindo...");//opc para o usuario sair e encerrar a execução
                                break;
                            default:
                                System.out.println("Opcao invalida"); // para o caso dele inserir uma opc invalida

                        }
                    }

                } else if (opc_principal == 2) { //Opção Logar
                    System.out.println("Email:");
                    String email_ver = scan.nextLine();
                    System.out.println("Senha:");
                    String senha_vre = scan.nextLine();
                    String met = metodos.logar(email_ver, senha_vre);
                    int id = metodos.retornoID(email_ver);// metodo do id

                    switch (met) {
                        case "aluno":
                            int opc_aluno = 0;
                            while (opc_aluno != 7) {
                                metodos.menuAluno(); //chama o menu com as opções de aluno
                                opc_aluno = scan.nextInt();
                                scan.nextLine();

                                if (opc_aluno == 1) {
                                    metodos.opcPlanos(); //Opção de cadastro de planos
                                    int opc_plano = scan.nextInt();
                                    scan.nextLine();

                                    if (opc_plano == 1) {
                                        System.out.println("Tem Certeza que deseja contratar o Plano Comum? Digite S para sim e N para nao:");
                                        String op1 = scan.nextLine();

                                        if (op1.equalsIgnoreCase("s")) {
                                            int id_aluno = metodos.obterIdAluno(id); //chama um metodo que recebe o id de usuario que é também uma chave estrangeira e retorno o id do aluno;
                                            metodos.contratarPlano(id_aluno);
                                        } else {
                                            System.out.println("saindo...");

                                        }

                                    } else if (opc_plano == 2) {
                                        System.out.println("Tem Certeza que deseja contratar o Plano Premium? Digite S para sim e N para nao:");
                                        String op1 = scan.nextLine();

                                        if (op1.equalsIgnoreCase("s")) {
                                            System.out.println("Escolha seu Personal: ");
                                            metodos.listarPersonal(); //chama um método que faz um select e mostra todos os personais cadastrados
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
                                    metodos.verPlano(id);
                                } else if (opc_aluno == 3) { //Essa funcionalidade tem o objetivo de apenas registrar o valor de pagamento do aluno para fins de relatórios financeiros, ele não realmente realiza pagamentos 
                                    System.out.println("Tem Certeza que deseja registrar um pagamento? Digite S para sim e N para nao:");
                                    String op1 = scan.nextLine();

                                    if (op1.equalsIgnoreCase("s")) {
                                        System.out.println("-------------------REGISTRAR PAGAMENTO--------------------");
                                        System.out.println("Digite por favor o valor que voce deseja registrar: ");
                                        double valor = scan.nextDouble();
                                        scan.nextLine();
                                        String desc = "Mensalidade";
                                        metodos.fazerPagamentos(id, valor, desc);

                                    } else {
                                        System.out.println("saindo...");

                                    }

                                } else if (opc_aluno == 4) { // opc atualização de cadastro

                                    System.out.println("Tem Certeza que deseja alterar seu cadastro? Digite S para sim e N para nao:");
                                    String op1 = scan.nextLine();
                                    if (op1.equalsIgnoreCase("s")) {
                                        Aluno a1 = new Aluno();
                                        a1.setId(id);
                                        System.out.println("Ola, Insira os dados pra prosseguir com sua atualizacao do cadastro:");
                                        System.out.println("Digite seu nome Completo:");
                                        a1.setNome(scan.nextLine());
                                        System.out.println("Digite seu Email:");
                                        a1.setEmail(scan.nextLine());
                                        System.out.println("Digite seu Objetivo:");
                                        a1.setObjetivo(scan.nextLine());
                                        System.out.println("Agora, digite sua senha para acessar o sistema:");
                                        a1.setSenha(scan.nextLine());
                                        Alterar alt_aluno = new Alterar();
                                        alt_aluno.alterarAluno(a1);

                                    } else {
                                        System.out.println("saindo...");

                                    }

                                } else if (opc_aluno == 5) {// opc desativar a assinatura
                                    System.out.println("Tem certeza que deseja desativar sua assinatura? Digite S para sim e N para nao:");
                                    String resposta = scan.nextLine();
                                    if (resposta.equalsIgnoreCase("s")) {
                                        metodos.desativarPlano(id); //chama o método que desativa o plano
                                    } else {
                                        System.out.println("Assinatura mantida.");
                                    }
                                } else if (opc_aluno == 6) { // opc reativar a assinatura

                                    System.out.println("Voce deseja reativar seu plano anterior? Digite S para sim ou N para nao:");
                                    String resposta = scan.nextLine();

                                    if (resposta.equalsIgnoreCase("s")) {
                                        metodos.reativarPlano(id); // Chama o método que criamos para reativar o plano
                                    } else {
                                        System.out.println("Reativacao cancelada.");
                                    }
                                }
                            else if (opc_aluno == 7) {
                                    System.out.println("saindo...");
                                } else {
                                    System.out.println("Opcao invalida");
                                }

                    }

                    break;

                
            case "personal":
                            int opc_personal = 0;
                            while (opc_personal != 4) {
                                metodos.menuPersonal();//chama o menu de opcoes de personal
                                opc_personal = scan.nextInt();
                                scan.nextLine();

                                if (opc_personal == 1) { //lista os alunos de personal
                                    int id_per = metodos.obterIdPersonal(id);
                                    metodos.listarAlunos(id_per);

                                } else if (opc_personal == 2) {

                                    int id_per = metodos.obterIdPersonal(id);
                                    metodos.salarioPersonal(id_per);//mostra o salario do personal

                                } else if (opc_personal == 3) {//atualiza o cadastro de personal
                                    System.out.println("Tem Certeza que deseja alterar seu cadastro? Digite S para sim e N para nao:");
                                    String op1 = scan.nextLine();
                                    if (op1.equalsIgnoreCase("s")) {
                                        Personal a1 = new Personal();
                                        a1.setId(id);
                                        System.out.println("Ola, Insira os dados pra prosseguir com sua atualização do cadastro:");
                                        System.out.println("Digite seu nome Completo:");
                                        a1.setNome(scan.nextLine());
                                        System.out.println("Digite seu Email:");
                                        a1.setEmail(scan.nextLine());
                                        System.out.println("Agora, digite sua especialidade:");
                                        a1.setEspecialidade(scan.nextLine());
                                        System.out.println("Agora, digite sua senha para acessar o sistema:");
                                        a1.setSenha(scan.nextLine());
                                        Alterar alt_per = new Alterar();
                                        alt_per.alterarPersonal(a1);
                                    } else {
                                        System.out.println("saindo...");

                                    }

                                } else if (opc_personal == 4) {

                                    System.out.println("Saindo do menu de personal...");

                                } else {
                                    System.out.println("Opcao invalida");
                                }

                            }
                            break;

                        case "adm":
                            metodos.menuADM(id); //chama o menu de adm que contem as suas opcoes e as funçoes que executam as funcionalidades 
                            break;

                        default:
                            System.out.println("Falha no login tente novamente");

                    }

                } else if (opc_principal == 3) {

                    System.out.println("Obrigado por utilizar nosso sistema <3 ");
                } else {
                    System.out.println("Digite uma opcao valida");
                }
        }catch (InputMismatchException e) { //tratamento para o caso do usuario iserir uma letra no campo inteiro 
                System.out.println("Entrada invalida. Por favor, digite um numero inteiro.");
                scan.next(); // Limpa o buffer do scanner para evitar um loop infinito
            }
    }

}*/

}
