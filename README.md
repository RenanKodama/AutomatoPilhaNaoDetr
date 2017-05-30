# Automato Pilha Nao Deterministico
# UTFPR
# Renan Kodama Rodrigues 1602098

O projeto foi realizado utilizando a linguagem java por apresentar maior flexibilidade no
desenvolvimento do algoritmo. Foram implementados seis casos testes (5.5a ... 5.5f). Para 
executar o projeto basta usa -lo em uma IDE que suporta java. 
No terminal será solicitado a escolha do nome do arquivo "TXT" com base nas opções de escolha de arquivos de entrada. 
Para inserir um arquivo de teste novo, este deve estar contido no diretorio "/Testes". No projeto também se encontra 
o gerador de arquivos para o programa, este gerador foi modificado no intuito de transformar o simbolo "Epsilon" em um "#".
As entradas para os testes se encontram na primeira linha do arquivo "TXT".

As principais classes são:
    Principal: classe responsável por receber o nome do arquivo "TXT" e iniciar o programa.
    AutomatodePilha: classe responsável por retornar se uma dada palavra é aceita ou não.
    Transições: classe responsável por armazenar as transições do arquivo "TXT" em uma pré estrutura.
    Automato: classe reponsável por amazenar as transições da classe acima citada, estrutura final de uso.

Ideia do algoritmo:
    As transições contidas no arquivo "TXT" de entrada são armazenadas em uma estrutura de hashmap, onde os vertices
    são representados pelas "keys" do hashmap e seus valores referenciados são os vertices adjacentes ao vertice chave,
    ou seja são os vertices adjacentes as keys.
    Os "values" do hashmap são compostos por vetices, onde cada um deles tem as seguintes informações, "next(proxímo vertice alcançável)", 
    "simboloDest(simbolo que dispara a transição)", "simboloEmpilhar(simbolo que deve ser empilhado na pilha)", 
    "simbolotopo(simbolo que deve estar no topo da pilha para o disparo da transição)", "isfinal(marca se um dado vertice é final ou não)".
    O algoritmo é iniciado com apenas uma única possibilidade de caminho, começando no estado inicial e com um simbolo iniciado na pilha,
    para todo vertice adjacente ao vertice inicial verifique se o simbolo de entrada condiz com o "simboloDest" e se o "simbolotopo" é igual ao
    simbolo do topo da pilha do automato, se as condições forem aceitas é criado uma nova instância de automato e as configurações anteriores(como alfabeto
    de entrada, pilha, hashmap,etc) serão salvas para o novo automato e o processo é repetido novamente até não houver mais possibilidades de caminhos.
    Para cada estado novo é calculado o seu closure, onde para cada estado que possuir uma transição com Epsilon(representado por "#") será criado uma
    nova instância de automato onde este novo automato irá receber as mesmas configurações do automato anterior e seu estado inicial passará a ser o 
    "next" do estado corrente. Se não houver mais possibilidades e o alfabeto de entrada estiver vazio é verificado o estado em que parou, se este estado
    estiver contido no conjunto de estados finais então a palavra é aceita, caso contrário a palavra é rejeitada.
    O pedaço do codigo a seguir retrata a explicação a ideia citada:

    *Não está funcionando corretamente para o caso "ex5.5d.txt"

    public boolean computarAutomato(Automato automato) {
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
            if (v.getSimboloDest().equals("#") && v.getSimbolotopo().equals("#") && v.getSimboloEmpilhar().equals("#")) {
                Automato novoAutomato = automato_atual;

                ArrayList<String> aux = new ArrayList<>();
                aux.add(v.getNext());
                automato_atual.setEstadoInicial(aux);
                possibilidades.getPossibilidades().add(novoAutomato);
                adicionaClosures(possibilidades, v.getNext(), automato_atual);
            }
        }
    }
    
    
