/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadingTips;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiitinha
 */
public class Main {
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        courses.add("tira");
        courses.add("ohpe");
        courses.add("ohja");
        courses.add("jym");
        tags.add("geometry");
        tags.add("math");
        tags.add("ALgebra");
        
        Book a = new Book("Jonain keväänä herään","Tuomas Aitonurmi","Mielenterveysviikkoa vietetään parhaillaan. Katri Rauanjoen romaanissa Jonain keväänä herään (Atena 2016) perheenäiti Kerttu vaipuu talven tullessa masennukseen.",courses,tags,"123456");
        
        Video v = new Video("The hardest problem on the hardest test","3Blue1Brown",null,courses,tags,"https://www.youtube.com/watch?v=OkmNXy7er84");
        
        Podcast p = new Podcast("mumbling sokrates",null,null,null,null,"");
        System.out.println(a + "\n");
        System.out.println(v+ "\n");
        System.out.println(p + "\n");
    }
    
}