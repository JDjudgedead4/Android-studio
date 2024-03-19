package com.example.grasteau;

import static com.example.grasteau.Question.importQuestionsFromFile;
import static com.example.grasteau.Question.questionList;
import static com.example.grasteau.Question.saveQuestionsToFile;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity"; // Tag pour les logs
    private Button question; //bouton qui contient les questions et permet de passer a la suivante
    private Button adding; //bouton d'ajout des questions

    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.button2);
        adding = findViewById(R.id.button3);


        // Ajouter un écouteur de clic au bouton "question" passe a la question suivante
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomQuestionText = Question.getRandomQuestionText();
                question.setText(randomQuestionText);
            }
        });
        // Ajouter un écouteur de clic au bouton "adding" qui ouvre la vue d'ajout des questions
        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adding = new Intent(getApplicationContext(), AddingActivity.class);
                startActivity(adding);
            }
        });
        //récupération des question depuis le fichier text, les questions peuvent etre modifier depuis ce meme fichier text stocker en local sans passer par le code.
        if (questionList.isEmpty()) {
            try {
                importQuestionsFromFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (questionList.isEmpty()) {// cas ou les questions ne sont pas enregistrer ou que le fichier a été supprimer
                Question question1 = new Question("Qui parmi nous a déjà essayé une boisson alcoolisée exotique?");
                Question question3 = new Question("Qui parmi nous a déjà participé à un jeu de société coquin?");
                Question question4 = new Question("Qui parmi nous a déjà fait un strip-tease ?");
                Question question5 = new Question("Qui parmi nous a déjà expérimenté un cocktail aphrodisiaque?");
                Question question6 = new Question("Qui parmi nous a déjà eu une aventure d'un soir?");
                Question question7 = new Question("Qui parmi nous a déjà fréquenté un club échangiste?");
                Question question10 = new Question("Qui parmi nous a déjà essayé des jeux de rôle érotiques?");
                Question question13 = new Question("Qui parmi nous a déjà essayé des accessoires coquins?");
                Question question15 = new Question("Qui parmi nous a déjà fait une dégustation de vins ou des caves?");
                Question question18 = new Question("Qui parmi nous a déjà participé à un strip poker?");
                Question question19 = new Question("Qui parmi nous a déjà fait du speed dating(plusieurs dates dans la même journée) ?");
                Question question2 = new Question("Qui parmi pourrais avoir un animal de compagnie extraordinaire?");
                Question question40 = new Question("Qui parmi nous bois le plus de café ?");
                Question question60 = new Question("Qui parmi nous a déjà participé à un barathon?");
                Question question100 = new Question("Qui parmi nous a un talent artistique caché?");
                Question question200 = new Question("Qui parmi nous pourrais faire du camping sauvage?");
                Question question21 = new Question("Qui parmi nous pourrais faire du camping naturiste?");
                Question question29 = new Question("Qui parmi nous pourrait boire de l'alcool au petit dej?");
                Question question34 = new Question("Qui parmi nous pourrait etre vegan?");
                Question question25 = new Question("Qui parmi nous a déjà utilisé des applications de rencontres?");
                Question question27 = new Question("Qui parmi nous a déjà fait des choses a la vue de tous le monde");
                Question question30 = new Question("Qui parmi nous a déjà eu une nuit folle à l'étranger?");
                Question question32 = new Question("Qui parmi nous a déjà participé à une danse sensuelle avec un ou une inconnue?");
                Question question340 = new Question("Qui parmi nous a déjà eu une aventure avec un(e) collègue?");
                Question question48 = new Question("Qui parmi nous a déjà visité un club de strip-tease?");
                Question question50 = new Question("Qui parmi nous a déjà pécho lors d'un voyage à l'étranger?");
                Question question51 = new Question("Qui parmi nous a déjà participé à un cours de yoga tantrique?");
                Question question56 = new Question("Qui parmi nous a déjà joué à des jeux de rôle coquins en ligne?");
                Question question61 = new Question("Qui parmi nous a déjà expérimenté des jeux de coquins en réalité virtuelle?");
                Question question68 = new Question("Qui parmi nous a déjà participé à un atelier de cuisine aphrodisiaque?");
                Question question69 = new Question("Qui parmi nous a pécho en boîte sans jamais revoir la personne?");
                Question question79 = new Question("Qui parmi nous a déjà tenté l'expérience d'une séance photo érotique?");
                Question question83 = new Question("Qui parmi nous a déjà participé à une soirée échangiste?");
                Question question104 = new Question("Qui parmi nous a déjà expérimenté des massages avec des pierres chaudes?");
                Question question105 = new Question("Qui parmi nous aime les escapades romantiques dans des lieux abandonnés (URBEX) ?");
                Question question143 = new Question("Qui parmi nous a déjà participé à une soirée BDSM?");
                Question question147 = new Question("Qui parmi nous aime recevoir des fessées?");
                Question question148 = new Question("Qui parmi nous aime donner des fessées?");
                Question question153 = new Question("Qui parmi nous a déjà le shibari ?");
                Question question162 = new Question("Qui parmi nous a déjà essayé des cocktails à base de substances illégales?");
                Question question163 = new Question("Qui parmi nous a déjà participer a une soirée avec une ambiance psychédélique?");
                Question question1000 = new Question("Qui parmi nous a déjà été pris(e) en flagrant délit ?");
                Question question1001 = new Question("Qui parmi nous a déjà fait quelque chose de qui lui a couté chère pour gagner un pari? ");
                try {
                    saveQuestionsToFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else
            try {
                saveQuestionsToFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "L'activité est de retour d'une pause");
    }
}
