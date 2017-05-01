
package AutomatoPilha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class LeituraArquivo {
    public void pularLinhas(int num,BufferedReader lerArq) throws IOException{
        for (int i = 0; i < (num-1); i++) {
            lerArq.readLine();
        }
    }
    
    public void leituraArquivo(String local){
        try {
            AutomatoLeitura info = new AutomatoLeitura();
            String linha;
            String[] aux;
            FileReader arq = new FileReader(local);
            BufferedReader lerArq = new BufferedReader(arq);
            
            pularLinhas(5,lerArq);
            linha = lerArq.readLine();          //linha06 alfabeto de entrada
            aux = linha.split(" ");
            info.setAlfabetoEntrada(aux);
            
            pularLinhas(1,lerArq);
            linha = lerArq.readLine();          //linha07 alfabeto da pilha
            aux = linha.split(" ");
            info.setAlfabetoPilha(aux);
            
            pularLinhas(1,lerArq);
            linha = lerArq.readLine();          //linha08 simbolo epsilon
            aux = linha.split(" ");
            info.setSimboloEpsilon(aux);
            
            pularLinhas(1,lerArq);
            linha = lerArq.readLine();          //linha09 simbolo inicial pilha
            aux = linha.split(" ");
            info.setSimboloInicialPilha(aux);            
            
            pularLinhas(1,lerArq);
            linha = lerArq.readLine();          //linha10 conjunto estados
            aux = linha.split(" ");
            info.setConjuntoEstados(aux);
            
            pularLinhas(1,lerArq);
            linha = lerArq.readLine();          //linha11 estado inicial
            aux = linha.split(" ");
            info.setEstadoInicial(aux);
            
            pularLinhas(1,lerArq);
            linha = lerArq.readLine();          //linha12 conjunto estados aceitaçao
            aux = linha.split(" ");
            info.setEstadosAceitacao(aux);
            
            pularLinhas(1,lerArq);              //linha13 to end transiçoes
            ArrayList<Transicoes> listEstados = new ArrayList();
            while (linha != null) {
                Transicoes tr = new Transicoes();
               
                aux = linha.split(" ");
                tr.setEstadoAtual(aux[0]);              //estado atual
                tr.setSimboloAtualPalavra(aux[1]);      //simbolo atual
                tr.setSomboloTopoPilha(aux[2]);         //simbolo topo
                tr.setNovoEstado(aux[3]);               //novo estado
                tr.setSimboloEmpilhar(aux[4]);          //empilhar simbolo
                
                listEstados.add(tr);
                linha = lerArq.readLine();
            }          
            arq.close();
            info.setTransicoes(listEstados);
            verTransicoes(info);
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        }
    }
    
    public void verTransicoes(AutomatoLeitura automato){
        System.out.println("AlfabetoEntrada: "+Arrays.toString(automato.getAlfabetoEntrada()));
        System.out.println("AlfabetoPilha: "+Arrays.toString(automato.getAlfabetoPilha()));
        System.out.println("SimboloEpsolon: "+Arrays.toString(automato.getSimboloEpsilon()));
        System.out.println("SimboloInicialPilha: "+Arrays.toString(automato.getSimboloInicialPilha()));
        System.out.println("ConjuntoEstados: "+Arrays.toString(automato.getConjuntoEstados()));
        System.out.println("EstadoInicial: "+Arrays.toString(automato.getEstadoInicial()));
        System.out.println("EstadosAceitaçao: "+Arrays.toString(automato.getEstadosAceitacao()));
        
        System.out.println("Transiçoes: ");
        
        for(Transicoes tr : automato.getTransicoes()){
            System.out.println("\t"+tr.getEstadoAtual()+" "
                    +tr.getSimboloAtualPalavra()+" "
                    +tr.getSomboloTopoPilha()+" "
                    +tr.getNovoEstado()+" "
                    +tr.getSimboloEmpilhar()
            );
        }
    }
}
