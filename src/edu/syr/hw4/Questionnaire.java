// SUID: 982212915
package edu.syr.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {
    class Questions{
        String question;
        QuestionType questionType;
        Questions(String text, QuestionType questionType){
            this.question =  text;
            this.questionType = questionType;
        }
        //This method will print the questions for user
        @Override
        public String toString(){
            return question;
        }
    }

    List<Questions> questions;
    public Questionnaire() {
        questions = new ArrayList<>();
    }
    // This method adds the true and false question to the list of questions
    public void addTrueFalseQuestion(String s) {
        questions.add(new Questions(s, QuestionType.TRUE_FALSE));
    }
    // This method adds the likert question to the list of questions
    public void addLikertQuestion(String s) {
        questions.add(new Questions(s, QuestionType.LIKERT));
    }
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (Questions question: questions) {
            System.out.println(question.toString());
            String response = "";
            while(true){
                try {
                    // Checks of the question is TRUE_FALSE or LIKERT and implements it accordingly
                    if(question.questionType == QuestionType.TRUE_FALSE){
                        System.out.println("Please respond with True or False.");
                        response = reader.readLine();
                        if(response.equalsIgnoreCase("true") || response.equalsIgnoreCase("false")){
                            // To store the answer in more readable way ignoring cases like "TRUe" "FaLSE"
                            if(response.toLowerCase().equals("false")){
                                response = "False";
                            }else{
                                response = "True";
                            }
                            break;
                        }else{
                            System.out.println("Please enter a valid response of True or False!");
                        }
                    } else if (question.questionType == QuestionType.LIKERT) {
                        System.out.println("1. Strongly Agree\n2. Somewhat Agree\n3. Neutral\n4. Somewhat Disagree\n5. Strongly Disagree");
                        response = reader.readLine();
                        int likert;
                        try{
                            likert = Integer.parseInt(response);
                            if(likert >= 1 && likert <= 5){
                                switch (likert){
                                    case 1: {
                                        response = "Strongly Agree";
                                        break;
                                    }
                                    case 2: {
                                        response = "Somewhat Agree";
                                        break;
                                    }
                                    case 3: {
                                        response = "Neutral";
                                        break;
                                    }
                                    case 4: {
                                        response = "Somewhat Disagree";
                                        break;
                                    }
                                    case 5:{
                                        response = "Strongly Disagree";
                                        break;
                                    }
                                }
                                break;
                            }else{
                                System.out.println("Invalid Input! Please enter number from 1 to 5");
                            }
                        }catch (NumberFormatException e) {
                            System.out.println("Invalid Input! Please enter a number");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            answers.add(response);
        }
        return answers;
    }

    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addTrueFalseQuestion("Are you awake?");
        q.addTrueFalseQuestion("Have you had coffee?");
        q.addTrueFalseQuestion("Are you ready to get to work?");
        q.addLikertQuestion("CSE 687 is awesome");
        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
    }
}
