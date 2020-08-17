/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.speech.nlp;

/**
 *
 * @author Sadeem
 */

import java.io.File;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.Result;
import java.net.URL;
import java.util.Scanner;

public class SpeechMain {

    
    public static void main(String[] args) throws Exception {

               
        File myFile = new File("C:/Users/Sadeem/Documents/Algorithm Design and Analysis (Advanced)/Project/SpeechRec/model_parameters/nlp.ci_cont"),
                file2 = new File("C:/Users/Sadeem/Documents/Algorithm Design and Analysis (Advanced)/Project/SpeechRec/etc/nlp.dic"),
                file3 = new File("C:/Users/Sadeem/Documents/Algorithm Design and Analysis (Advanced)/Project/SpeechRec/etc/nlp.lm");
        
        URL acousticPath = myFile.toURI().toURL(),
                dictionaryPath = file2.toURI().toURL(),
                LangModPath = file3.toURI().toURL();
        
        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath(acousticPath.toString());
        configuration.setDictionaryPath(dictionaryPath.toString());
        configuration.setLanguageModelPath(LangModPath.toString());
        
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);        
        recognizer.startRecognition(true);
        final Scanner scanner = new Scanner(System.in);
        String input ="" ;
        try{
            String word = "";
            System.out.println("enter C to exit:");
        while (true) {
            System.out.println("Say Something:");
            SpeechResult result = recognizer.getResult();
                word = result.getHypothesis();
                System.out.println("word:  "+word); 
                //wait or sleep - add later
        }
    
        }catch(Exception e){
            System.out.println("out of time! or memory");
            e.printStackTrace();}
    }
}
