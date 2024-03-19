package com.example.grasteau;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {
    // id des question avec auto-incrémentation
    private static int nextId = 1;
    //dossier d'écriture du fichier dans notre cas le dossier téléchargement.
    static File ext = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    //création du fichier
    static File file = new File(ext + File.separator + "question.txt");
    private int id;
    private String text;

    // Liste pour stocker toutes les instances de Question
    public static List<Question> questionList = new ArrayList<>();

    public Question(String text) {
        this.id = nextId++;
        this.text = text;

        // Ajouter l'instance actuelle à la liste
        questionList.add(this);
    }
    //fonction qui retourn l'id d'une question
    public int getId() {
        return id;
    }
    //fonction qui donne l'id max de la liste de questions
    public static int getMaxId() {
        int maxId = 0;
        for (Question question : questionList) {
            if (question.getId() > maxId) {
                maxId = question.getId();
            }
        }
        return maxId;
    }
    //fonction qui retourne la question en texte de l'objet question
    public String getText() {
        return text;
    }
    public static String getRandomQuestionText() {
        if (questionList.isEmpty()) {
            return "Aucune question disponible";
        }

        Random random = new Random();
        int randomId = random.nextInt(getMaxId()) + 1;
        return getTextById(randomId);
    }

    // Méthode pour obtenir le texte à partir de l'ID
    public static String getTextById(int id) {
        for (Question question : questionList) {
            if (question.getId() == id) {
                return question.getText();
            }
        }
        return "Question non trouvée";
    }
    //méthode qui enregistre les questions dans le fichier local question.txt
    public static void saveQuestionsToFile() throws IOException {// méthode qui enregistre les question dans le fichier texte


        // Création du fichier s'il n'existe pas
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Question question : questionList) {
                writer.write(question.getText());
                writer.newLine();
            }
            writer.close();
        }
    }
    //méthode qui importe les question a partir du fichier local question.txt
    public static void importQuestionsFromFile() throws IOException { // méthode qui importe dans l'application les question dans le fichier texte
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                new Question(line);
            }
        reader.close();
        }



    }

    // mets a jour la liste de question
    private static void updateQuestion(int id, String text) {
        for (Question question : questionList) {
            if (question.getId() == id) {
                question.text = text;
                return;
            }
        }
    }
}

