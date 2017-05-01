
package AutomatoPilha;

import java.util.ArrayList;

public class AutomatoLeitura {
    private String[] alfabetoEntrada;
    private String[] alfabetoPilha;
    private String[] simboloEpsilon;        //"B" ou "epsilon"
    private String[] simboloInicialPilha;
    private String[] conjuntoEstados;
    private String[] estadoInicial;
    private String[] estadosAceitacao;
    
    private ArrayList<Transicoes> transicoes;

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