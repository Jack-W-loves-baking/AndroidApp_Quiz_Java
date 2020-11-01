package com.example.quizlet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class stores user scores with their name
 *
 * @author Hareem Khanazmi 16946714
 * @author Jack Wang 19062259
 */

public class Score implements Serializable {
    private int point;
    private String name;
    private ArrayList<Score> sc;

    /**
     * This is the constructor of this class that is used to set the variables
     * pt and n with point and name of this class, respectively.
     *
     * @param pt
     * @param n
     */
    public Score(int pt, String n) {
        this.setPoint(pt);
        this.setName(n);
    }

    /**
     * This is the Setter method that allows us to access array of score outside of this class
     *
     * @return
     */
    public ArrayList<Score> getSc() {
        return sc;
    }

    /**
     * This is the setter method that sets array of scores with array of scores
     * of this class
     *
     * @param sc
     */
    public void setSc(ArrayList<Score> sc) {
        this.sc = sc;
    }

    /**
     * This is the getter method that allows us to access point outside of this class
     *
     * @return point
     */
    public int getPoint() {
        return point;
    }

    /**
     * This is the setter method that sets point with the point of this class
     *
     * @param point
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * This is the getter method that allows us to access name outside of this class
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method  that sets name with the name of this class
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This toString method returns a nice string representation of this class
     *
     * @return string representation
     */
    public String toString() {
        return "Scores:\n" + "\n Username:  " + this.getName() + "\n Points:  " + this.getPoint();
    }

}
