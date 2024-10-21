package Logica;

import Modelo.Moneda;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConvertidorMoneda {

    // Método para obtener la tasa de cambio desde la API
    public static double obtenerTasaCambio(String codigoMonedaOrigen, String codigoMonedaDestino) throws Exception {
        String apiUrl = String.format("https://api.exchangerate-api.com/v4/latest/%s", codigoMonedaOrigen);
        URL url = new URL(apiUrl);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        int codigoRespuesta = conexion.getResponseCode();

        if (codigoRespuesta == 200) {
            BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String lineaEntrada;
            StringBuilder respuesta = new StringBuilder();
            while ((lineaEntrada = lector.readLine()) != null) {
                respuesta.append(lineaEntrada);
            }
            lector.close();

            JSONObject jsonRespuesta = new JSONObject(respuesta.toString());
            return jsonRespuesta.getJSONObject("rates").getDouble(codigoMonedaDestino);
        } else {
            throw new Exception("Error en la respuesta de la API");
        }
    }

    // Método que realiza la conversión de moneda
    public static Moneda convertir(Moneda monedaOrigen, String codigoMonedaDestino) throws Exception {
        double tasaCambio = obtenerTasaCambio(monedaOrigen.getCodigo(), codigoMonedaDestino);
        double cantidadConvertida = monedaOrigen.getCantidad() * tasaCambio;
        return new Moneda(codigoMonedaDestino, cantidadConvertida);
    }
}
