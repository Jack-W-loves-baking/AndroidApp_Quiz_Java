package com.example.quizlet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the Questions class that is used to take the question from restful website and stores it.
 *
 * @author Hareem Khanazmi 16946714
 * @author Jack Wang 19062259
 */
public class Questions implements Serializable {
    //Define variables
    private String id;
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private ArrayList<Questions> questSet;


    /**
     * This is the defualt constructor of this class that is used to call this
     * class
     */
    public Questions() {

    }

    /**
     * This Constructor is used to set variables of this class with the variables of json data
     *
     * @param id
     * @param question
     * @param answer
     * @param op1
     * @param op2
     * @param op3
     * @param op4
     */
    public Questions(String id, String question, String answer, String op1, String op2, String op3, String op4) {
        this.setId(id);
        this.setQuestion(question);
        this.setAnswer(answer);
        this.setOption1(op1);
        this.setOption2(op2);
        this.setOption3(op3);
        this.setOption4(op4);
    }

    /**
     * This is the getter method for Questions array that allows us to access this arraylist outside
     * of this class
     *
     * @return questSet
     */
    public ArrayList<Questions> getQuestSet() {
        return questSet;
    }

    /**
     * This is the setter method for Questions array that sets the questions arraylist with questions
     * arraylist of this class
     *
     * @param questSet
     */
    public void setQuestSet(ArrayList<Questions> questSet) {
        this.questSet = questSet;
    }

    /**
     * This is the getter method for id that allows us to access id outside of this class
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * This is the setter method for Id that sets id with the id of this class
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This is the getter method of Question that allows us to access questions outside of this
     * class
     *
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This is the Setter method for Question that sets question with the questions of this class
     *
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * This is the getter method of answer that allows us to access answer outside of this
     * this class
     *
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This is the Setter method for answer that sets answer with the answer of this class
     *
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * This is the getter method of option1 that allows us to access option1 outside of this
     * this class
     *
     * @return option1
     */
    public String getOption1() {
        return option1;
    }

    /**
     * This is the Setter method for option1 that sets option1 with the option1 of this class
     *
     * @param option1
     */
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /**
     * This is the getter method of option2 that allows us to access option2 outside of this
     * this class
     *
     * @return option2
     */
    public String getOption2() {
        return option2;
    }

    /**
     * This is the Setter method for option2 that sets option2 with the option2 of this class
     *
     * @param option2
     */
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /**
     * This is the getter method of option3 that allows us to access option3 outside of this
     * this class
     *
     * @return option3
     */
    public String getOption3() {
        return option3;
    }

    /**
     * This is the Setter method for option3 that sets option3 with the option3 of this class
     *
     * @param option3
     */
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /**
     * This is the getter method of option4 that allows us to access option4 outside of this
     * this class
     *
     * @return option4
     */
    public String getOption4() {
        return option4;
    }

    /**
     * This is the Setter method for option4 that sets option4 with the option4 of this class
     *
     * @param option4
     */
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    /**
     * This method returns a nice string representation of this class
     *
     * @return string representation
     */
    public String toString() {
        return " " + this.getQuestion();
    }


}
