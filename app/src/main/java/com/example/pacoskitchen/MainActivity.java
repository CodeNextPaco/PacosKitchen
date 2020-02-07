package com.example.pacoskitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    /*******************************************************************************************
     *               ### READ ME ###
     * This app uses one main activity (this) to launch all the recipe views from one Detail
     * Recipe Activity.
     *
     * All the image buttons call the same onClick method: showDetailView
     * which checks the id of the button pressed against the ids for each button to determine
     * which content to load.
     *
     * It passes the an Extra via the intent to the detail view - "title" which the
     * detail view will use to know which content to load.
     *
     * We also pass the image_name, but this step can also be done in the detail view.
     *************************************************************************************/


    public void showDetailView(View view){

        Intent detailView = new Intent(this, RecipeDetailActivity.class); //this is how you launch an new activity


        if(R.id.imageButton == view.getId()){

            detailView.putExtra("title", "Torta Ahogada");
            detailView.putExtra("image_name" , R.drawable.torta_ahogada);
            this.startActivity(detailView);

        } else if(R.id.imageButton2 == view.getId()){

            detailView.putExtra("title", "Cucumber Banchan");
            detailView.putExtra("image_name" , R.drawable.cucumber_banchan);
            this.startActivity(detailView);
        } else if(R.id.imageButton3 == view.getId()){

            detailView.putExtra("title", "Fish Taco");
            detailView.putExtra("image_name" , R.drawable.fish_taco);
            this.startActivity(detailView);
        }
        else if(R.id.imageButton4 == view.getId()){

            detailView.putExtra("title", "Molletes");
            detailView.putExtra("image_name" , R.drawable.molletes);
            this.startActivity(detailView);
        }
        else if(R.id.imageButton5 == view.getId()){

            detailView.putExtra("title", "Japchae");
            detailView.putExtra("image_name" , R.drawable.japchae);
            this.startActivity(detailView);
        } else {

            detailView.putExtra("title", "Pozole");
            detailView.putExtra("image_name" , R.drawable.pozole);
            this.startActivity(detailView);

        }


    }



}
