/*
    Name: Aman Velani
    SUID: 982212915
*/

package edu.syr.hw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Question {
    private String q;
    private String prompt;
    private List<String> acceptableAnswers;

    // Static inner class for prompts
    static class Prompts{
        public static final String TRUE_FALSE_PROMPT = "True or False: ";
        public static final String LIKERT_PROMPT = "Give you opinion on the following likert scale: \n1. Strongly Agree\n2. Somewhat Agree\n3. Neutral\n4. Somewhat Disagree\n5. Strongly Disagree";
    }


    public Question(String q, String prompt, List<String> acceptable) {
        if(q == null || q.equals("")) throw new IllegalArgumentException();
        if(prompt == null || prompt.equals("")) throw new IllegalArgumentException();
        if(acceptable == null || acceptable.size() == 0) throw new IllegalArgumentException();
        this.q = q;
        this.prompt = prompt;
        this.acceptableAnswers = acceptable;
    }
    public String getPrompt() {
        return prompt;
    }
    public void render(PrintStream p) {
        p.println(q);
        p.println(prompt);
    }

    // This method is used to check if the user input is valid
    public boolean isAcceptableAnswer(String s) {
        if(this.prompt.equals(Question.Prompts.TRUE_FALSE_PROMPT)) {
            try {
                s = s.toLowerCase();
                if(acceptableAnswers.contains(s)){
                    return true;
                }else{
                    System.out.println("Invalid Input! Please enter a valid response of True or False!");
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            }
        }else if(this.prompt.equals(Question.Prompts.LIKERT_PROMPT)){
            int responseInt = Integer.parseInt(s);
            try {
                if(responseInt >= 1 && responseInt <= 5) {
                    return true;
                }else{
                    System.out.println("Invalid Input! Please enter a number from 1 to 5");
                    return false;
                }
            } catch (NumberFormatException e) {

                return false;
            }catch (Exception e){
                System.out.println("Unknown Error!");
                return false;
            }
        }
        else {
            if(acceptableAnswers.contains(s)){
                return true;
            }else{
                System.out.println("Invalid Input! Please enter a valid response!");
                return false;
            }
        }
    }
}
public class Questionnaire {
    List<Question> questions;
    public Questionnaire() {
        questions = new ArrayList<>();
    }
    public void addQuestion(Question q) {
        questions.add(q);
    }
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (Question q: questions) {
            q.render(System.out);
            String response = "";
            do {
                try {
                    response = reader.readLine();
                } catch (IOException e) {
                    System.out.println("Enter valid Input!");
                    e.printStackTrace();
                }
            } while (!q.isAcceptableAnswer(response));
            if(q.getPrompt().equals(Question.Prompts.TRUE_FALSE_PROMPT)){
                response = response.toLowerCase().startsWith("t") ? "True" : "False";
            } else if (q.getPrompt().equals(Question.Prompts.LIKERT_PROMPT)){
                String[] possibleResponse = {"Strongly Agree", "Somewhat Agree", "Neutral", "Somewhat Disagree", "Strongly Disagree"};
                int responseInt = Integer.parseInt(response);
                response = possibleResponse[responseInt - 1];
            }
            answers.add(response);
        }
        return answers;
    }

    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addQuestion(new Question("Are you awake?", Question.Prompts.TRUE_FALSE_PROMPT , Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("Have you had coffee?", Question.Prompts.TRUE_FALSE_PROMPT, Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("Are you ready to get to work?", Question.Prompts.TRUE_FALSE_PROMPT, Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("CSE 687 is awesome", Question.Prompts.LIKERT_PROMPT, Arrays.asList("1","2","3","4","5")));
//        q.addQuestion(new Question("CSE 687 is easy", "True or False: ", Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
//        q.addQuestion(new Question("CSE 687 is difficult", "1 or 0: ", Arrays.asList("1", "0")));

        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
    }
}

