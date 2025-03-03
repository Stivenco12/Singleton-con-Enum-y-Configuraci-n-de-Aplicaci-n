# Singleton con Enum y Configuración de Aplicación

Este proyecto implementa el patrón Singleton utilizando **Enum** en Java para la gestión eficiente de configuraciones de una aplicación. Se emplea un archivo `config.properties` para centralizar y administrar las configuraciones de manera estructurada.

## Características principales
- Implementación del patrón **Singleton** mediante `Enum`, garantizando una instancia única y segura.
- Carga de configuraciones desde un archivo externo (`config.properties`), facilitando la modularidad y mantenibilidad.
- Uso de **Maven** para la gestión de dependencias y automatización del ciclo de vida del proyecto.

## Estructura del Proyecto
```
Singleton-con-Enum-y-Configuraci-n-de-Aplicaci-n-main/
│── pom.xml  # Archivo de configuración de Maven
│── src/
│   ├── main/java/singleton_con_enum/
│   │   ├── Main.java  # Clase principal para la ejecución de la aplicación
│   │   ├── utilidad/Localconfiguracion.java  # Implementación del Singleton para la configuración
│   ├── main/resources/
│   │   ├── config.properties  # Archivo de configuración con los parámetros clave
│── target/  # Directorio de salida para los archivos compilados
```

## Instalación y Ejecución
### Requisitos
- **Java 8+**
- **Maven**


## Configuración (`config.properties`)
Este archivo permite definir los parámetros clave de la aplicación.
```properties
appName=MiAplicacion
version=1.0.0
modo=produccion
timeout=10

```

## Implementación de `Localconfiguracion.java`
La clase `Localconfiguracion` se encarga de manejar la configuración de la aplicación garantizando una única instancia global.
```java
public enum Localconfiguracion {
    INSTANCIA;
    
    private Properties propiedades;
    
    Localconfiguracion() {
        propiedades = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                propiedades.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String obtenerPropiedad(String clave) {
        return propiedades.getProperty(clave);
    }
}
```

## Uso en `Main.java`
Ejemplo de cómo acceder a la configuración desde la clase principal.
```java
public class Main {
    public static void main(String[] args) {
        String valor = Localconfiguracion.INSTANCIA.obtenerPropiedad("clave.ejemplo");
        System.out.println("Valor obtenido: " + valor);
    }
}
```

## Beneficios y Aplicaciones
- **Estandarización**: Centraliza la configuración, facilitando su modificación sin alterar el código fuente.
- **Escalabilidad**: Puede integrarse con sistemas más grandes sin necesidad de refactorización.
- **Seguridad**: Uso de `Enum` para evitar múltiples instancias del Singleton.

---
**Autor: Stivenco12** 

