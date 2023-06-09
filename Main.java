package HDT7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Creating a new association, a new factory, a new scanner, and 6 new trees.
        Association<String, String> palabra = new Association<String,String>(null, null);
        Factory factory = new Factory();
        Scanner teclado = new Scanner(System.in);
        Arbol arbolif = new Arbol();
        Arbol arbolie = new Arbol();
        Arbol arbolfi = new Arbol();
        Arbol arbolfe = new Arbol();
        Arbol arbolef = new Arbol();
        Arbol arbolei = new Arbol();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"));
            String linea = reader.readLine();
            while(linea != null){
                Namer namer = factory.getNamer(linea);
                //Arbol Ingles-Frances
                palabra.setLlave(namer.getPingles());
                palabra.setValor(namer.getPfrances());
                arbolif.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Ingles-Espanol
                palabra.setLlave(namer.getPingles());
                palabra.setValor(namer.getPespanol());
                arbolie.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Frances-Ingles
                palabra.setLlave(namer.getPfrances());
                palabra.setValor(namer.getPingles());
                arbolfi.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Frances-Espanol
                palabra.setLlave(namer.getPfrances());
                palabra.setValor(namer.getPespanol());
                arbolfe.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Espanol-Ingles
                palabra.setLlave(namer.getPespanol());
                palabra.setValor(namer.getPingles());
                arbolei.empezar(palabra);
                palabra = new Association<String,String>(null, null);
                //Arbol Espanol-Frances
                palabra.setLlave(namer.getPespanol());
                palabra.setValor(namer.getPfrances());
                arbolef.empezar(palabra);
                palabra = new Association<String,String>(null, null);

                linea = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("No se ha encontrado la direccion del archivo.");
        }

        String menu = "\nBienvenido al traductor, elija una de las opciones:\n1. Traducir del ingles\n2. Traducir del espanol\n3. Traducir del frances\n4. Mostrar el idioma principal de la oracion\n5. Traducir un archivo .txt\n6. Cerrar el programa";
        int opcion = 0;
        while(opcion < 1 || opcion > 6){
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            while(opcion >= 1 && opcion < 6){
                switch(opcion){
                    case 1:{
                        String menu2 = "\n--INGLES--\nA que idioma desea traducir:\n1. Espanol\n2. Frances\n3. Cambiar idioma de traduccion";
                        int opcion2 = 1;
                        System.out.println(menu2);
                        opcion2 = teclado.nextInt();
                        teclado.nextLine();
                        while(opcion2 >= 1 && opcion2 < 4){
                            switch(opcion2){
                                case 1:{
                                    System.out.println("\nIngrese la oracion a traducir: ");
                                    String oracion = teclado.nextLine();
                                    String traduccion = "";
                                    int i = oracion.lastIndexOf(".");
                                    //Quitar el punto al final de la oracion si lo tiene
                                    if(i+1 == oracion.length()){
                                        oracion = oracion.substring(0,i);
                                    }
                                    //Agregarle un espacio al final de la oracion para que funcione con el while
                                    if(oracion.lastIndexOf(" ") != oracion.length()){
                                        oracion = oracion + " ";
                                    }
                                    //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                    while(oracion != ""){
                                        i = oracion.indexOf(" ");
                                        String p = oracion.substring(0, i);
                                        //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                        if(arbolie.empezarb(p) == ""){
                                            traduccion = traduccion + "*" + p + "* ";
                                        }
                                        //Si la palabra si esta agrega el valor de la llave a la traduccion
                                        else {
                                            traduccion = traduccion + arbolie.empezarb(p) + " ";
                                        }
                                        oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                    }
                                    //Mayuscula y punto
                                    traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                    traduccion = traduccion.trim() + ".";
                                    System.out.println("Traduccion: " + traduccion);
                                    //Loop
                                    System.out.println(menu2);
                                    opcion2 = teclado.nextInt();
                                    teclado.nextLine();
                                    break;
                                }
                                case 2:{
                                    System.out.println("\nIngrese la oracion a traducir: ");
                                    String oracion = teclado.nextLine();
                                    String traduccion = "";
                                    int i = oracion.lastIndexOf(".");
                                    //Quitar el punto al final de la oracion si lo tiene
                                    if(i+1 == oracion.length()){
                                        oracion = oracion.substring(0,i);
                                    }
                                    //Agregarle un espacio al final de la oracion para que funcione con el while
                                    if(oracion.lastIndexOf(" ") != oracion.length()){
                                        oracion = oracion + " ";
                                    }
                                    //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                    while(oracion != ""){
                                        i = oracion.indexOf(" ");
                                        String p = oracion.substring(0, i);
                                        //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                        if(arbolif.empezarb(p) == ""){
                                            traduccion = traduccion + "*" + p + "* ";
                                        }
                                        //Si la palabra si esta agrega el valor de la llave a la traduccion
                                        else {
                                            traduccion = traduccion + arbolif.empezarb(p) + " ";
                                        }
                                        oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                    }
                                    //Mayuscula y punto
                                    traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                    traduccion = traduccion.trim() + ".";
                                    System.out.println("Traduccion: " + traduccion);
                                    //Loop
                                    System.out.println(menu2);
                                    opcion2 = teclado.nextInt();
                                    teclado.nextLine();
                                    break;
                                }
                                case 3:{
                                    opcion2 = 0;
                                    opcion = 0;
                                }
                            }
                        }
                        break;
                    }
                    case 2:{
                        String menu3 = "\nESPANOL\nA que idioma desea traducir:\n1. Ingles\n2. Frances\n3. Cambiar idioma de traduccion";
                        int opcion3 = 1;
                        System.out.println(menu3);
                        opcion3 = teclado.nextInt();
                        teclado.nextLine();
                        while(opcion3 >= 1 && opcion3 < 4){
                            switch(opcion3){
                                case 1:{
                                    System.out.println("\nIngrese la oracion a traducir: ");
                                    String oracion = teclado.nextLine();
                                    String traduccion = "";
                                    int i = oracion.lastIndexOf(".");
                                    //Quitar el punto al final de la oracion si lo tiene
                                    if(i+1 == oracion.length()){
                                        oracion = oracion.substring(0,i);
                                    }
                                    //Agregarle un espacio al final de la oracion para que funcione con el while
                                    if(oracion.lastIndexOf(" ") != oracion.length()){
                                        oracion = oracion + " ";
                                    }
                                    //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                    while(oracion != ""){
                                        i = oracion.indexOf(" ");
                                        String p = oracion.substring(0, i);
                                        //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                        if(arbolei.empezarb(p) == ""){
                                            traduccion = traduccion + "*" + p + "* ";
                                        }
                                        //Si la palabra si esta agrega el valor de la llave a la traduccion
                                        else {
                                            traduccion = traduccion + arbolei.empezarb(p) + " ";
                                        }
                                        oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                    }
                                    //Mayuscula y punto
                                    traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                    traduccion = traduccion.trim() + ".";
                                    System.out.println("Traduccion: " + traduccion);
                                    //Loop
                                    System.out.println(menu3);
                                    opcion3 = teclado.nextInt();
                                    teclado.nextLine();
                                    break;
                                }
                                case 2:{
                                    System.out.println("\nIngrese la oracion a traducir: ");
                                    String oracion = teclado.nextLine();
                                    String traduccion = "";
                                    int i = oracion.lastIndexOf(".");
                                    //Quitar el punto al final de la oracion si lo tiene
                                    if(i+1 == oracion.length()){
                                        oracion = oracion.substring(0,i);
                                    }
                                    //Agregarle un espacio al final de la oracion para que funcione con el while
                                    if(oracion.lastIndexOf(" ") != oracion.length()){
                                        oracion = oracion + " ";
                                    }
                                    //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                    while(oracion != ""){
                                        i = oracion.indexOf(" ");
                                        String p = oracion.substring(0, i);
                                        //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                        if(arbolef.empezarb(p) == ""){
                                            traduccion = traduccion + "*" + p + "* ";
                                        }
                                        //Si la palabra si esta agrega el valor de la llave a la traduccion
                                        else {
                                            traduccion = traduccion + arbolef.empezarb(p) + " ";
                                        }
                                        oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                    }
                                    //Mayuscula y punto
                                    traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                    traduccion = traduccion.trim() + ".";
                                    System.out.println("Traduccion: " + traduccion);
                                    //Loop
                                    System.out.println(menu3);
                                    opcion3 = teclado.nextInt();
                                    teclado.nextLine();
                                    break;
                                }
                                case 3:{
                                    opcion3 = 0;
                                    opcion = 0;
                                }
                            }
                        }
                        break;
                    }
                    case 3:{
                        String menu4 = "\n--FRANCES--\nA que idioma desea traducir:\n1. Espanol\n2. Ingles\n3. Cambiar idioma de traduccion";
                        int opcion4 = 1;
                        System.out.println(menu4);
                        opcion4 = teclado.nextInt();
                        teclado.nextLine();
                        while(opcion4 >= 1 && opcion4 < 4){
                            switch(opcion4){
                                case 1:{
                                    System.out.println("\nIngrese la oracion a traducir: ");
                                    String oracion = teclado.nextLine();
                                    String traduccion = "";
                                    int i = oracion.lastIndexOf(".");
                                    //Quitar el punto al final de la oracion si lo tiene
                                    if(i+1 == oracion.length()){
                                        oracion = oracion.substring(0,i);
                                    }
                                    //Agregarle un espacio al final de la oracion para que funcione con el while
                                    if(oracion.lastIndexOf(" ") != oracion.length()){
                                        oracion = oracion + " ";
                                    }
                                    //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                    while(oracion != ""){
                                        i = oracion.indexOf(" ");
                                        String p = oracion.substring(0, i);
                                        //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                        if(arbolfe.empezarb(p) == ""){
                                            traduccion = traduccion + "*" + p + "* ";
                                        }
                                        //Si la palabra si esta agrega el valor de la llave a la traduccion
                                        else {
                                            traduccion = traduccion + arbolfe.empezarb(p) + " ";
                                        }
                                        oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                    }
                                    //Mayuscula y punto
                                    traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                    traduccion = traduccion.trim() + ".";
                                    System.out.println("Traduccion: " + traduccion);
                                    //Loop
                                    System.out.println(menu4);
                                    opcion4 = teclado.nextInt();
                                    teclado.nextLine();
                                    break;
                                }
                                case 2:{
                                    System.out.println("\nIngrese la oracion a traducir: ");
                                    String oracion = teclado.nextLine();
                                    String traduccion = "";
                                    int i = oracion.lastIndexOf(".");
                                    //Quitar el punto al final de la oracion si lo tiene
                                    if(i+1 == oracion.length()){
                                        oracion = oracion.substring(0,i);
                                    }
                                    //Agregarle un espacio al final de la oracion para que funcione con el while
                                    if(oracion.lastIndexOf(" ") != oracion.length()){
                                        oracion = oracion + " ";
                                    }
                                    //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                    while(oracion != ""){
                                        i = oracion.indexOf(" ");
                                        String p = oracion.substring(0, i);
                                        //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                        if(arbolfi.empezarb(p) == ""){
                                            traduccion = traduccion + "*" + p + "* ";
                                        }
                                        //Si la palabra si esta agrega el valor de la llave a la traduccion
                                        else {
                                            traduccion = traduccion + arbolfi.empezarb(p) + " ";
                                        }
                                        oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                    }
                                    //Mayuscula y punto
                                    traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                    traduccion = traduccion.trim() + ".";
                                    System.out.println("Traduccion: " + traduccion);
                                    //Loop
                                    System.out.println(menu4);
                                    opcion4 = teclado.nextInt();
                                    teclado.nextLine();
                                    break;
                                }
                                case 3:{
                                    opcion4 = 0;
                                    opcion = 0;
                                }
                            }
                        }
                        break;
                    }
                    case 4:{
                        int esp = 0, ing = 0, fra = 0;
                        System.out.println("\nIngrese la oracion a traducir: ");
                        String idioma = "El idioma principal de la oracion es: ";
                        String oracion = teclado.nextLine();
                        int i = oracion.lastIndexOf(".");
                        if(i+1 == oracion.length()){
                            oracion = oracion.substring(0,i);
                        }
                        //Agregarle un espacio al final de la oracion para que funcione con el while
                        if(oracion.lastIndexOf(" ") != oracion.length()){
                            oracion = oracion + " ";
                        }
                        while(oracion != ""){
                            i = oracion.indexOf(" ");
                            String p = oracion.substring(0, i);
                            if(arbolef.empezarb(p)!=""){
                                esp++;
                            }
                            if(arbolie.empezarb(p)!=""){
                                ing++;
                            }
                            if(arbolfi.empezarb(p)!=""){
                                fra++;
                            }
                            oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                        }
                        if(esp == 0 && ing == 0 && fra == 0){
                            System.out.println("No se han detectado palabras en ninguno de los 3 idiomas.");
                            break;
                        }
                        if(esp > ing && esp > fra){
                            idioma = idioma + "Espanol";
                        }
                        if(ing > esp && ing > fra){
                            idioma = idioma + "Ingles";
                        }
                        if(fra > ing && fra > esp){
                            idioma = idioma + "Frances";
                        }
                        if(ing == esp && ing > fra){
                            idioma = idioma + "Ingles y Espanol";
                        }
                        if(ing == fra && ing > esp){
                            idioma = idioma + "Ingles y Frances";
                        }
                        if(esp == fra && esp > ing){
                            idioma = idioma + "Espanol y Frances";
                        }
                        if(esp == fra && esp == ing){
                            idioma = idioma + "Espanol, Frances e Ingles";
                        }
                        System.out.println(idioma);
                        opcion = 0;
                        break;
                    }
                    case 5:{
                        try{
                            System.out.println("\nNombre del archivo:");
                            String archivo = teclado.nextLine();
                            BufferedReader reader = new BufferedReader(new FileReader(archivo));
                            String linea = reader.readLine();
                            int esp = 0, ing = 0, fra = 0;
                            int idioma = 0;
                            while(linea != null){
                                String oracion = linea;
                                int i = oracion.lastIndexOf(".");
                                if(i+1 == oracion.length()){
                                    oracion = oracion.substring(0,i);
                                }
                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                    oracion = oracion + " ";
                                }
                                while(oracion != ""){
                                    i = oracion.indexOf(" ");
                                    String p = oracion.substring(0, i);
                                    if(arbolef.empezarb(p)!=""){
                                        esp++;
                                    }
                                    if(arbolie.empezarb(p)!=""){
                                        ing++;
                                    }
                                    if(arbolfi.empezarb(p)!=""){
                                        fra++;
                                    }
                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                }
                                if(esp == 0 && ing == 0 && fra == 0){
                                    System.out.println("No se han detectado palabras en ninguno de los 3 idiomas.");
                                    break;
                                }
                                if(esp >= ing && esp >= fra){
                                    System.out.println("Se traducira del Espanol");
                                    idioma = 0;
                                }
                                if(ing >= esp && ing >= fra){
                                    System.out.println("Se traducira del Ingles");
                                    idioma = 1;
                                }
                                if(fra >= ing && fra >= esp){
                                    System.out.println("Se traducira del Frances");
                                    idioma = 2;
                                }
                                switch(idioma){
                                    case 0:{
                                        System.out.println("Frase a traducir: " + linea);
                                        String menu5 = "A que idioma quiere traducir:\n1. Ingles\n2. Frances";
                                        int opcion5 = 0;
                                        while(opcion5 < 1 || opcion5 > 3){
                                            System.out.println(menu5);
                                            opcion5 = teclado.nextInt();
                                            teclado.nextLine();
                                        }
                                        switch(opcion5){
                                            case 1:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                                    if(arbolei.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la palabra si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + arbolei.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                            case 2:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                                    if(arbolef.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la palabra si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + arbolef.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 1:{
                                        System.out.println("Frase a traducir: " + linea);
                                        String menu5 = "A que idioma quiere traducir:\n1. Espanol\n2. Frances";
                                        int opcion5 = 0;
                                        while(opcion5 < 1 || opcion5 > 3){
                                            System.out.println(menu5);
                                            opcion5 = teclado.nextInt();
                                            teclado.nextLine();
                                        }
                                        switch(opcion5){
                                            case 1:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                                    if(arbolie.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la palabra si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + arbolie.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                            case 2:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                                    if(arbolif.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la palabra si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + arbolif.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 2:{
                                        System.out.println("\nFrase a traducir: " + linea);
                                        String menu5 = "A que idioma quiere traducir:\n1. Ingles\n2. Espanol";
                                        int opcion5 = 0;
                                        while(opcion5 < 1 || opcion5 > 3){
                                            System.out.println(menu5);
                                            opcion5 = teclado.nextInt();
                                            teclado.nextLine();
                                        }
                                        switch(opcion5){
                                            case 1:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                                    if(arbolfi.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la palabra si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + arbolfi.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                            case 2:{
                                                oracion = linea;
                                                String traduccion = "";
                                                i = oracion.lastIndexOf(".");
                                                //Quitar el punto al final de la oracion si lo tiene
                                                if(i+1 == oracion.length()){
                                                    oracion = oracion.substring(0,i);
                                                }
                                                //Agregarle un espacio al final de la oracion para que funcione con el while
                                                if(oracion.lastIndexOf(" ") != oracion.length()){
                                                    oracion = oracion + " ";
                                                }
                                                //El while va removiendo palabra por palabra de la oracion hasta que este quede vacio "" y termine.
                                                while(oracion != ""){
                                                    i = oracion.indexOf(" ");
                                                    String p = oracion.substring(0, i);
                                                    //Si la palabra no esta en el arbol devuelve "" y agrega la palabra entre ** a la traduccion.
                                                    if(arbolfe.empezarb(p) == ""){
                                                        traduccion = traduccion + "*" + p + "* ";
                                                    }
                                                    //Si la palabra si esta agrega el valor de la llave a la traduccion
                                                    else {
                                                        traduccion = traduccion + arbolfe.empezarb(p) + " ";
                                                    }
                                                    oracion = oracion.replaceFirst(oracion.substring(0, i+1), "");
                                                }
                                                //Mayuscula y punto
                                                traduccion = traduccion.substring(0,1).toUpperCase() + traduccion.substring(1);
                                                traduccion = traduccion.trim() + ".";
                                                System.out.println("Traduccion: " + traduccion);
                                                opcion = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                linea = reader.readLine();
                            }
                        } catch (IOException e) {
                            System.out.println("No se ha encontrado la direccion del archivo.");
                        }
                        break;
                    }
                }
            } 
        }   
    }
}

