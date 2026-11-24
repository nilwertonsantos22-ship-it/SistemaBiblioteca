
package br.edu.poo.m0006.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OpenLibraryApi {

    public void buscarLivro(String termo) {

        try {
            String pesquisa = URLEncoder.encode(
                    termo, StandardCharsets.UTF_8
            );

            String url = "https://openlibrary.org/search.json?q="
                    + pesquisa
                    + "&fields=title,author_name,first_publish_year,isbn,publisher"
                    + "&limit=5";

            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent",
                            "SistemaBiblioteca/1.0 (projeto academico)")
                    .GET()
                    .build();

            HttpResponse<String> resposta = cliente.send(
                    requisicao,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (resposta.statusCode() != 200) {
                System.out.println("Erro ao consultar Open Library.");
                System.out.println("Código HTTP: "
                        + resposta.statusCode());
                return;
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode raiz = mapper.readTree(resposta.body());

            JsonNode livros = raiz.path("docs");

            if (!livros.isArray() || livros.isEmpty()) {
                System.out.println("Nenhum livro encontrado.");
                return;
            }

            for (JsonNode info : livros) {

                System.out.println("\n-------------------------");

                System.out.println("Título: "
                        + info.path("title").asText("Não informado"));

                System.out.println("Autores: "
                        + info.path("author_name"));

                System.out.println("Editora: "
                        + info.path("publisher"));

                System.out.println("Ano: "
                        + info.path("first_publish_year")
                        .asText("Não informado"));

                System.out.println("ISBN: "
                        + info.path("isbn").path(0)
                        .asText("Não informado"));
            }

        } catch (IOException e) {
            System.out.println("Erro na comunicação com a API: "
                    + e.getMessage());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consulta interrompida.");
        }
    }
}
