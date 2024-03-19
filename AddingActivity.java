package com.example.grasteau;

import static com.example.grasteau.Question.saveQuestionsToFile;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import java.io.IOException;

public class AddingActivity extends AppCompatActivity {

    private EditText editText; // Text field for question input
    private Button retour; // Button for going back
    private Button enregistrer; // Button to save questions


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);


         // Initialize components
        editText = findViewById(R.id.input_question);
        retour = findViewById(R.id.retour);
        enregistrer = findViewById(R.id.enregistrer);
        // Back button action
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
         // Save question button action
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