package singleton_con_enum;

import singleton_con_enum.utilidad.Localconfiguracion;

public class Main {
     public static void main(String[] args) {
        Localconfiguracion config = Localconfiguracion.INSTANCIA;

        System.out.println("Nombre de la aplicación: " + config.get("appName"));
        System.out.println("Modo de ejecución: " + config.get("modo"));

        config.set("maxUsuarios", "500");
        System.out.println("Usuarios máximos permitidos: " + config.get("maxUsuarios"));

        config.mostrarConfiguraciones();
    }
}