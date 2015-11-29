package icl.test.htmlparser;

import java.io.File;
import java.io.IOException;  
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.select.Elements;

/**
* Java Program to parse/read HTML documents from File using Jsoup library.
* Jsoup is an open source library which allows Java developer to parse HTML
* files and extract elements, manipulate data, change style using DOM, CSS and
* JQuery like method.
*
* @author rchumarin
*/

public class HTMLParser {
    public static void main(String args[]) {
        
        Document html;
        String title = null;
        String h1 = null;
        String table = null;
        String url = null;       
        
        // JSoup Example 2 - Reading HTML page from URL
        
        Document doc;
        try {
            doc = Jsoup.connect(
                "http://zakupki.gov.ru/epz/order/notice/ea44/view/common-info.html"
                        + "?regNumber=0373200048615000010").get();
            
            url = doc.body().baseUri();
            table = doc.body().getElementsByTag("table").text();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("URL страница аукциона: " + url);
               
        TestRegexp.doMatch(table);
      
/*
        // JSoup Example 1 - Parse HTML String using JSoup library        
        String HTMLSTring = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>JSoup Example</title>"
                + "</head>"
                + "<body>"
                + "<table><tr><td><h1>HelloWorld</h1></tr>"                
                + "</table>"
                + "</body>"
                + "</html>";
  
        html = Jsoup.parse(HTMLSTring);
        title = html.title();
        h1 = html.body().getElementsByTag("h1").text();
  
        System.out.println("Input HTML String to JSoup :" + HTMLSTring);
        System.out.println("After parsing, Title : " + title);
        System.out.println("Afte parsing, Heading : " + h1);
*/
        
/*
        // JSoup Example 3 - Parsing an HTML file in Java
        //Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong        
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("login.html"), "ISO-8859-1");
        } catch (IOException e) {
            
            e.printStackTrace();
        } // right
        title = htmlFile.title();
        Element div = htmlFile.getElementById("login");
        String cssClass = div.className(); // getting class form HTML element

        System.out.println("Jsoup can also parse HTML file directly");
        System.out.println("title : " + title);
        System.out.println("class of div tag : " + cssClass);
*/ 
        
    }
}
