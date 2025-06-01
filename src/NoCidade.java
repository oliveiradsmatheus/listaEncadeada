public class NoCidade {

    private String cidade;
    private NoCidade prox;

    public NoCidade(String cidade) {
        this.cidade = cidade;
        prox = null;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public NoCidade getProx() {
        return prox;
    }

    public void setProx(NoCidade prox) {
        this.prox = prox;
    }

}