package HDT7;

public class Association<K, V>{

    private K llave;
    private V valor;

// Creating a constructor for the class Association.
    public Association(K llave,V valor){
        this.llave = llave;
        this.valor = valor;
    }

/**
 * It returns the key of the node.
 * 
 * @return The key of the node.
 */
    public K getLlave() {
        return this.llave;
    }

/**
 * It sets the key of the node.
 * 
 * @param llave The key of the node.
 */
    public void setLlave(K llave) {
        this.llave = llave;
    }

/**
 * It returns the value of the node.
 * 
 * @return The value of the node.
 */
    public V getValor() {
        return this.valor;
    }

/**
 * It sets the value of the node.
 * 
 * @param valor The value of the node.
 */
    public void setValor(V valor) {
        this.valor = valor;
    }
}