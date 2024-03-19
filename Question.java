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
	// Question ID with auto-increment
    private static int nextId = 1;
	// Directory to write the file, in this case the Downloads folder
    static File ext = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	// The question file
    static File file = new File(ext + File.separator + "question.txt");
    private int id;
    private String text;

	// List to store all Question instances
    public static List<Question> questionList = new ArrayList<>();

    public Question(String text) {
        this.id = nextId++;
        this.text = text;

	  // Add the current instance to the list
        questionList.add(this);
    }
	// Function that returns the ID of a question
    public int getId() {
        return id;
    }
	// Function that gives the maximum ID of the question list
    public static int getMaxId() {
        int maxId = 0;
        for (Question question : questionList) {
            if (question.getId() > maxId) {
                maxId = question.getId();
            }
        }
        return maxId;
    }
	// Function that returns the question text of the question object
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

	// Method to get the text from the ID
    public static String getTextById(int id) {
        for (Question question : questionList) {
            if (question.getId() == id) {
                return question.getText();
            }
        }
        return "Question non trouvée";
    }
	// Method that saves questions to the local file question.txt
    public static void saveQuestionsToFile() throws IOException {// méthode qui enregistre les question dans le fichier texte


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
	// Method that imports questions from the local file question.txt
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

	// Updates the question list
    private static void updateQuestion(int id, String text) {
        for (Question question : questionList) {
            if (question.getId() == id) {
                question.text = text;
                return;
            }
        }
    }
}

