package Academia;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static String geradorMatricula() {
        Random rand = new Random();

        // Gera os primeiros 4 dígitos (entre 1000 e 9999)
        int primeiraParte = 1000 + rand.nextInt(9000);

        // Gera os segundos 4 dígitos (entre 1000 e 9999)
        int segundaParte = 1000 + rand.nextInt(9000);

        return "MAT" + String.valueOf(primeiraParte) + String.valueOf(segundaParte); //retorna a matricula gerada;
    }

    public static void main(String[] args) throws SQLException {
        Metodos metodos = new Metodos();
        Scanner scan = new Scanner(System.in);
        int opc_principal = 0;

        while (opc_principal != 3) {

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

                            } else if (opc_aluno == 2) {

                            } else if (opc_aluno == 3) {

                            } else if (opc_aluno == 4) {

                            } else if (opc_aluno == 5) {

                            } else if (opc_aluno == 6) {

                            } else {
                                System.out.println("Opcao invalida");
                            }

                        }

                        break;

                    case "personal":
                        int opc_personal = 0;
                        while (opc_personal != 6) {
                            metodos.menuPersonal();
                            opc_personal = scan.nextInt();
                            scan.nextLine();

                            if (opc_personal == 1) {

                            } else if (opc_personal == 2) {

                            } else if (opc_personal == 3) {

                            } else if (opc_personal == 4) {

                            } else {
                                System.out.println("Opcao invalida");
                            }
                            
                        }
                        
                        break;

                    case "adm":
                        metodos.menuADM();
                        break;

                    default:
                        System.out.println("Falha no login tente novamente");

                }

            } else if (opc_principal == 3) {

                System.out.println("Obrigado por utilizar nosso sistema <3 ");
            }
        }
    }
}
