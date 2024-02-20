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
    private Button question;
    private Button adding;

    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.button2);
        adding = findViewById(R.id.button3);


        // Ajouter un écouteur de clic au bouton "question"
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //j'espère ca marche
                String randomQuestionText = Question.getRandomQuestionText();
                question.setText(randomQuestionText);
            }
        });

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adding = new Intent(getApplicationContext(), AddingActivity.class);
                startActivity(adding);
            }
        });

        if (questionList.isEmpty()) {
            try {
                importQuestionsFromFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (questionList.isEmpty()) {
                Question question1 = new Question("Qui parmi nous a déjà essayé une boisson alcoolisée exotique?");
                Question question3 = new Question("Qui parmi nous a déjà participé à un jeu de société coquin?");
                Question question4 = new Question("Qui parmi nous a déjà fait un strip-tease ?");
                Question question5 = new Question("Qui parmi nous a déjà expérimenté un cocktail aphrodisiaque?");
                Question question6 = new Question("Qui parmi nous a déjà eu une aventure d'un soir?");
                Question question7 = new Question("Qui parmi nous a déjà fréquenté un club échangiste?");
                Question question8 = new Question("Qui parmi nous préfère l'alcool pur aux cocktails?");
                Question question9 = new Question("Qui parmi nous a déjà pratiqué le pole dance?");
                Question question10 = new Question("Qui parmi nous a déjà essayé des jeux de rôle érotiques?");
                Question question11 = new Question("Qui parmi nous a déjà participé a une relation plus partenaire ?");
                Question question13 = new Question("Qui parmi nous a déjà essayé des accessoires coquins?");
                Question question14 = new Question("Qui parmi nous a déjà fréquenté un bar à cocktails?");
                Question question15 = new Question("Qui parmi nous a déjà fait une dégustation de vins ou des caves?");
                Question question18 = new Question("Qui parmi nous a déjà participé à un strip poker?");
                Question question19 = new Question("Qui parmi nous a déjà fait du speed dating(plusieurs dates dans la même journée) ?");
                Question question20 = new Question("Qui parmi nous a déjà testé des aphrodisiaques?");
                Question question2 = new Question("Qui parmi pourrais avoir un animal de compagnie extraordinaire?");
                Question question40 = new Question("Qui parmi nous bois le plus de café ?");
                Question question60 = new Question("Qui parmi nous a déjà participé à un barathon?");
                Question question100 = new Question("Qui parmi nous a un talent artistique caché?");
                Question question12 = new Question("Qui parmi nous a déjà rencontré une célébrité insolite?");
                Question question150 = new Question("Qui parmi nous est passionné par la pornographie?");
                Question question17 = new Question("Qui parmi nous pourrais collectionner des objets insolites?");
                Question question200 = new Question("Qui parmi nous pourrais faire du camping sauvage?");
                Question question21 = new Question("Qui parmi nous pourrais faire du camping naturiste?");
                Question question29 = new Question("Qui parmi nous pourrait boire du vin au petit dej?");
                Question question34 = new Question("Qui parmi nous pourrait etre végétarien?");
                Question question210 = new Question("Qui parmi nous a déjà participé à une soirée masquée?");
                Question question25 = new Question("Qui parmi nous a déjà utilisé des applications de rencontres?");
                Question question27 = new Question("Qui parmi nous a déjà fait des choses a la vue de tous le monde");
                Question question28 = new Question("Qui parmi nous a déjà joué a des jeux de société érotiques?");
                Question question209 = new Question("Qui parmi nous a déjà expérimenté des massages sensuels?");
                Question question30 = new Question("Qui parmi nous a déjà eu une nuit folle à l'étranger?");
                Question question32 = new Question("Qui parmi nous a déjà participé à un atelier de danse sensuelle avec un ou une inconnue?");
                Question question33 = new Question("Qui parmi nous a déjà essayé des jeux de cartes érotiques?");
                Question question340 = new Question("Qui parmi nous a déjà eu une aventure avec un(e) collègue?");
                Question question39 = new Question("Qui parmi nous a déjà essayé des jeux de société sexuel pour couples?");
                Question question41 = new Question("Qui parmi nous a déjà tenté l'expérience d'une soirée déguisée érotique?");
                Question question43 = new Question("Qui parmi nous préfère les soirées en tête-à-tête aux grandes fêtes?");
                Question question44 = new Question("Qui parmi nous a déjà essayé des produits de massage comestibles?");
                Question question45 = new Question("Qui parmi nous a déjà utilisé des jouets intimes avec son partenaire?");
                Question question48 = new Question("Qui parmi nous a déjà visité un club de strip-tease?");
                Question question50 = new Question("Qui parmi nous a déjà pécho lors d'un voyage?");
                Question question51 = new Question("Qui parmi nous a déjà participé à un cours de yoga tantrique?");
                Question question53 = new Question("Qui parmi nous a déjà essayé des jeux de société érotiques en plein air?");
                Question question56 = new Question("Qui parmi nous a déjà joué à des jeux de rôle coquins en ligne?");
                Question question61 = new Question("Qui parmi nous a déjà expérimenté des jeux de coquins en réalité virtuelle?");
                Question question65 = new Question("Qui parmi nous a déjà essayé des aphrodisiaques à base de plantes?");
                Question question66 = new Question("Qui parmi nous a déjà visité un bar à thème sensuel?");
                Question question68 = new Question("Qui parmi nous a déjà participé à un atelier de cuisine aphrodisiaque?");
                Question question69 = new Question("Qui parmi nous a pécho en boîte snas jamais revoir la personne?");
                Question question70 = new Question("Qui parmi nous a déjà essayé des jeux de société érotiques en groupe?");
                Question question74 = new Question("Qui parmi nous a déjà expérimenté des massages à la bougie?");
                Question question79 = new Question("Qui parmi nous a déjà tenté l'expérience d'une séance photo érotique?");
                Question question83 = new Question("Qui parmi nous a déjà participé à une soirée échangiste?");
                Question question84 = new Question("Qui parmi nous préfères les dîners aux chandelles aux relations sexuels?");
                Question question87 = new Question("Qui parmi nous a déjà participé à une dégustation de chocolat aphrodisiaque?");
                Question question93 = new Question("Qui parmi nous a déjà participé à une soirée érotique sur la plage?");
                Question question96 = new Question("Qui parmi nous a déjà essayé des aphrodisiaques à base de chocolat?");
                Question question98 = new Question("Qui parmi nous a déjà participé à un cours de danse érotique?");
                Question question101 = new Question("Qui parmi nous a déjà essayé une boisson alcoolisée aux insectes?");
                Question question104 = new Question("Qui parmi nous a déjà expérimenté des massages avec des pierres chaudes?");
                Question question105 = new Question("Qui parmi nous aime les escapades romantiques dans des lieux abandonnés (URBEX) ?");
                Question question121 = new Question("Qui parmi nous a déjà participé à une séance de dégustation de chocolat dans l'obscurité?");
                Question question126 = new Question("Qui parmi nous préfère les soirées costumées avec des accessoires excentriques?");
                Question question143 = new Question("Qui parmi nous a déjà participé à une soirée BDSM?");
                Question question147 = new Question("Qui parmi nous aime recevoir des fessées?");
                Question question148 = new Question("Qui parmi nous aime donner des fessées?");
                Question question153 = new Question("Qui parmi nous a déjà le shibari ?");
                Question question162 = new Question("Qui parmi nous a déjà essayé des cocktails à base de substances illégales?");
                Question question163 = new Question("Qui parmi nous a déjà participer a une soirée avec une ambiance psychédélique?");
                Question question164 = new Question("Qui parmi nous a déjà participé à des activités créatives sous l'influence de substances ?");
                Question question165 = new Question("Qui parmi nous a déjà pécho parce qu'il/elle était sous l'influence de substances ?");
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
