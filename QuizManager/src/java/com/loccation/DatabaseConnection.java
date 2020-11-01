/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class allows connect everything to the database
 * @author Jack Wang
 */
public class DatabaseConnection {

    //Define Variables
    private static final String url = "jdbc:derby://localhost:1527/Quiz;create=true";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    String tableName = "QUESTIONS";
    String tableName2 = "Scores";
    private static final String username = "dms3";
    private static final String password = "dms3";
    Connection conn;
    final String quote = "'";
    ArrayList<QuestionList> quesArray;
    ArrayList<ScoreList> ScoresArray;
    int val = 0;

    /**
     * This method will create connection with the database
     *
     * @throws ClassNotFoundException
     */
    public void createConnection() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(url + " connected....");

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method checks if the table inside the database exists
     *
     * @return tableExist
     * @throws SQLException
     */
    public boolean checkQuestionsTableExist() throws SQLException {

        boolean tableExist = false;

        //schema for new db is the login username in uppercases, in this case, DMS3
        DatabaseMetaData md = conn.getMetaData();
        ResultSet rs = md.getTables(null, "DMS3", tableName.toUpperCase(), null);

        //if table exists
        if (rs.next()) {
            tableExist = true;
        }

        return tableExist;

    }

    /**
     * This method creates the Questions table inside the database, if it does
     * not already exists.
     *
     */
    public void CreateDatabaseTable() {
        try {

            //if table does not exist, need to create a new table
            if (!checkQuestionsTableExist()) {
                Statement statement = conn.createStatement();
                Statement statementInsert = conn.createStatement();

                String sqlCreate = "create table \"DMS3\".QUESTIONS\n"
                        + "(\n"
                        + "	ID INTEGER not null primary key,\n"
                        + "	QUESTION LONG VARCHAR,\n"
                        + "	ANSWERS LONG VARCHAR,\n"
                        + "	OPTION1 LONG VARCHAR,\n"
                        + "	OPTION2 LONG VARCHAR,\n"
                        + "	OPTION3 LONG VARCHAR,\n"
                        + "	OPTION4 LONG VARCHAR\n"
                        + ")";

                statement.executeUpdate(sqlCreate);

                String Data = "INSERT INTO QUESTIONS(ID,QUESTION,ANSWERS,OPTION1,OPTION2,OPTION3,OPTION4)"
                        + "VALUES"
                        + "(1,'What is 3456 + 987?','4443','4445','4443','- 4443','4569'),"
                        + "(2,'What is 5678 - 9876 ?','- 4198','4125','4176','3946','- 4198'),"
                        + "(3,'What is 458 x 9 ?','4122','4125','4176','4122','- 4298'), "
                        + "(4,'Which city is the capital city of New Zealand ?','Wellington','Auckland','Wellington','Christchurch','Dunedin'), "
                        + "(5,'Which year did New Zealand win Rugby World Cup ?','1987','1967','1988','1987','1968'), "
                        + "(6,'What is the Maori name for New Zealand ?','Aotearoa','Whanau','Aotearoa','Aroha','Haka'), "
                        + "(7,'Who was the first person to climb Mt Everest ?','Sir Edmund Hillary','Sir Ernest Rutherford','Sir Edmund Hillary','Tenzing Norgay','Thomas Edison'), "
                        + "(8,'What is 89 + 5 ?','94','94','-94','95','-95'), "
                        + "(9,'What is 56 + 9 ?','65','-65','76','65','80'), "
                        + "(10,'What is 65 - 20 ?','45','-41','43','45','42') ";

                statement.executeUpdate(Data);
                System.out.println("Table created");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**
     * This method returns all the data from the Questions table
     *
     * @return quesArray
     * @throws SQLException
     */
    public ArrayList<QuestionList> QuestionsData() throws SQLException {

        String Quesquery = "SELECT * FROM DMS3.QUESTIONS";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Quesquery);
        quesArray = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String ques = rs.getString("question");
            String ans = rs.getString("answers");
            String option1 = rs.getString("option1");
            String option2 = rs.getString("option2");
            String option3 = rs.getString("option3");
            String option4 = rs.getString("option4");
            QuestionList ql = new QuestionList(id, ques, ans, option1, option2, option3, option4);
            quesArray.add(ql);

        }
        return quesArray;
    }

    /**
     * This method adds the questions inputted by manager into the database
     *
     * @param q
     * @param a
     * @param op1
     * @param op2
     * @param op3
     * @param op4
     * @throws ClassNotFoundException
     */
    public void addQuestion(String q, String a, String op1, String op2, String op3, String op4) throws ClassNotFoundException {
        try {
            createConnection();
            if (checkQuestionsTableExist()) {
                Statement statement = conn.createStatement();
                Statement statementInsert = conn.createStatement();

                PreparedStatement ps = conn.prepareStatement("SELECT ID FROM DMS3.QUESTIONS WHERE ID=(SELECT MAX(ID) FROM DMS3.QUESTIONS)");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    val = rs.getInt("ID");
                }

                String Data = "INSERT INTO QUESTIONS(ID,QUESTION,ANSWERS,OPTION1,OPTION2,OPTION3,OPTION4)"
                        + "VALUES"
                        + "(" + (val + 1) + ",'" + q + "','" + a + "','" + op1 + "','" + op2 + "','" + op3 + "','" + op4 + "')";

                statementInsert.executeUpdate(Data);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method returns a whole row from the Questions table for the matching
     * id.
     *
     * @param id
     * @return ques.toString()
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String SearchQuestion(int id) throws ClassNotFoundException, SQLException {
        createConnection();
        CreateDatabaseTable();
        QuestionList ques = null;
        String Quesquery = "SELECT * FROM DMS3.QUESTIONS WHERE ID = ?";
        PreparedStatement st = conn.prepareStatement(Quesquery);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            String q = rs.getString(2);
            String a = rs.getString(3);
            String o1 = rs.getString(4);
            String o2 = rs.getString(5);
            String o3 = rs.getString(6);
            String o4 = rs.getString(7);

            ques = new QuestionList(id, q, a, o1, o2, o3, o4);

        }
        return ques.toString();

    }

    /**
     * This method is used to delete a specific Questions from the database for
     * the matching id.
     *
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void DeleteQues(int id) throws SQLException, ClassNotFoundException {
        createConnection();
        CreateDatabaseTable();
        QuestionList ques = null;
         int result =CheckIDData(id);
        if(result==1){
            String Quesquery = "DELETE FROM DMS3.QUESTIONS WHERE ID = ?";
            PreparedStatement st = conn.prepareStatement(Quesquery);
            st.setInt(1, id);
            st.executeUpdate();
        }
        

    }
    
    /**
     * This method is used to check if the fourth data exist in the database
     * 
     * @param id
     * @return 0 or 1
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int CheckIDData(int id) throws ClassNotFoundException, SQLException{
        createConnection();
        CreateDatabaseTable();
        String Quesquery = "SELECT * FROM DMS3.QUESTIONS WHERE ID = ?";
        PreparedStatement st = conn.prepareStatement(Quesquery);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            if(rs.getString(1)==null){
                return 0;
            }else if(rs.getString(1)!=null){
               return 1;
            }
        }
        return 0;
        
    }
    
   

}
