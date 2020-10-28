package TP.xinser.ejercicio02;

import utiles.Lectura;
import utiles.Utiles;

public class CostoCoputadora {
    public static void main(String[] args) {
        do {
            Computadora computadora = new Computadora();
            String marca;
            String modelo;
            System.out.println("------- Ingrese las especificaciones de la computadora ------");
            marca = Lectura.leerStringM("marca:");
            modelo = Lectura.leerStringM("modelo:");
            computadora.setMarca(marca);
            computadora.setModelo(modelo);
            do {
                ComponenteCPU componenteCPU = new ComponenteCPU();
                String nombreComponente;
                String marcaComponente;
                int cantidadComponente;
                double precioComponente;
                System.out.println("-- Ingrese Los componentes --");
                nombreComponente = Lectura.leerStringM("componente:");
                marcaComponente = Lectura.leerStringM("marca del componente:");
                precioComponente = Lectura.leerDoubleM("precio:");
                cantidadComponente = Lectura.leerIntM("cantidad:");
                componenteCPU.setComponente(nombreComponente);
                componenteCPU.setMarca(marcaComponente);
                componenteCPU.setPrecio(precioComponente);
                componenteCPU.setCantidad(cantidadComponente);
                computadora.addComponenteCPU(componenteCPU);
            } while (Utiles.continuarM("¿desea continuar añadiendo componentes?"));

            mostrarComputadora(computadora);
        }while (Utiles.continuarM("¿desea sacar algun otro costo?"));
    }

    private static void mostrarComputadora(Computadora computadora){
        System.out.println("---------- Computadora ------------");
        System.out.println("marca: " + computadora.getMarca());
        System.out.println("modelo: " + computadora.getModelo());
        System.out.println("Componentes:");
        System.out.println(Utiles.rellenarEspaciosSimple("Componente",20) +
                Utiles.rellenarEspaciosSimple("Marca",14) +
                Utiles.rellenarEspaciosSimple("Cantidad",14) +
                Utiles.rellenarEspaciosSimple("Precio X Unidad",20) +
                Utiles.rellenarEspaciosSimple("SubTotal",14));
        Double sumaTotal = 0.0;
        for (ComponenteCPU commponente :computadora.getComponentes()) {
            Double subTotal = commponente.getPrecio() * commponente.getCantidad();
            sumaTotal += subTotal;
            System.out.println(
                Utiles.rellenarEspaciosSimple(commponente.getComponente(),20)+
                Utiles.rellenarEspaciosSimple(commponente.getMarca(),14)+
                Utiles.rellenarEspaciosSimple(String.valueOf(commponente.getCantidad()),14)+
                "$ " + Utiles.rellenarEspaciosSimple(String.valueOf(commponente.getPrecio()),18)+
                "$ " + commponente.getPrecio()
            );
        }
        System.out.println(Utiles.rellenarEspaciosSimple("",48)+ Utiles.rellenarEspaciosSimple("Costo Total:" ,20) + "$ " +sumaTotal);
        double porcentaje;
        if(sumaTotal <= 50000){
            porcentaje = sumaTotal * 0.4;
        }else {
            porcentaje = sumaTotal * 0.3;
        }
        System.out.println("El precio sugerido de venta es de $" + (sumaTotal + porcentaje));
    }
}
