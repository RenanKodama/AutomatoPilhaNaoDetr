package AutomatoPilha;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeituraArquivo {
    private String[] alfabetoEntrada;
    private String[] alfabetoPilha;
    private String[] simboloEpsilon;
    private String[] simboloInicialPilha;
    private String[] conjuntoEstados;
    private String[] estadoInicial;
    private String[] estadosAceitacao;
    private ArrayList<Transicoes> transicoes;
    
    public static LeituraArquivo leituraArquivo(String local) {
        LeituraArquivo leitura = new LeituraArquivo();
        try {
            Scanner scanner = new Scanner(new FileReader(local));
            
            leitura.setAlfabetoEntrada(scanner.nextLine().split(" "));
            leitura.setAlfabetoPilha(scanner.nextLine().split(" "));
            leitura.setSimboloEpsilon(scanner.nextLine().split(" "));
            leitura.setSimboloInicialPilha(scanner.nextLine().split(" "));
            leitura.setConjuntoEstados(scanner.nextLine().split(" "));
            leitura.setEstadoInicial(scanner.nextLine().split(" "));
            leitura.setEstadosAceitacao(scanner.nextLine().split(" "));
            
            ArrayList<Transicoes> listEstados = new ArrayList();    
            
            String[] aux;
            
            while (scanner.hasNext()){
                Transicoes tr = new Transicoes();
                aux = scanner.nextLine().split(" ");

                tr.setEstadoAtual(aux[0]);              //estado atual
                tr.setSimboloAtualPalavra(aux[1]);      //simbolo atual
                tr.setSomboloTopoPilha(aux[2]);         //simbolo topo
                tr.setNovoEstado(aux[3]);               //novo estado
                tr.setSimboloEmpilhar(aux[4]);          //empilhar simbolo

                listEstados.add(tr);
            }
            leitura.setTransicoes(listEstados);  
            scanner.close();
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        return leitura;
    }

    public String[] getAlfabetoEntrada() {
        return alfabetoEntrada;
    }

    public void setAlfabetoEntrada(String[] alfabetoEntrada) {
        this.alfabetoEntrada = alfabetoEntrada;
    }

    public String[] getAlfabetoPilha() {
        return alfabetoPilha;
    }

    public void setAlfabetoPilha(String[] alfabetoPilha) {
        this.alfabetoPilha = alfabetoPilha;
    }

    public String[] getSimboloEpsilon() {
        return simboloEpsilon;
    }

    public void setSimboloEpsilon(String[] simboloEpsilon) {
        this.simboloEpsilon = simboloEpsilon;
    }

    public String[] getSimboloInicialPilha() {
        return simboloInicialPilha;
    }

    public void setSimboloInicialPilha(String[] simboloInicialPilha) {
        this.simboloInicialPilha = simboloInicialPilha;
    }

    public String[] getConjuntoEstados() {
        return conjuntoEstados;
    }

    public void setConjuntoEstados(String[] conjuntoEstados) {
        this.conjuntoEstados = conjuntoEstados;
    }

    public String[] getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String[] estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String[] getEstadosAceitacao() {
        return estadosAceitacao;
    }

    public void setEstadosAceitacao(String[] estadosAceitacao) {
        this.estadosAceitacao = estadosAceitacao;
    }

    public ArrayList<Transicoes> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(ArrayList<Transicoes> transicoes) {
        this.transicoes = transicoes;
    }
    
    
    
}
