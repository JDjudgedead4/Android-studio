package com.example.grasteau;

import static com.example.grasteau.Question.saveQuestionsToFile;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import java.io.IOException;

public class AddingActivity extends AppCompatActivity {

    private EditText editText; //champ de texte input des question
    private Button retour; //bouton de précédente
    private Button enregistrer; //boutton qui enregistre les questions


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);


        //déclaration des composants
        editText = findViewById(R.id.input_question);
        retour = findViewById(R.id.retour);
        enregistrer = findViewById(R.id.enregistrer);
        //action de retour
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        //action d'enregistrement des questions
        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();
                Question question = new Question(enteredText);
                editText.setText("");
                try {
                    saveQuestionsToFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}