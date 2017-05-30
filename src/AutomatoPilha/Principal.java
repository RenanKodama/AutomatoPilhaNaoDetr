package AutomatoPilha;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Arquivos para teste: ");
        
        System.out.println(""
                + "\tex5.5a.txt    \n"
                + "\tex5.5b.txt    \n"
                + "\tex5.5c.txt    \n"
                + "*\tex5.5d.txt    \n"
                + "\tex5.5e.txt    \n"
                + "\tex5.5f.txt    \n");
        
        System.out.print("Arq: ");
        String local = entrada.nextLine();
        
        
        Automato automato = new Automato();
        automato.gerarAutomato("Testes/"+local);

    }

}
