import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main  {

    public static void main(String[] args)  {

     GridLayout xGrid = new GridLayout(4,1, 10, 10);
     JFrame window = new JFrame();
     window.setSize(1024,800);
     window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


     JPanel panel1 = new JPanel(xGrid);
     JButton button1 = new JButton("kolla saker");

     JTextField namn = new JTextField("namn: ");
     JTextField telefonnummer = new JTextField("telefonnummer: ");
     JTextField epost = new JTextField("epost: ");
     JTextField javaRegex = new JTextField("skriv system out osv");
     JTextField javaRegexIF = new JTextField("if vilkor");
     JTextField javaRegexFOR = new JTextField("for villkor");
     JTextField javaRegexDO = new JTextField("do villkor");



     namn.setColumns(20);
     telefonnummer.setColumns(20);
     epost.setColumns(20);

     button1.setSize(20,10);

     panel1.add(namn);
     panel1.add(telefonnummer);
     panel1.add(epost);
     panel1.add(javaRegex);
     panel1.add(javaRegexIF);
     panel1.add(javaRegexFOR);
     panel1.add(javaRegexDO);


     panel1.add(button1);

     window.add(panel1);
     window.setVisible(true);

     String patternEmail = "\\@";
     String patternNamn = "[^0-9]";
     String patternTelefonnummer = "[0-9]";
     String patternJava = "(?i)[A-Z0-9]+\\.(?i)[A-Z0-9]+\\.(?i)[A-Z0-9]+\\s*\\(\\)\\;";
     String patternIF = "(?i)if\\s*\\([\\w\\W\\s]+\\)\\s*\\{[\\w\\W\\s]+\\}\\s*(else\\{[\\w\\W\\s]+\\})*\\s*";
     String patternFOR = "(?i)for\\s*\\([\\w\\W\\s]+(\\;[\\w\\W\\s]+)*\\)\\s*\\{[\\w\\W\\s]+\\}";
     String patternDO = "(?i)do\\s*\\{[\\w\\W\\s]+\\}\\s*while\\s*\\([\\w\\W\\s]+\\)";


     ActionListener buttonlisener = e -> {
         String a = namn.getText();
         String b = telefonnummer.getText();
         String c = epost.getText();
         String d = javaRegex.getText();
         String ee = javaRegexIF.getText();
         String eee = javaRegexFOR.getText();
         String eeee = javaRegexDO.getText();


         if(finder(a,patternNamn)){
           namn.setText(a +" är en korrekt namn!");
         } else namn.setText("felaktig namn");



         if(finder(b,patternTelefonnummer)){
             telefonnummer.setText(b +" är en korrekt nummer!");
         } else telefonnummer.setText("felaktig nummer");



         if(finder(c,patternEmail)){
             epost.setText(c +" är en korrekt email!");
         } else epost.setText("felaktig email");



         if(finder(d, patternJava)){

             String testX = "";

             for(int i =0; i < d.length(); i++ ){
                 if(Character.isLetter(d.charAt(i))){
                     testX = testX + String.valueOf(d.charAt(i));
                 }else if(Character.isDigit(d.charAt(i))){
                     testX = testX + String.valueOf(d.charAt(i));
                 }

                 char TY = d.charAt(i);

                 switch(TY)  {
                     case '.':
                     testX = testX + "\\\\.";
                     break;
                     case'(':
                     testX = testX + "\\\\(";
                     case')':
                     testX = testX + "\\\\)";
                     break;
                     case';':
                     testX = testX + "\\\\;";
                     break;
                 }
             }

             javaRegex.setText(testX);

         } else javaRegex.setText("fel");




         if(finder(ee,patternIF)){

             String testXX = "";

             for(int i =0; i < ee.length(); i++ ){
                 if(Character.isLetter(ee.charAt(i))){
                     testXX = testXX + String.valueOf(ee.charAt(i));
                 }else if(Character.isDigit(ee.charAt(i))){
                     testXX = testXX + String.valueOf(ee.charAt(i));
                 }

                 char TY = ee.charAt(i);

                 switch(TY)  {
                     case '.':
                         testXX = testXX + "\\\\.";
                         break;
                     case'(':
                         testXX = testXX + "\\\\(";
                     case')':
                         testXX = testXX + "\\\\)";
                         break;
                     case';':
                         testXX = testXX + "\\\\;";
                         break;
                     case'}':
                         testXX = testXX + "\\\\}";
                         break;
                     case'{':
                         testXX = testXX + "\\\\{";
                         break;
                     case'<':
                         testXX = testXX + "\\\\<";
                         break;
                     case'>':
                         testXX = testXX + "\\\\>";
                         break;
                     case'=':
                         testXX = testXX + "\\\\=";
                         break;

                 }
             }
             javaRegexIF.setText(testXX);
         } else javaRegexIF.setText("felaktig IF");



         if(finder(eee,patternFOR)){

             String testXXX = "";

             for(int i =0; i < eee.length(); i++ ){
                 if(Character.isLetter(eee.charAt(i))){
                     testXXX = testXXX + String.valueOf(eee.charAt(i));
                 }else if(Character.isDigit(eee.charAt(i))){
                     testXXX = testXXX + String.valueOf(eee.charAt(i));
                 }

                 char TY = eee.charAt(i);

                 switch(TY)  {
                     case '.':
                         testXXX = testXXX + "\\\\.";
                         break;
                     case'(':
                         testXXX = testXXX + "\\\\(";
                     case')':
                         testXXX = testXXX + "\\\\)";
                         break;
                     case';':
                         testXXX = testXXX + "\\\\;";
                         break;
                     case'}':
                         testXXX = testXXX + "\\\\}";
                         break;
                     case'{':
                         testXXX = testXXX + "\\\\{";
                         break;
                     case'<':
                         testXXX = testXXX + "\\\\<";
                         break;
                     case'>':
                         testXXX = testXXX + "\\\\>";
                         break;
                     case'=':
                         testXXX = testXXX + "\\\\=";
                         break;
                 }
             }
             javaRegexFOR.setText(testXXX);
         } else javaRegexFOR.setText("felaktig FOR");



         if(finder(eeee,patternDO)){

             String testXXXX = "";

             for(int i =0; i < eeee.length(); i++ ){
                 if(Character.isLetter(eeee.charAt(i))){
                     testXXXX = testXXXX + String.valueOf(eeee.charAt(i));
                 } else if(Character.isDigit(eeee.charAt(i))){
                     testXXXX = testXXXX + String.valueOf(eeee.charAt(i));
                 }

                 char TY = eeee.charAt(i);

                 switch(TY)  {
                     case '.':
                         testXXXX = testXXXX + "\\\\.";
                         break;
                     case'(':
                         testXXXX = testXXXX + "\\\\(";
                     case')':
                         testXXXX = testXXXX + "\\\\)";
                         break;
                     case';':
                         testXXXX = testXXXX + "\\\\;";
                         break;
                     case'}':
                         testXXXX = testXXXX + "\\\\}";
                         break;
                     case'{':
                         testXXXX = testXXXX + "\\\\{";
                         break;
                     case'<':
                         testXXXX = testXXXX + "\\\\<";
                         break;
                     case'>':
                         testXXXX = testXXXX + "\\\\>";
                         break;
                     case'=':
                         testXXXX = testXXXX + "\\\\=";
                         break;
                 }
             }
             javaRegexDO.setText(testXXXX);
         } else javaRegexDO.setText("felaktig DO");




     };

     button1.addActionListener(buttonlisener);

    }

    public static boolean finder (String myString, String pattern){

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        if(matcher.find()){
            return true;
        } else return false;


    }


}
