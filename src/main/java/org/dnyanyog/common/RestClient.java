package org.dnyanyog.common;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient {
	public static String postRequest(String url, String body) throws IOException, InterruptedException {

		// Rest Client -> PostMan

		HttpClient client = HttpClient.newHttpClient();

		// Request
		HttpRequest request = HttpRequest
				.newBuilder().uri(URI.create(url)).header("Content-Type", "application/xml")
				.POST(HttpRequest.BodyPublishers.ofString(body)).build();

		// REsponse
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}

	public static String getRequest(String url) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest
				.newBuilder().uri(URI.create(url)).GET().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
	}
	public static String  deleteRequest(String url)throws IOException, InterruptedException{
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest
				.newBuilder().uri(URI.create(url)).DELETE().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body();
		
	}

}
