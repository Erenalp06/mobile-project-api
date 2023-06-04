package com.mobileproject.news.newsapp.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

public class NewsApiInterceptor implements ClientHttpRequestInterceptor {
    private static final String API_KEY = "5e146e70067d441e9cb7699e784ef3e2";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        URI modifiedUri = UriComponentsBuilder.fromUri(request.getURI())
                .queryParam("apiKey", API_KEY)
                .build()
                .toUri();

        HttpRequest modifiedRequest = new ModifiedHttpRequest(request, modifiedUri);
        return execution.execute(modifiedRequest, body);
    }

    private static class ModifiedHttpRequest extends HttpRequestWrapper {
        private final URI modifiedUri;

        public ModifiedHttpRequest(HttpRequest request, URI modifiedUri) {
            super(request);
            this.modifiedUri = modifiedUri;
        }

        @Override
        public URI getURI() {
            return modifiedUri;
        }
    }
}
