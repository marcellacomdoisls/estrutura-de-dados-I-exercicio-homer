public class Main {
  public static void main(String[] args) {
    ListaEncadeadaDupla list = new ListaEncadeadaDupla();
    list.adicionar("Homer");
    list.adicionar("Marge");
    System.out.println(list.toString());

    list.setListaVazia();
    System.out.println(list.toString());

    list.adicionar("Homer");
    list.adicionarNoInicio("Bart");
    list.adicionar(1, "Moll");
    System.out.println(list.toString());

    list.setListaVazia();
    list.adicionar("Homer");
    list.adicionar("Bart");
    list.adicionarNoInicio("Lisa");
    System.out.println(list.toString());
    System.out.println(list.tamanho());

    list.setListaVazia();
    System.out.println(list.toString());
    list.adicionar("Homer");
    list.adicionar("Maggie");
    list.adicionar(0, "Bart");
    list.adicionar(1, "Marge");
    System.out.println(list.contem("Lisa"));

    list.setListaVazia();
    list.adicionarNoInicio("Homer");
    list.adicionarNoInicio("Bart");
    list.adicionar("Marge");
    list.adicionar(1, "Maggie");
    list.adicionarNoInicio("Ned Flanders");
    list.adicionar("Sr Burns");
    list.removerDoFim();
    System.out.println(list.toString());

    list.remover(1);
    System.out.println(list.contem("Marge"));
    System.out.println(list.contem("Homer"));
    System.out.println(list.contem("Bart"));
    System.out.println(list.contem("Maggie"));
    System.out.println(list.tamanho());

    System.out.println(list.toString());
    list.removerDoInicio();

    System.out.println(list.contem("Marge"));
    System.out.println(list.contem("Homer"));
    System.out.println(list.contem("Bart"));
    System.out.println(list.contem("Maggie"));
    System.out.println(list.tamanho());

    list.setListaVazia();

    System.out.println(list.toString());
  }
}