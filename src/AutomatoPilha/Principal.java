
package AutomatoPilha;

public class Principal {

    public static void main(String[] args) {
       String local = "/home/renan/Desktop/Linguagens Formais/teste01.txt";
       LeituraArquivo leitura = new LeituraArquivo();
       
       leitura.leituraArquivo(local);
    }
    
}
