package TP.xinser;

import java.util.HashMap;
import java.util.Map;

import utiles.Utiles;
import utiles.Lectura;

public class ejercicio01 {
    public static void main(String[] args) {
        HashMap<String, Long> agenda = new  HashMap<String, Long>();
        menu(agenda);
    }

    private static void menu(HashMap<String, Long> agenda){
        String opcion;
        do {
            System.out.println("-------- Opciones --------");
            System.out.println("1-Cargar Datos en la Agenda \n" +
                    "2-Buscar Teléfono por Nombre \n" +
                    "3-Listar Agenda \n" +
                    "4-salir");
            opcion = Lectura.leerStringM("Opcion:");
            if(opcion.equalsIgnoreCase("1"))
                opcicionCargarDatos(agenda);
            else if (opcion.equalsIgnoreCase("2"))
                opcicionBuscarTelefonoPorNombre(agenda);
            else if (opcion.equalsIgnoreCase("3"))
                mostrarAgenda(agenda);
            else if (opcion.equalsIgnoreCase("4")){
                break;
            }else {
                System.out.println("opcion incorrecta");
            }
        }while (true);
    }

    private static void opcicionCargarDatos(HashMap<String, Long> agenda){
        boolean continuar;
        do {
            agregarContacto(agenda);
            continuar = Utiles.continuarM("¿desea seguir ?");
        }while (continuar);
    }

    private static void opcicionBuscarTelefonoPorNombre(HashMap<String, Long> agenda){
        String usuario;
        Long telefono;

        if(agenda == null){
            agenda = new HashMap<String, Long>();
        }
        System.out.println("------ Buscar contacto ------");
        usuario = Lectura.leerStringM("ingrese el nombre:");
        telefono = agenda.getOrDefault(usuario, -1L);;
        if(telefono <= 0L){
            System.out.println("Incorecto: no se ha encontrado el contacto");
        }else{
            System.out.println("el telefono es:" + telefono);
        }
    }

    private static void agregarContacto(HashMap<String, Long> agenda){
        if(agenda == null){
            agenda = new HashMap<String, Long>();
        }
        String contacto;
        Long telefono;
        contacto = Lectura.leerStringM("ingrese el contacto:");
        telefono = Lectura.leerLongM("telefono:");
        if(!agenda.containsKey(contacto)){
            agenda.put(contacto,telefono);
        }else{
            System.out.println("Incorrecto: El contacto ya existe");
        }
    }

    private static void mostrarAgenda(HashMap<String, Long> agenda){
        System.out.println("----------- Agenda -----------");
        if(agenda != null){
        System.out.println("Contacto:");
        System.out.println(Utiles.rellenarEspaciosSimple("Nombre",14)+Utiles.rellenarEspaciosSimple("Telefono",14));
        for (Map.Entry<String, Long> usuario : agenda.entrySet()) {
            System.out.println(Utiles.rellenarEspaciosSimple(usuario.getKey(),14)+
                    Utiles.rellenarEspaciosSimple(String.valueOf(usuario.getValue()),14));
        }
        }else {
            System.out.println("ingrese contactos");
        }
    }

}
