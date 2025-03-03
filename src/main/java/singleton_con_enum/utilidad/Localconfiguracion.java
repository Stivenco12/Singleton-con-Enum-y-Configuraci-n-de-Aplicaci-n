package singleton_con_enum.utilidad;

import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public enum Localconfiguracion {
    INSTANCIA;

    private final Map<String, String> configuraciones = new HashMap<>();    
   
    Localconfiguracion() {
        cargarConfiguraciones("config.properties");
    }
    private void cargarConfiguraciones(String rutaArchivo) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (var archivo = classLoader.getResourceAsStream(rutaArchivo)) {
            if (archivo == null) {
                throw new IOException("Archivo de configuración no encontrado: " + rutaArchivo);
            }
            Properties propiedades = new Properties();
            propiedades.load(archivo);
            for (String clave : propiedades.stringPropertyNames()) {
                configuraciones.put(clave, propiedades.getProperty(clave));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar configuraciones: " + e.getMessage());
        }
    }
    public void set(String clave, String valor) {
        configuraciones.put(clave, valor);
    }
    public String get(String clave){
        return configuraciones.getOrDefault(clave, "valor no encontrado");
    }
  
    public void mostrarConfiguraciones(){
        System.out.println("configuraciones actuales");
        configuraciones.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
    }
}