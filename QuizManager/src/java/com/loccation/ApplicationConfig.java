/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *This class contains Resource Files QuestionControl and QuestionInput
 * 
 * @author Jack Wang
 */
@javax.ws.rs.ApplicationPath("quizservice")
public class ApplicationConfig extends Application {

    /**
     *
     * @return resources
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.loccation.QuestionControl.class);
        resources.add(com.loccation.QuestionInput.class);
    }
    
}
