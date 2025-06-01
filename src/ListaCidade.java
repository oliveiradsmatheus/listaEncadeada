public class ListaCidade {

    private NoCidade inicio;
    private NoCidade fim;

    public void inicializar() {
        inicio = fim = null;
    }

    public void exibir() {
        NoCidade aux = inicio;
        while (aux != null) {
            System.out.println(aux.getCidade());
            aux = aux.getProx();
        }
    }

    public void inserirFinal(String cidade) {
        NoCidade aux = buscaCidade(cidade);
        if (aux == null)
            if (inicio == null)
                inicio = fim = new NoCidade(cidade);
            else {
                aux = new NoCidade(cidade);
                fim.setProx(aux);
                fim = aux;
            }
    }

    public void ordenar() { // Selection sort
        NoCidade noA = inicio, noB, menor;
        String aux = "";
        while (noA.getProx() != null) {
            menor = noA;
            noB = noA.getProx();
            while (noB != null) {
                if (noB.getCidade().compareToIgnoreCase(menor.getCidade()) < 0)
                    menor = noB;
                noB = noB.getProx();
            }
            aux = noA.getCidade();
            noA.setCidade(menor.getCidade());
            menor.setCidade(aux);
            noA = noA.getProx();
        }
    }

    public void remover(String cidade) {
        NoCidade aux = buscaCidade(cidade);
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
                NoCidade del = inicio;
                while (del.getProx() != aux)
                    del = del.getProx();
                del.setProx(aux.getProx());
            }
    }

    public NoCidade buscaCidade(String cidade) {
        NoCidade aux = inicio;
        while (aux != null && !cidade.equalsIgnoreCase(aux.getCidade()))
            aux = aux.getProx();
        return aux;
    }

}