package config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    public static String request(String endereco) {
        try {
            HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(endereco))
                .build();

            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
