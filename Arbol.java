package HDT7;

import java.util.Stack;

public class Arbol {

    ArbolNodo root;

    public ArbolNodo insertar(ArbolNodo current, Association<String, String> palabra){
        if(current == null){
            return new ArbolNodo(palabra);
        }
        if(palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) < 0){
            current.left = insertar(current.left, palabra);
        }
        else if (palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) > 0){
            current.right = insertar(current.right, palabra);
        }

        return current;
    }

    public void empezar(Association<String, String> palabra){
        root = insertar(root, palabra);
    }

    public String buscar(ArbolNodo current, Association<String, String> palabra){
        String traduccion = "";
        while(current != null){
            if(current.palabra.getLlave().equalsIgnoreCase(palabra.getLlave()) == true){
                traduccion = current.palabra.getValor();
            }
            if(current.palabra.getLlave().equalsIgnoreCase(palabra.getLlave()) == false){
                if(palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) < 0){
                    current = current.left;
                }
                if(palabra.getLlave().compareToIgnoreCase(current.palabra.getLlave()) > 0){
                    current = current.right;
                }
            }
        }   
        return traduccion;
    }

    public ArbolNodo buscarPrimerNodo(ArbolNodo raiz) {
        ArbolNodo primerNodo = null;
        Stack<ArbolNodo> pila = new Stack<>();
        pila.push(raiz);
    
        while (!pila.empty()) {
            ArbolNodo actual = pila.pop();
            if (primerNodo == null) {
                primerNodo = actual;
            }
            if (actual.left != null) {
                pila.push(actual.left);
            }
            if (actual.right != null) {
                pila.push(actual.right);
            }
        }
        return primerNodo;
    }
}
