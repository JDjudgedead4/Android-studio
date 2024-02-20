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
    private static int nextId = 1;
    static File ext = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
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

    public int getId() {
        return id;
    }
    public static int getMaxId() {
        int maxId = 0;
        for (Question question : questionList) {
            if (question.getId() > maxId) {
                maxId = question.getId();
            }
        }
        return maxId;
    }
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
    public static void saveQuestionsToFile() throws IOException {


        // Create the file if it doesn't exist
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
    public static void importQuestionsFromFile() throws IOException {
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


    private static void updateQuestion(int id, String text) {
        for (Question question : questionList) {
            if (question.getId() == id) {
                question.text = text;
                return;
            }
        }
    }
}

