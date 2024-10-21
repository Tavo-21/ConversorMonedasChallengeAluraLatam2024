import Logica.ConvertidorMoneda;
import Modelo.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean seguirEjecutando = true;

        while (seguirEjecutando) {
            // Mostrar el menú
            System.out.println("\n---------- Menu Conversor ----------");
            System.out.println("1. Convertir Dólar a Peso Argentino");
            System.out.println("2. Convertir Peso Argentino a Dólar");
            System.out.println("3. Convertir Dólar a Real Brasileño");
            System.out.println("4. Convertir Real Brasileño a Dólar");
            System.out.println("5. Convertir Dólar a Peso Colombiano");
            System.out.println("6. Convertir Peso Colombiano a Dólar");
            System.out.println("7. Salir");
            System.out.print("Elige una opción de conversión: ");
            int opcion = entrada.nextInt();
            String codigoMonedaOrigen = "";
            String codigoMonedaDestino = "";
            double cantidad;

            // Procesar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    codigoMonedaOrigen = "USD";
                    codigoMonedaDestino = "ARS";
                    break;
                case 2:
                    codigoMonedaOrigen = "ARS";
                    codigoMonedaDestino = "USD";
                    break;
                case 3:
                    codigoMonedaOrigen = "USD";
                    codigoMonedaDestino = "BRL";
                    break;
                case 4:
                    codigoMonedaOrigen = "BRL";
                    codigoMonedaDestino = "USD";
                    break;
                case 5:
                    codigoMonedaOrigen = "USD";
                    codigoMonedaDestino = "COP";
                    break;
                case 6:
                    codigoMonedaOrigen = "COP";
                    codigoMonedaDestino = "USD";
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    seguirEjecutando = false;
                    continue; // Romper el ciclo
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción correcta.");
                    continue; // Reiniciar el ciclo si la opción no es válida
            }

            if (seguirEjecutando) {
                // Pedimos la cantidad a convertir
                System.out.print("Introduce la cantidad a convertir: ");
                cantidad = entrada.nextDouble();

                // Creamos el objeto Moneda
                Moneda monedaOrigen = new Moneda(codigoMonedaOrigen, cantidad);

                try {
                    // Llamamos a la lógica de conversión
                    Moneda monedaConvertida = ConvertidorMoneda.convertir(monedaOrigen, codigoMonedaDestino);

                    // Mostramos el resultado
                    System.out.println("Resultado: " + monedaOrigen.toString() + " es igual a " + monedaConvertida.toString());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        // Cerramos el scanner
        entrada.close();
    }
}
