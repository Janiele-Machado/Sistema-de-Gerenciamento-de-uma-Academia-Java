package Academia;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Scanner scan = new Scanner(System.in);
        int opc_principal = 0;
        
        while(opc_principal != 3){
            
            metodos.menuPrincipal();
            opc_principal = scan.nextInt();
            
            if (opc_principal == 1) {
                
            }else if (opc_principal == 2) {
                
            } else if (opc_principal == 3) {
                
                System.out.println("Obrigado por utilizar nosso sistema <3 ");
            }
        }
    }
}
