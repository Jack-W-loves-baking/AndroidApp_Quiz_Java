/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

/**
 * @author Jack Wang
 */
public class ScoreList {
    
    private String name;
    private String points;
    
    /**
     *
     */
    public ScoreList(){
        
    }
    
    /**
     *
     * @param name
     * @param points
     */
    public ScoreList(String name,String points){
        this.setName(name);
        this.setPoints(points);
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getPoints() {
        return points;
    }

    /**
     *
     * @param points
     */
    public void setPoints(String points) {
        this.points = points;
    }
    
    
}
