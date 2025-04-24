package Academia;

/**
 *
 * @author Janiele
 */
public class Metodos {

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

}
