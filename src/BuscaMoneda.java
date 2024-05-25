import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaMoneda {
    public Moneda buscaMoneda (String moneda) {
        String direccion = ("https://v6.exchangerate-api.com/v6/ca8e477e27a6ffcd91cf97b3/latest/"+moneda);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda");
        }
    }
}
