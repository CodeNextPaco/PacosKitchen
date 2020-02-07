package com.example.pacoskitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pacoskitchen.model.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {


    private TextView titleTxtView;
    private ImageView imageView;
    private TextView stepsTxtView;
    private TextView ingredientsTxtView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        //connect the views to the xml elements
        titleTxtView = findViewById(R.id.title_txt_view);
        stepsTxtView = findViewById(R.id.steps_txt_view);
        ingredientsTxtView = findViewById(R.id.ingredients_txt_view);
        titleTxtView = findViewById(R.id.title_txt_view);
        imageView = findViewById(R.id.detailsImgView);

        //use the bundle to get the title and image
        Bundle bundle = getIntent().getExtras();


        String recipeTitle = bundle.getString("title");

        int imageName = bundle.getInt("image_name");

        //set image using the int value we got from the id of the drawable file
        imageView.setImageResource(imageName);

        //Build the recipe based on the type
       Recipe thisRecipe =  buildRecipes(recipeTitle);

       titleTxtView.setText(thisRecipe.getRecipeTitle());
       stepsTxtView.setText(thisRecipe.getRecipesteps());
       Log.d("onCreate", "steps" + thisRecipe.getRecipeIngredients().toString());

       //since the ingredients are in an array, we have to loop through and add a new line break between each item.
       for(String ingredient: thisRecipe.getRecipeIngredients()){

           ingredientsTxtView.append(ingredient + "\n");
       }

    }

    public Recipe buildRecipes(String recipeType){

        //this method creates a new Recipe object and determines which values to set for it based on the recipeType

        Recipe recipe = new Recipe();

        //an empty string to hold our recipe steps/instructions
        String steps="";

        //create a recipe depending on the type we are requesting. We use the .equals() String method to compare.

        if(recipeType.equals("Torta Ahogada")){

            //make a new basic array and add the ingredients.

            String[] ingredients = {"4 hard rolls halved horizontally", "  1 Lb Pork Carnitas", "¾ cup of Refried Beans",
                    " 2 Lbs. ripe tomatoes", "1 clove garlic",  " 1 teaspoon of vinegar", "½ teaspoon of dry Mexican oregano",
                    "Salt to taste", " 1 / 4 of a large thinly sliced onion and marinated in lemon juice"};

            //the recipe steps are stored in the res/values/strings resource file to make this code easier to read.
            steps = getResources().getString(R.string.torta_steps);
            recipe.setRecipeIngredients(ingredients);


        }else if(recipeType.equals("Cucumber Banchan")){

            String[] ingredients = {"1 cucumber", " 1 Tbs soy sauce", "2 Tbs rice vinegar",
                    "1 Tbs sugar", "1/2 tsp Korean red chili powder",  " 1/4 tsp sesame seeds", " 2 green onions , chopped"};

            recipe.setRecipeIngredients(ingredients);
            steps = getResources().getString(R.string.banchan_steps);



        }else if(recipeType.equals("Fish Taco")){

            String[] ingredients = {"1lb of fish filets (tilapia, cod, mahi mahi)", "1 cup of breadcrumbs", "1 cup of vegetable oil",
                    "tortillas",  "1/2 cup of mayonnaise", "3 limes", "a head of cabbage", "Canned chipotle chiles", "salsa of your choice"};

            recipe.setRecipeIngredients(ingredients);
            steps = getResources().getString(R.string.fish_taco_steps);

        }else if(recipeType.equals("Molletes")){

            String[] ingredients = {"Bolillo rolls or 1 baguette", "Mozarella or Jack cheese", "refried beans", "butter"};

            recipe.setRecipeIngredients(ingredients);
            steps = getResources().getString(R.string.mollete_steps);

        }else if(recipeType.equals("Japchae")){

            String[] ingredients = {"3 tablespoons soy sauce" , " 2 1/2 tablespoons white sugar",  " 2 tablespoons sesame oil", "  2 teaspoons minced garlic",
            "8 ounces sweet potato noodles","4 ounces lean beef, cut into 2-inch long strips", " 6 ounces fresh spinach", "salt and ground black pepper to taste",
            "A  tablespoon vegetable oil", "1 small sweet onion" , " thinly sliced4 mushrooms" , "small carrot" };


            recipe.setRecipeIngredients(ingredients);
            steps = getResources().getString(R.string.japchae_steps);



        }else {

            //if int's not the other recipes, it must be pozole

            String[] ingredients = { "4 ounces guajillo chili pods", " Salt"," 1 large can white hominy" , " 3 lbs pork shoulder ", " 8 cloves garlic",
            "4 cloves roughly chopped", "4 whole cloves" , " 3 bay leaves" , "1 teaspoon ground cumin" , "  2 Tbsp of dry oregano",
            "Half a small cabbage, thinly sliced", "1/2 white onion, chopped", "2 avocados, chopped","4 limes, quartered" , "radishes", "tostadas"};

            recipe.setRecipeIngredients(ingredients);
            steps = getResources().getString(R.string.pozole_steps);

        }

        //set the title of the recipe and the steps.
        recipe.setRecipeTitle(recipeType);
        recipe.setRecipesteps(steps);

        return recipe;

    }
}
