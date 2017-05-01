
package AutomatoPilha;

public class Transicoes {
    private String estadoAtual;
    private String simboloAtualPalavra;
    private String somboloTopoPilha;
    private String novoEstado;
    private String simboloEmpilhar;

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public String getSimboloAtualPalavra() {
        return simboloAtualPalavra;
    }

    public void setSimboloAtualPalavra(String simboloAtualPalavra) {
        this.simboloAtualPalavra = simboloAtualPalavra;
    }

    public String getSomboloTopoPilha() {
        return somboloTopoPilha;
    }

    public void setSomboloTopoPilha(String somboloTopoPilha) {
        this.somboloTopoPilha = somboloTopoPilha;
    }

    public String getNovoEstado() {
        return novoEstado;
    }

    public void setNovoEstado(String novoEstado) {
        this.novoEstado = novoEstado;
    }

    public String getSimboloEmpilhar() {
        return simboloEmpilhar;
    }

    public void setSimboloEmpilhar(String simboloEmpilhar) {
        this.simboloEmpilhar = simboloEmpilhar;
    }

    
}
