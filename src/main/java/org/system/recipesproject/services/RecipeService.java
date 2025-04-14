package org.system.recipesproject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class RecipeService {

    @Value("${themealdb.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public RecipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getRecipesByIngredient(String ingredient) {
        String url = String.format("%s?i=%s", apiUrl, ingredient);
        return restTemplate.getForObject(url, Object.class);
    }
}
