package HDT7;

public class ArbolNodo {
    
    Association<String, String> palabra;
    ArbolNodo left, right;

// Creating a constructor for the class ArbolNodo.
    ArbolNodo(Association<String, String> palabra){
        this.palabra = palabra;
        left = right = null;
    }
}

//Codigo inspirado de: https://www.baeldung.com/java-binary-tree