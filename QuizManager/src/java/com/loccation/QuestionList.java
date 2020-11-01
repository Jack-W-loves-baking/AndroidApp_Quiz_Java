/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

/**
 * This class takes inputs and stores it in the variables.
 *
 * @author Jack Wang
 */
public class QuestionList {

    //Define Varaiable 
    private int id;
    private String Questions;
    private String answers;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    /**
     * This is the Constructor for this class that sets all the variables
     *
     * @param Id
     * @param Quest
     * @param ans
     * @param op1
     * @param op2
     * @param op3
     * @param op4
     */
    public QuestionList(int Id, String Quest, String ans, String op1, String op2, String op3, String op4) {
        this.setId(Id);
        this.setQuestions(Quest);
        this.setAnswers(ans);
        this.setOption1(op1);
        this.setOption2(op2);
        this.setOption3(op3);
        this.setOption4(op4);
    }

    /**
     * This is Second Constructor for this class that sets the id and ques
     * variables.
     *
     * @param ID
     * @param ques
     */
    public QuestionList(int ID, String ques) {
        this.setId(ID);
        this.setQuestions(ques);
    }

    /**
     * This is the Third Constructor that sets ques to this class.
     *
     * @param Ques
     */
    QuestionList(String Ques) {
        this.setQuestions(Ques);
    }

    /**
     * This is the getter method that allows to us to use the data outside of
     * this class
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This is the setter method that sets the id with this class
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This is the getter method that allows us to access this Questions outside
     * of this class
     *
     * @return Questions
     */
    public String getQuestions() {
        return Questions;
    }

    /**
     * This is the setter method that will set Questions with this class
     *
     * @param Questions
     */
    public void setQuestions(String Questions) {
        this.Questions = Questions;
    }

    /**
     * This is the getter method that will allow us to access answers outside of
     * this class
     *
     * @return answers
     */
    public String getAnswers() {
        return answers;
    }

    /**
     * This is the setter method that sets the answers with Answers in this
     * class
     *
     * @param answers
     */
    public void setAnswers(String answers) {
        this.answers = answers;
    }

    /**
     * This is the getter method that will allow us to access option1 outside of
     * this class
     *
     * @return option1
     */
    public String getOption1() {
        return option1;
    }

    /**
     * This is the setter method that will set option1 with option1 of this
     * class
     *
     * @param option1
     */
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /**
     * This is the getter method that will allows us to access option2 outside
     * of this class
     *
     * @return option2
     */
    public String getOption2() {
        return option2;
    }

    /**
     * This is the setter method that sets option2 with option2 of this class
     *
     * @param option2
     */
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /**
     * This is the getter method that will allow us to access option3 outside of
     * this class
     *
     * @return option3
     */
    public String getOption3() {
        return option3;
    }

    /**
     * This is the setter method that sets option3 with option3 of this class
     *
     * @param option3
     */
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /**
     * This is the getter method that will allows us to access option4 outside
     * of this class
     *
     * @return option4
     */
    public String getOption4() {
        return option4;
    }

    /**
     * This is the setter method that sets option4 with option4 of this class
     *
     * @param option4
     */
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    /**
     * This is the toString method that returns a nice representation of this
     * class
     *
     * @return string representation
     */
    public String toString() {
        return "\nID  :" + this.getId() + "\nQuestion :\n" + this.getQuestions()+ "\nAnswers :\n" + this.getAnswers() + "\nOption1 :\n" + this.getOption1() + "\nOption2 :\n" + this.getOption2()
                + "\nOption3 :\n" + this.getOption3() + "\nOption4 :\n" + this.getOption4();
    }

}
