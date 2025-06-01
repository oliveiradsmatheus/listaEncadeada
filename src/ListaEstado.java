public class ListaEstado {
    private NoEstado inicio;
    private NoEstado fim;

    public void inicializar() {
        inicio = fim = null;
    }

    public void exibirEstados() {
        NoEstado aux = inicio;
        while (aux != null) {
            System.out.println(aux.getEstado());
            aux = aux.getProx();
        }
    }

    public void exibirCidades(String estado) {
        NoEstado aux = buscaEstado(estado);
        if (aux != null)
            if (aux.getListaCidades() != null)
                aux.getListaCidades().exibir();
            else
                System.out.println(estado + " não possui cidades cadastradas.");
    }

    public void inserirFinal(String estado, String cidade) {
        NoEstado aux = buscaEstado(estado);
        if (aux == null)
            if (inicio == null)
                inicio = fim = new NoEstado(estado);
            else {
                aux = new NoEstado(estado);
                fim.setProx(aux);
                fim = aux;
                aux.getListaCidades().inserirFinal(cidade);
            }
        else
            aux.getListaCidades().inserirFinal(cidade);
    }

    public void ordenar() { // Bubble sort
        NoEstado noA;
        ListaCidade listaA, listaB;
        String aux;
        int qtde = tamanho();
        while (qtde > 0) {
            noA = inicio;
            for (int i = 0; i < qtde - 1; i++) {
                if (noA.getEstado().compareToIgnoreCase(noA.getProx().getEstado()) > 0) {
                    aux = noA.getProx().getEstado();
                    noA.getProx().setEstado(noA.getEstado());
                    noA.setEstado(aux);
                    // Trocando as listas de cidades
                    listaA = noA.getListaCidades();
                    listaB = noA.getProx().getListaCidades();
                    noA.setListaCidades(listaB);
                    noA.getProx().setListaCidades(listaA);
                }
                noA = noA.getProx();
            }
            qtde--;
        }
    }

    public void ordenarCidades(String estado) {
        NoEstado aux = buscaEstado(estado);
        if (aux != null)
            aux.getListaCidades().ordenar();
    }

    public void limparListaCidades(String estado) {
        NoEstado aux = buscaEstado(estado);
        if (aux != null)
            aux.setListaCidades(null);
    }

    public void removerEstado(String estado) {
        NoEstado aux = buscaEstado(estado);
        if (aux != null)
            if (inicio == fim)
                inicio = fim = null;
            else if (aux == inicio)
                inicio = inicio.getProx();
            else if (aux == fim) {
                aux = inicio;
                while (aux.getProx() != fim)
                    aux = aux.getProx();
                aux.setProx(null);
                fim = aux;
            } else {
                NoEstado del = inicio;
                while (del.getProx() != aux)
                    del = del.getProx();
                del.setProx(aux.getProx());
            }
    }

    public void removerCidade(String estado, String cidade) {
        NoEstado aux = buscaEstado(estado);
        if (aux != null)
            aux.getListaCidades().remover(cidade);
    }

    public NoEstado buscaEstado(String estado) {
        NoEstado aux = inicio;
        while (aux != null && !estado.equalsIgnoreCase(aux.getEstado()))
            aux = aux.getProx();
        return aux;
    }

    public boolean verificaPar(String estado, String cidade) {
        NoEstado aux = buscaEstado(estado);
        if (aux != null) {
            return aux.getListaCidades().buscaCidade(cidade) != null;
        }
        return false;
    }

    public int tamanho() {
        int qtde = 0;
        NoEstado aux = inicio;
        while (aux != null) {
            qtde++;
            aux = aux.getProx();
        }
        return qtde;
    }

}