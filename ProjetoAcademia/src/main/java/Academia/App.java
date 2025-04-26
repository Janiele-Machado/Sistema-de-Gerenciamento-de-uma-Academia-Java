package Academia;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        Metodos metodos = new Metodos();
        Scanner scan = new Scanner(System.in);
        int opc_principal = 0;

        while (opc_principal != 3) {

            metodos.menuPrincipal();
            opc_principal = scan.nextInt();

            if (opc_principal == 1) {
                int opc_cadastro = 0;
                while (opc_cadastro != 4) {

                    metodos.menuCadastro();
                    opc_cadastro = scan.nextInt();
                }

            } else if (opc_principal == 2) {
                metodos.logar();
                

            } else if (opc_principal == 3) {

                System.out.println("Obrigado por utilizar nosso sistema <3 ");
            }
        }
    }
}
