
public class Association<K, V>{

    private K llave;
    private V valor;

    public Association(K llave,V valor){
        this.llave = llave;
        this.valor = valor;
    }

    public K getLlave() {
        return this.llave;
    }

    public void setLlave(K llave) {
        this.llave = llave;
    }

    public V getValor() {
        return this.valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
}