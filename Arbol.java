package HDT7;

public class Arbol {

    ArbolNodo root;

    private ArbolNodo insertar(ArbolNodo current, Association<String, String> palabra){
        if(current == null){
            return new ArbolNodo(palabra);
        }
        if(palabra.getLlave().compareTo(current.palabra.getLlave()) < 0){
            current.left = insertar(current.left, palabra);
        }
        else if (palabra.getLlave().compareTo(current.palabra.getLlave()) > 0){
            current.right = insertar(current.right, palabra);
        }

        return current;
    }

    public void empezar(Association<String, String> palabra){
        root = insertar(root, palabra);
    }
}
