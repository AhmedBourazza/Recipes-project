package org.system.recipesproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.system.recipesproject.services.RecipeService;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }



    @PostMapping("/recipes")
    public String getRecipes(@RequestParam("ingredient") String ingredient, Model model) {
        // Get recipes from API using the ingredient
        Object recipes = recipeService.getRecipesByIngredient(ingredient);

        // Add the recipes to the model
        model.addAttribute("recipes", recipes);
        return "recipes";  // View to display the recipes
    }
}
