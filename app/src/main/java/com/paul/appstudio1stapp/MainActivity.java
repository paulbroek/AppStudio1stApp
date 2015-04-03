package com.paul.appstudio1stapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static com.paul.appstudio1stapp.R.*;


public class MainActivity extends ActionBarActivity {

    int invoerGetal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        final TextView uitvoerVeld = (TextView) findViewById(id.uitvoerVeld);
        Button startKnop = (Button) findViewById(id.newgameKnop);
        final Button raadKnop = (Button) findViewById(id.raadKnop);
        final EditText invoerVeld = (EditText) findViewById(R.id.invoerVeld);

        startKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invoerVeld.setText("");
                Random rand = new Random();
                final int waarde;
                waarde = rand.nextInt(100)+1;
                uitvoerVeld.setText("Random getal getrokken, doe een gok.");
                invoerGetal = 0;

                raadKnop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String input = invoerVeld.getText().toString();
                        // Input moet getal zijn
                        if (input.matches("[0-9]+")) {
                            invoerGetal = Integer.parseInt(input);
                            // Input tussen 0 en 100
                            if (0 <= invoerGetal && invoerGetal <= 100) {
                                if (invoerGetal == waarde)
                                    uitvoerVeld.setText("Goed geraden, het was " + waarde);
                                else if (invoerGetal > waarde)
                                    uitvoerVeld.setText("Te hoog");
                                else if (invoerGetal < waarde)
                                    uitvoerVeld.setText("Te laag");
                            }
                            else
                                uitvoerVeld.setText("Getal ligt tussen 0 en 100");
                        }
                        else
                            uitvoerVeld.setText("Geef een getal");


                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
