
public class ListaEncadeadaDupla {
  CelulaEncadeadaDupla primeira, ultima;
  int tamanho = 0;

  public boolean posicaoVazia(int posicao) {
    return ((posicao >= 0) && (posicao < tamanho));
  }

  CelulaEncadeadaDupla getPosicao(int posicao) {
    if (!this.posicaoVazia(posicao)) {
      throw new IllegalArgumentException("Índice inválido para obter a posição");
    } else {
      CelulaEncadeadaDupla celulaAtual = this.primeira;

      for (int i = 0; i < posicao; i++) {
        celulaAtual = celulaAtual.getProximo();
      }

      return celulaAtual;
    }
  }

  Object get(int posicao) {
    return (this.getPosicao(posicao)).getElemento();
  }

  void adicionarNoInicio(Object elemento) {
    if (this.tamanho == 0) {
      CelulaEncadeadaDupla novaCelula = new CelulaEncadeadaDupla(elemento);
      this.primeira = novaCelula;
      this.ultima = novaCelula;
    } else {
      CelulaEncadeadaDupla novaCelula = new CelulaEncadeadaDupla(this.primeira, elemento);
      this.primeira.setAnterior(novaCelula);
      this.primeira = novaCelula;
    }

    this.tamanho++;
  }

  void adicionar(Object elemento) {
    if (this.tamanho == 0) {
      this.adicionarNoInicio(elemento);
    } else {
      CelulaEncadeadaDupla novaCelula = new CelulaEncadeadaDupla(elemento);
      this.ultima.setProximo(novaCelula);
      novaCelula.setAnterior(this.ultima);
      this.ultima = novaCelula;
      this.tamanho++;
    }
  }

  void adicionar(int posicao, Object elemento) {
    if (posicao == 0) {
      this.adicionarNoInicio(elemento);
    } else if (posicao == tamanho) {
      this.adicionar(elemento);
    } else {
      CelulaEncadeadaDupla anterior = this.getPosicao(posicao - 1);
      CelulaEncadeadaDupla proxima = anterior.getProximo();
      CelulaEncadeadaDupla novaCelula = new CelulaEncadeadaDupla(anterior.getProximo(), elemento);
      novaCelula.setAnterior(anterior);
      anterior.setProximo(novaCelula);
      proxima.setAnterior(novaCelula);
      this.tamanho++;
    }
  }

  void removerDoInicio() {
    if (!this.posicaoVazia(0)) {
      throw new IllegalStateException("Esta lista está vazia");
    } else {
      this.primeira = this.primeira.getProximo();
      this.tamanho--;
    }

    if (this.tamanho == 0) {
      this.ultima = null;
    }
  }

  void removerDoFim() {
    if (!this.posicaoVazia(this.tamanho - 1)) {
      throw new IllegalStateException("Esta lista está vazia");
    } else {
      if (this.tamanho == 1) {
        this.removerDoInicio();
      } else {
        CelulaEncadeadaDupla penultimaCelula = this.ultima.getAnterior();
        penultimaCelula.setProximo(null);
        this.ultima = penultimaCelula;
        this.tamanho--;
      }
    }
  }

  void remover(int posicao) {
    if (!this.posicaoVazia(posicao)) {
      throw new IllegalArgumentException("Posição inexistente");
    } else {
      if (posicao == 0) {
        this.removerDoInicio();
      } else if (posicao == this.tamanho - 1) {
        this.removerDoFim();
      } else {
        CelulaEncadeadaDupla anterior = this.getPosicao(posicao - 1);
        CelulaEncadeadaDupla celulaAtual = anterior.getProximo();
        CelulaEncadeadaDupla proxima = celulaAtual.getProximo();
        anterior.setProximo(proxima);
        proxima.setAnterior(anterior);
        this.tamanho--;
      }
    }
  }

  boolean contem(Object elemento) {
    CelulaEncadeadaDupla celulaAtual = this.primeira;

    while (celulaAtual != null) {
      if (celulaAtual.getElemento().equals(elemento)) {
        return true;
      }

      celulaAtual = celulaAtual.getProximo();
    }

    return false;
  }

  int tamanho() {
    return this.tamanho;
  }

  void setListaVazia() {
    this.primeira = null;
    this.ultima = null;
    this.tamanho = 0;
  }

  @Override
  public String toString() {
    if (this.tamanho == 0) {
      return "[]";
    }
    StringBuilder stringBuilder = new StringBuilder("[");
    CelulaEncadeadaDupla celulaAtual = this.primeira;

    for (int i = 0; i < this.tamanho - 1; i++) {
      stringBuilder.append(celulaAtual.getElemento().toString());
      stringBuilder.append(", ");
      celulaAtual = celulaAtual.getProximo();
    }

    stringBuilder.append(celulaAtual.getElemento().toString());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}
