package HDT7;

public class ArbolNodo {
    Association<String, String> palabra;
    ArbolNodo left, right;

    ArbolNodo(Association<String, String> palabra){
        this.palabra = palabra;
        left = right = null;
    }
}