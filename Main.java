//pp

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintWriter fluxSortie;
        String line = "";
        ArrayList<String> ListePersonne = new ArrayList<>();

        try {
            //récupére le fichier staff.txt
            BufferedReader entree = new BufferedReader(new FileReader("staff.txt"));
            Scanner scan = new Scanner(entree);

            //lis le fichier staff pour ajouter chaque personne dans une liste
            while(scan.hasNextLine()) {
                ListePersonne.add(scan.nextLine());
            }

            //génére la page d'index
            fluxSortie = new PrintWriter(new FileOutputStream("index.html"));
            fluxSortie.println(("<!DOCTYPE html>\n" +
                    "<html lang=\"fr\">\n" +
                    " <head>\n" +
                    "<meta charset=\"UTF-8\" />\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "<title>Page de présentation employé</title>\n" +
                    "<meta name=\"description\" content=\"Page de Présentation\" />\n" +

                    "<!-- Roboto -->\n" +
                    "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                    "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                    "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap\" rel=\"stylesheet\">\n" +

                    "<style>\n" +
                    "html{\n" +
                    " background-color: #659224;\n" +
                    "font-family: 'Roboto', sans-serif;\n" +
                    "}\n" +

                    "main{\n" +
                    "max-width: 1000px;\n" +
                    "margin: auto;\n" +
                    "}\n" +

                    "h1{\n" +
                    "font-size: 35px;\n" +
                    "}\n" +

                    "/* --- partie nom/photo --- */\n" +
                    ".partie_nom_photo{\n" +
                    "display: flex;\n" +
                    "justify-content: space-between;\n" +
                    "margin-top: 60px;\n" +
                    "margin-bottom: 25px;\n" +
                    "}\n" +

                    "/* --- partie nom --- */\n" +
                    ".name{\n" +
                    "display: block;\n" +
                    "background-color: #379EC1;\n" +
                    "border: 2px solid rgb(0, 0, 0);\n" +
                    "height: 65px;\n" +
                    "padding: 15px;\n" +
                    "}\n" +

                    "/* --- partie photo --- */\n" +
                    "/*.photo{\n" +
                    "height: 230px;\n" +
                    "width: 350px;\n" +
                    "border: 2px solid grey;\n" +
                    "overflow: hidden;\n" +
                    "position: relative;\n" +
                    "}*/\n" +

                    ".photo img{\n" +
                    "width: 150%;\n" +
                    "border: 2px solid rgb(0, 0, 0);\n" +
                    "/* position: absolute;\n" +
                    "top: 50%;\n" +
                    "left: 50%;\n" +
                    "transform: translate(-50%, -50%);*/\n" +
                    "}\n" +

                    ".photo:hover{\n" +
                    "transform: scale(1.3);\n" +
                    "}\n" +

                    "/* --- partie checkbox --- */\n" +
                    ".infos_checks{\n" +
                    "display: flex;\n" +
                    "max-width: 400px;\n" +
                    "flex-direction: column;\n" +
                    "justify-content: center;\n" +
                    "text-align: end;\n" +
                    "background-color: #379EC1;\n" +
                    "border: 2px solid  rgb(29, 28, 28);\n" +
                    "margin-top: 80px;\n" +
                    "margin-bottom: 40px;\n" +
                    "}\n" +

                    ".info_check{\n" +
                    "padding: 15px;\n" +
                    "}\n" +

                    "label{\n" +
                    "font-size: 20px;\n" +
                    "}\n" +

                    "/* --- footer --- */\n" +
                    "footer{\n" +
                    "display: flex;\n" +
                    "flex-direction: column;\n" +
                    "justify-content: center;\n" +
                    "align-items: center;\n" +
                    "height: 150px;\n" +
                    "background-color: rgb(0, 0, 0);\n" +
                    "color: white;\n" +
                    "}\n" +

                    "@media only screen and (max-width: 500px) \n" +
                    "{\n" +
                    ".partie_nom_photo{\n" +
                    "display: flex;\n" +
                    "flex-direction: column;\n" +
                    "}\n" +

                    ".name{\n" +
                    "margin-bottom: 25px;\n" +
                    "}\n" +
                    "}\n" +

                    "/* --- logo --- */\n" +
                    ".logo{\n" +
                    "width: 290px;\n" +
                    "height: 100%;\n" +
                    "}\n" +

                    "</style>\n" +
                    "</head>\n" +

                    "<body>\n" +
                    "<!-- main -->\n" +
                    "<main>\n" +
                    "<div class=\"partie_nom_photo\">\n" +
                    "<div class=\"name\">\n"
            ));

            //ajoute un lien vers la page html de la personne
            for (String fileName : ListePersonne){
                fluxSortie.println("<a href=\""+ fileName +".html\">" + fileName + "</a>" +
                        "<br>"
                );
            }

            // fin de la page index.html
            fluxSortie.println("</div>\n" +
                    "</main>\n" +
                    "</body>\n" +
                    "</html>\n");

            fluxSortie.close();

        }
        catch (Exception e){
            e.getMessage();
        }

        ArrayList<String> infoPersonne = new ArrayList<>();
        ArrayList<String> materielPersonne = new ArrayList<>();
        try {
            // regarde les infos pour chaque personne
            for (String fileName : ListePersonne){
                //récupére le fichier .txt de la personne
                BufferedReader entree = new BufferedReader(new FileReader( fileName + ".txt"));
                Scanner scan = new Scanner(entree);

                int index = 0;

                //lecture du fichier .txt de la personne
                while(scan.hasNextLine()) {
                    line = scan.nextLine();
                    //ajoute le info de la personne dans une liste
                    if (index <= 4){
                        infoPersonne.add(line);
                    }
                    //ajoute le matériel de la personne dans une liste
                    else {
                        materielPersonne.add(line);
                    }
                    index++;
                }

                entree.close();

                //verifie le matériel de la personne
                String mousquetonCheck = "";
                String gantsCheck = "";
                String menottesCheck = "";
                String cynoCheck = "";
                String brassardCheck = "";
                String lampeCheck = "";
                String talkyCheck = "";
                String kitCheck = "";
                String taserCheck = "";
                String lacrymoCheck = "";

                if (materielPersonne.contains("mousqueton")){
                    mousquetonCheck = "checked";
                }
                if (materielPersonne.contains("gants")){
                    gantsCheck = "checked";
                }
                if (materielPersonne.contains("menottes")){
                    menottesCheck = "checked";
                }
                if (materielPersonne.contains("cyno")){
                    cynoCheck = "checked";
                }
                if (materielPersonne.contains("brassard")){
                    brassardCheck = "checked";
                }
                if (materielPersonne.contains("lampe")){
                    lampeCheck = "checked";
                }
                if (materielPersonne.contains("talky")){
                    talkyCheck = "checked";
                }
                if (materielPersonne.contains("kit")){
                    kitCheck = "checked";
                }
                if (materielPersonne.contains("taser")){
                    taserCheck = "checked";
                }
                if (materielPersonne.contains("lacrymo")){
                    lacrymoCheck = "checked";
                }
                fluxSortie = new PrintWriter(new FileOutputStream(fileName + ".html"));
                fluxSortie.println(("<!DOCTYPE html>\n" +
                        "<html lang=\"fr\">\n" +
                        " <head>\n" +
                        "<meta charset=\"UTF-8\" />\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<title>Page de présentation employé</title>\n" +
                        "<meta name=\"description\" content=\"Page de Présentation\" />\n" +

                        "<!-- Roboto -->\n" +
                        "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                        "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                        "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap\" rel=\"stylesheet\">\n" +

                        "<style>" +
        "html {\n" +
            "background-image: url(\"securite.jpg\");\n" +
            "background-repeat: no-repeat;\n" +
            "background-size: 100% 105%;\n" +
            "font-family: 'Roboto', sans-serif;\n" +
            "padding: 0px;\n" +
            "margin: 0px;\n" +
        "}\n" +
        
        "main {\n" +
            "max-width: 100%;\n" +
        "}\n" +
        
        "h1 {\n" +
            "font-size: 85px;\n" +
            "color: #fff;\n" +
        "}\n" +
        "/* --- partie nom/photo --- */\n" +
        
        ".partie_nom_photo {\n" +
            "display: flex;\n" +
            "justify-content: left;\n" +
            "margin-top: 60px;\n" +
            "margin-bottom: 25px;\n" +
        "}\n" +
        "/* --- partie nom --- */\n" +
        
        ".name {\n" +
            "display: block;\n" +
            "height: 65px;\n" +
            "padding: 15px;\n" +
        "}\n" +
        "/* --- partie photo --- */\n" +
        
        ".photo img {\n" +
            "width: 100%;\n" +
            "padding-left: 20px;\n" +
        "}\n" +
        
        ".photo:hover {\n" +
            "transform: scale(1.3);\n" +
        "}\n" +
        "/* --- partie checkbox --- */\n" +
        
        ".infos_checks {\n" +
            "display: flex;\n" +
            "max-width: 50%;\n" +
            "flex-direction: column;\n" +
            "justify-content: left;\n" +
            "background-color: #379EC1;\n" +
            "border: 2px solid rgb(255, 255, 255);\n" +
            "border-radius: 20px;\n" +
            "margin-top: 80px;\n" +
            "margin-bottom: 40px;\n" +
        "}\n" +
        
        ".info_check {\n" +
            "padding: 15px;\n" +
        "}\n" +
        
        "label {\n" +
            "font-size: 20px;\n" +
        "}\n" +
        "/* --- footer --- */\n" +
        
        "footer {\n" +
            "display: flex;\n" +
            "flex-direction: column;\n" +
            "justify-content: center;\n" +
            "align-items: center;\n" +
            "height: 150px;\n" +
            "background-color: #659224;\n" +
            "border: 2px solid rgb(255, 255, 255);\n" +
            "border-radius: 20px;\n" +
            "color: white;\n" +
        "}\n" +
        
        "@media only screen and (max-width: 500px) {\n" +
            ".partie_nom_photo {\n" +
                "display: flex;\n" +
                "flex-direction: column;\n" +
            "}\n" +
            ".name {\n" +
                "margin-bottom: 25px;\n" +
            "}\n" +
        "}\n" +
        "/* --- logo --- */\n" +
        
        ".logo {\n" +
            "width: 290px;\n" +
            "height: 100%;\n" +
        "}\n" +
         "</style>\n" +
      "</head>\n" +

                        "<body>\n" +
                        "<!-- main -->\n" +
                        "<a href=\"index.html\"> Revenir à l'index </a>"+
                        "<main>\n" +
                        "<div class=\"partie_nom_photo\">\n" +
                        "<div class=\"name\">\n" +
                        // afficher le nom de la personne
                        "<h1>" + infoPersonne.get(0) + " " + infoPersonne.get(1) + "</h1>\n" +
                        "</div>\n" +

                        "<div class=\"photo\">\n" +
                        //récupére l'image de la personne
                        "<img width=\"400\" height=\"400\" src=\"" + fileName + ".jpg\" />\n" + // chemin + filename + ".png"
                        "</div>\n" +
                        "</div>\n" +


                        "<div class=\"infos_checks\">\n" +
                        "<label for=\"Mousqueton\">Mousqueton</label>\n" +
                        // vérifie si la personne a un mousquetton
                        "<input class=\"box\" type=\"checkbox\" id=\"Mousqueton\" name=\"Mousqueton\"disabled=\"disabled\" + " + mousquetonCheck + " \n" +



                        "<label for=\"Gant\">Gants d'intervention</label>\n" +
                        // vérifie si la personne a un des gants d'intervention
                        "<input type=\"checkbox\" id=\"Gant\" name=\"Gant\" disabled=\"disabled\" " + gantsCheck + "\n" +



                        "<label for=\"Menottes\">Port menottes</label>\n" +
                        // vérifie si la personne les menottes
                        "<input type=\"checkbox\" id=\"menottes\" name=\"menottes\" disabled=\"disabled\" " + menottesCheck + "\n" +


                        "<label for=\"Cyno\">Cyno bandeau agent cynophile</label>\n" +
                        // vérifie si la personne a un cyno
                        "<input type=\"checkbox\" id=\"cyno\" name=\"xyno\" disabled=\"disabled\" " + cynoCheck + "\n" +
   

    
                        "<label for=\"Brassard\">Brassard de sécurité</label>\n" +
                        // vérifie si la personne a un brassard de sécurité
                        "<input type=\"checkbox\" id=\"Brassard\" name=\"Brassard\" disabled=\"disabled\" " + brassardCheck + "\n" +
   


                        "<label for=\"Lampe\">Lampe torche</label>\n" +
                        // vérifie si la personne a une lampe torche
                        "<input type=\"checkbox\" id=\"Lampe\" name=\"Lampe\" disabled=\"disabled\" " + lampeCheck + "\n" +
  


                        "<label for=\"Talkies walkies\">Talkies walkies</label>\n" +
                        // vérifie si la personne a un talky
                        "<input type=\"checkbox\" id=\"talky\" name=\"talky\" disabled=\"disabled\" " + talkyCheck + "\n" +
             
                                    
  
                        "<label for=\"kit\">Kit oreillette</label>\n" +
                        // vérifie si la personne a un kit
                        "<input type=\"checkbox\" id=\"kit\" name=\"kit\" disabled=\"disabled\" " + kitCheck + "\n" +
        

                        
     
                        "<label for=\"taser\">Tasers</label>\n" +
                        // vérifie si la personne a un taser
                        "<input type=\"checkbox\" id=\"taser\" name=\"taser\" disabled=\"disabled\" " + taserCheck + "\n" +
      

                        "<div class=\"infos_checks\">\n" +
                        "<label for=\"lacrymo\">Bombes lacrymogènes</label>\n" +
                        // vérifie si la personne a une lacrymo
                        "<input type=\"checkbox\" id=\"lacrymo\" name=\"lacrymo\" disabled=\"disabled\" " + lacrymoCheck + "\n" +
                        "</div>\n" +
                        "</main>\n" +

                        "<!-- footer -->\n" +
                        "<footer>\n" +
                        "<div class=\"logo\">\n" +
                        "<img src=\"gosecuri.PNG\" />\n" +
                        "</div>\n" +
                                    
                        "</footer>\n" +
                        "</body>\n" +
                        "</html>\n"

                    
                ));

                fluxSortie.close();//marque les flux sur le fichier physique.
                //ListePersonne.add(scan.nextLine());
                infoPersonne.clear();
                materielPersonne.clear();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Le fichier n'a pas pu être lu.");
        }
    }
}
