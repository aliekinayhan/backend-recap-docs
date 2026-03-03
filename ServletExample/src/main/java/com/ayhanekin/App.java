package com.ayhanekin;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {

    public static void main(String[] args) {

        Tomcat tomcat = new Tomcat();

        // PORT BELİRLE
        tomcat.setPort(8080);

        try {
            // Geçici bir base directory oluştur
            String baseDir = new File(".").getAbsolutePath();
            tomcat.setBaseDir(baseDir);

            // CONNECTOR EKLE (ÖNEMLİ)
            Connector connector = new Connector();
            connector.setPort(8080);
            tomcat.getService().addConnector(connector);
            tomcat.setConnector(connector);

            Context context = tomcat.addContext("", baseDir);

            Tomcat.addServlet(context, "Servlet", new Servlet());
            context.addServletMappingDecoded("/hello", "Servlet");

            tomcat.start();
            System.out.println("Tomcat started on http://localhost:8080/hello");

            tomcat.getServer().await();

        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
