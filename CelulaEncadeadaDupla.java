public class CelulaEncadeadaDupla {
  CelulaEncadeadaDupla proximo, anterior;
  Object elemento;

  public CelulaEncadeadaDupla(CelulaEncadeadaDupla proximo, Object elemento) {
    this.proximo = proximo;
    this.anterior = null;
    this.elemento = elemento;
  }

  public CelulaEncadeadaDupla(Object elemento) {
    this.elemento = elemento;
    this.proximo = null;
    this.anterior = null;
  }

  void setProximo(CelulaEncadeadaDupla proximo) {
    this.proximo = proximo;
  }

  void setAnterior(CelulaEncadeadaDupla anterior) {
    this.anterior = anterior;
  }

  CelulaEncadeadaDupla getProximo() {
    return this.proximo;
  }

  CelulaEncadeadaDupla getAnterior() {
    return this.anterior;
  }

  Object getElemento() {
    return this.elemento;
  }
}
