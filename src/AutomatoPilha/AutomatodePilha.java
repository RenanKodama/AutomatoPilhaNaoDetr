package AutomatoPilha;

import java.util.ArrayList;
import java.util.Collections;

public class AutomatodePilha {

    ArrayList<Automato> possibilidades;

    public boolean computarAutomato(Automato automato) {
        AutomatodePilha automatoPilha = new AutomatodePilha();
        automatoPilha.setPossibilidades(new ArrayList<>());
        automatoPilha.getPossibilidades().add(automato);

        while (!automatoPilha.getPossibilidades().isEmpty()) {
            Automato automato_atual = automatoPilha.getPossibilidades().remove(0);

            //System.out.println("Pilha: " + automato_atual.getPilha().toString());
            //System.out.println("Possibilidades: " + automatoPilha.getPossibilidades().size());
            if (!automato_atual.getEstadoInicial().isEmpty()) {

                String estado = automato_atual.getEstadoInicial().remove(0);
                String gatilho;
                String topoPilha;

                if (automato_atual.getAlfabetoEntrada().isEmpty()) {
                    gatilho = "#";
                } else {
                    gatilho = automato_atual.getAlfabetoEntrada().remove(0);
                }

                if (automato_atual.getAlfabetoEntrada().isEmpty() && automato_atual.getEstadosAceitacao().contains(estado) || automato_atual.getPilha().isEmpty()) {
                    return true;
                }

                topoPilha = automato_atual.getPilha().remove(0);

                for (Vertice v : automato_atual.getMap().get(estado)) {
                    if (v.getSimboloDest().equals(gatilho) && v.getSimbolotopo().equals(topoPilha)) {
                        Automato automato02 = automato_atual;

                        if (!v.getSimboloEmpilhar().equals("#")) {
                            for (char c : v.getSimboloEmpilhar().toCharArray()) {
                                automato02.getPilha().add(Character.toString(c));
                            }
                            if (automato02.getPilha().get(0).equals("Z")) {
                                Collections.reverse(automato02.getPilha());
                            }
                        }

                        ArrayList<String> aux = new ArrayList<>();
                        aux.add(v.getNext());
                        automato02.setEstadoInicial(aux);
                        automatoPilha.getPossibilidades().add(automato02);
                    }
                }
                adicionaClosures(automatoPilha, estado, automato_atual);
            }
        }

        return false;
    }

    public void adicionaClosures(AutomatodePilha possibilidades, String estado, Automato automato_atual) {
        for (Vertice v : automato_atual.getMap().get(estado)) {
            if (v.getSimboloDest().equals("#") && v.getSimbolotopo().equals("#")) {
                Automato novoAutomato = automato_atual;

                ArrayList<String> aux = new ArrayList<>();
                aux.add(v.getNext());
                automato_atual.setEstadoInicial(aux);
                possibilidades.getPossibilidades().add(novoAutomato);
                adicionaClosures(possibilidades, v.getNext(), automato_atual);
            }
        }
    }

    public ArrayList<Automato> getPossibilidades() {
        return possibilidades;
    }

    public void setPossibilidades(ArrayList<Automato> possibilidades) {
        this.possibilidades = possibilidades;
    }

}
