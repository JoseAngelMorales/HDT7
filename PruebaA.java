package HDT7;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PruebaA {

    @Test
    public void crearArbol(){
        Arbol arbol = new Arbol();
        Association<String, String> queso = new Association<String, String>("hola", "hello");
        Association<String, String> queso2 = new Association<String, String>("boca", "mouth");
        Association<String, String> queso3 = new Association<String, String>("leche", "milk");
        arbol.empezar(queso);
        arbol.empezar(queso2);
        arbol.empezar(queso3);
        assertEquals("mouth", arbol.empezarb("boca"));
        assertEquals("milk", arbol.empezarb("leche"));
        assertEquals("hello", arbol.empezarb("hola"));
    }
    

}
