public class Main {
    public static void main(String[] args) {
        ListaEstado lista = new ListaEstado();

        lista.inserirFinal("Santa Catarina", "Blumenau");
        lista.inserirFinal("Santa Catarina", "Joinville");
        lista.inserirFinal("São Paulo", "Assis");
        lista.inserirFinal("São Paulo", "Marília");
        lista.inserirFinal("São Paulo", "Pres. Prudente");
        lista.inserirFinal("Maranhão", "São Luís");
        lista.inserirFinal("Paraná", "Apucarana");
        lista.inserirFinal("Paraná", "Londrina");
        lista.inserirFinal("Paraná", "Arapongas");
        lista.inserirFinal("Paraná", "Maringá");
        lista.inserirFinal("Paraná", "Curitiba");

        System.out.println("Estados:");
        lista.exibirEstados();
        lista.removerEstado("Maranhão");
        lista.ordenar();

        System.out.println("\nEstados após a ordenação e a remoção do Maranhão:");
        lista.exibirEstados();

        System.out.println("\nCidades do Paraná:");
        lista.exibirCidades("Paraná");
        lista.removerCidade("Paraná", "Curitiba");
        lista.ordenarCidades("Paraná");

        System.out.println("\nCidades após a ordenação e a remoção de Curitiba:");
        lista.exibirCidades("Paraná");

        if (lista.verificaPar("São Paulo", "Pres. Prudente"))
            System.out.println("\nPres. Prudente está inserido em São Paulo");
        else
            System.out.println("\nPres. Prudente não foi encontrado em São Paulo");

        System.out.println("Limpando todas as cidades de Santa Catarina:");
        lista.limparListaCidades("Santa Catarina");
        System.out.println("\nCidades de Santa Catarina:");
        lista.exibirCidades("Santa Catarina");
    }
}