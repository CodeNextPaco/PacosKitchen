package com.example.pacoskitchen.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recipe {

    private String recipeTitle;
    private String[] recipeIngredients;
    private String recipesteps;

    public Recipe(String recipeTitle, String[] recipeIngredients, String recipesteps) {
        this.recipeTitle = recipeTitle;
        this.recipeIngredients = recipeIngredients;
        this.recipesteps = recipesteps;
    }

    public Recipe() {
        //default constructor
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String[] getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String[] recipeIngredients) {

        this.recipeIngredients = recipeIngredients;

    }

    public String getRecipesteps() {


        return recipesteps;
    }

    public void setRecipesteps(String recipesteps) {
        this.recipesteps = recipesteps;
    }
}
