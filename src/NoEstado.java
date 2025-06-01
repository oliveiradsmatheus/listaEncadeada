public class NoEstado {

    private String estado;
    private ListaCidade listaCidades;
    private NoEstado prox;

    public NoEstado(String estado) {
        this.estado = estado;
        listaCidades = new ListaCidade();
        prox = null;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ListaCidade getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(ListaCidade listaCidades) {
        this.listaCidades = listaCidades;
    }

    public NoEstado getProx() {
        return prox;
    }

    public void setProx(NoEstado prox) {
        this.prox = prox;
    }

}
