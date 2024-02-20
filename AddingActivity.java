package com.example.grasteau;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import android.view.View;
public class AddingActivity extends AppCompatActivity {

    private EditText editText;
    private Button retour;
    private Button enregistrer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);



        editText = findViewById(R.id.input_question);
        retour = findViewById(R.id.retour);
        enregistrer = findViewById(R.id.enregistrer);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();
                enregistrer.setText(enteredText);
                Question question = new Question(enteredText);
            }
        });
    }
}