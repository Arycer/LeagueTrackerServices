package me.arycer.leaguetracker.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiKeyLoader {
    private static final String API_KEY_FILE = "application-secrets.properties";
    private static String cachedApiKey;

    public static String getApiKey() {
        if (cachedApiKey != null) {
            return cachedApiKey;
        }

        File file = new File(API_KEY_FILE);
        System.out.println(file.toPath().toAbsolutePath());

        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(API_KEY_FILE)) {
            properties.load(input);
            cachedApiKey = properties.getProperty("riot.api.key");

            if (cachedApiKey == null || cachedApiKey.isEmpty()) {
                throw new RuntimeException("La API Key no está configurada en el archivo: " + API_KEY_FILE);
            }

            return cachedApiKey;
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de configuración: " + API_KEY_FILE, e);
        }
    }
}