package AutomatoPilha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Automato {

    private ArrayList<String> alfabetoEntrada;
    private ArrayList<String> alfabetoPilha;
    private String simboloEpsilon;
    private String simboloInicialPilha;
    private ArrayList<String> conjuntoEstados;
    private ArrayList<String> estadoInicial;
    private ArrayList<String> estadosAceitacao;

    private HashMap<String, ArrayList<Vertice>> map = new HashMap<>();
    private ArrayList<String> pilha;

    public Automato() {
        this.alfabetoEntrada = new ArrayList<>();
        this.alfabetoPilha = new ArrayList<>();
        this.conjuntoEstados = new ArrayList<>();
        this.estadoInicial = new ArrayList<>();
        this.estadosAceitacao = new ArrayList<>();
    }

    
    public void gerarAutomato(String local) {
        Automato auto = new Automato();
        LeituraArquivo automatoLeitura = LeituraArquivo.leituraArquivo(local);
        
        auto.getAlfabetoEntrada().addAll(Arrays.asList(automatoLeitura.getAlfabetoEntrada()));      //adicionar AlfabetoEntrada
        auto.getAlfabetoPilha().addAll(Arrays.asList(automatoLeitura.getAlfabetoPilha()));          //adicionar AlfabetPilha
        auto.setSimboloEpsilon(automatoLeitura.getSimboloEpsilon()[0]);                             //Adicionar SimboloEpsolon
        auto.setSimboloInicialPilha(automatoLeitura.getSimboloInicialPilha()[0]);                   //Adicionar SimboloInicialPilha
        auto.getConjuntoEstados().addAll(Arrays.asList(automatoLeitura.getConjuntoEstados()));      //Adicionar ConjuntosEstados
        auto.getEstadoInicial().addAll(Arrays.asList(automatoLeitura.getEstadoInicial()));          //Adicionar EstadoInicial
        auto.getEstadosAceitacao().addAll(Arrays.asList(automatoLeitura.getEstadosAceitacao()));    //Adicionar EstadosAceitçao

        //adicionando keys Origem 
        for (Transicoes str : automatoLeitura.getTransicoes()) {
            ArrayList<Vertice> vertice = new ArrayList<>();
            auto.getMap().put(str.getEstadoAtual(), vertice);
        }
        //adicionando keys Destino 
        for (Transicoes str : automatoLeitura.getTransicoes()) {
            ArrayList<Vertice> vertice = new ArrayList<>();
            auto.getMap().put(str.getNovoEstado(), vertice);
        }

        //adicionando destinos aos keys
        for (Transicoes str : automatoLeitura.getTransicoes()) {
            Vertice vr = new Vertice();

            vr.setNext(str.getNovoEstado());
            vr.setSimboloDest(str.getSimboloAtualPalavra());
            vr.setSimboloEmpilhar(str.getSimboloEmpilhar());
            vr.setSimbolotopo(str.getSomboloTopoPilha());

            auto.getMap().get(str.getEstadoAtual()).add(vr);
        }

        //marcando os estados finais
        for (ArrayList<Vertice> vr : auto.getMap().values()) {
            for (int i = 0; i < vr.size(); i++) {
                if (auto.getEstadosAceitacao().contains(vr.get(i).getNext())) {
                    vr.get(i).setIsFinal(true);
                }
            }
        }
        
        auto.setPilha(new ArrayList<>());
        auto.getPilha().add(auto.getSimboloInicialPilha());
        
        verAutomato(auto);
        
        AutomatodePilha a = new AutomatodePilha();
        
        if(a.computarAutomato(auto)){
            System.out.println("Automato Aceitado");
        }
        else{
            System.out.println("Automato Rejeitado");
        }
        
    }

    public void verAutomato(Automato automato) {
        System.out.println("AlfabetoEntrada: " + (automato.getAlfabetoEntrada().toString()));
        System.out.println("AlfabetoPilha: " + (automato.getAlfabetoPilha().toString()));
        System.out.println("SimboloEpsolon: " + (automato.getSimboloEpsilon()));
        System.out.println("SimboloInicialPilha: " + (automato.getSimboloInicialPilha()));
        System.out.println("ConjuntoEstados: " + (automato.getConjuntoEstados().toString()));
        System.out.println("EstadoInicial: " + (automato.getEstadoInicial().toString()));
        System.out.println("EstadosAceitaçao: " + (automato.getEstadosAceitacao()));

        System.out.println("Transiçoes: ");

        for (String s : automato.getMap().keySet()) {
            System.out.print("\t" + s + "->  ");
            for (Vertice v : automato.getMap().get(s)) {
                System.out.print("<"+v.getSimboloDest()+","+v.getSimbolotopo()+","+v.getNext()+","+v.getSimboloEmpilhar()+","+v.isFinal()+">  ");
            }
            System.out.println();
        }

    }

    public ArrayList<String> getAlfabetoEntrada() {
        return alfabetoEntrada;
    }

    public void setAlfabetoEntrada(ArrayList<String> alfabetoEntrada) {
        this.alfabetoEntrada = alfabetoEntrada;
    }

    public ArrayList<String> getAlfabetoPilha() {
        return alfabetoPilha;
    }

    public void setAlfabetoPilha(ArrayList<String> alfabetoPilha) {
        this.alfabetoPilha = alfabetoPilha;
    }

    public String getSimboloEpsilon() {
        return simboloEpsilon;
    }

    public void setSimboloEpsilon(String simboloEpsilon) {
        this.simboloEpsilon = simboloEpsilon;
    }

    public String getSimboloInicialPilha() {
        return simboloInicialPilha;
    }

    public void setSimboloInicialPilha(String simboloInicialPilha) {
        this.simboloInicialPilha = simboloInicialPilha;
    }

    public ArrayList<String> getConjuntoEstados() {
        return conjuntoEstados;
    }

    public void setConjuntoEstados(ArrayList<String> conjuntoEstados) {
        this.conjuntoEstados = conjuntoEstados;
    }

    public ArrayList<String> getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(ArrayList<String> estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public ArrayList<String> getEstadosAceitacao() {
        return estadosAceitacao;
    }

    public void setEstadosAceitacao(ArrayList<String> estadosAceitacao) {
        this.estadosAceitacao = estadosAceitacao;
    }

    public HashMap<String, ArrayList<Vertice>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, ArrayList<Vertice>> map) {
        this.map = map;
    }

    public ArrayList<String> getPilha() {
        return pilha;
    }

    public void setPilha(ArrayList<String> pilha) {
        this.pilha = pilha;
    }

}
