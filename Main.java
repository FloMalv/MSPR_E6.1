package com.company;

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
            BufferedReader entree = new BufferedReader(new FileReader("/var/www/html/MSPR_E6.1/staff.txt"));
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
                BufferedReader entree = new BufferedReader(new FileReader("/var/www/html/MSPR_E6.1/"+ fileName + ".txt"));
                Scanner scan = new Scanner(entree);

                int index = 0;

                //lecture du fichier .txt de la personne
                while(scan.hasNextLine()) {
                    line = scan.nextLine();
                    //ajoute le info de la personne dans une liste
                    if (index < 4){
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
                String mousquettonCheck = "";
                String gantInterventionCheck = "";
                String ceintureSecuriteCheck = "";
                String detecteurMetauxCheck = "";
                String brassardSecuriteCheck = "";
                String lampeTorcheCheck = "";
                String gilletCheck = "";

                if (materielPersonne.contains("mousquetton")){
                    mousquettonCheck = "checked";
                }
                if (materielPersonne.contains("gant d'intervention")){
                    gantInterventionCheck = "checked";
                }
                if (materielPersonne.contains("ceinture de sécurité tactique")){
                    ceintureSecuriteCheck = "checked";
                }
                if (materielPersonne.contains("détecteur de métaux")){
                    detecteurMetauxCheck = "checked";
                }
                if (materielPersonne.contains("brassard de sécurité")){
                    brassardSecuriteCheck = "checked";
                }
                if (materielPersonne.contains("lampe torche")){
                    lampeTorcheCheck = "checked";
                }
                if (materielPersonne.contains("gillet pare balle")){
                    gilletCheck = "checked";
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
                        "<a href=\"C:\\Asgeir_exo\\index.html\"> Revenir à l'index </a>"+
                        "<main>\n" +
                        "<div class=\"partie_nom_photo\">\n" +
                        "<div class=\"name\">\n" +
                        // afficher le nom de la personne
                        "<h1>" + infoPersonne.get(0) + " " + infoPersonne.get(1) + "</h1>\n" +
                        "</div>\n" +

                        "<div class=\"photo\">\n" +
                        "<img src=\"\" />\n" +
                        "</div>\n" +
                        "</div>\n" +


                        "<div class=\"infos_checks\">\n" +
                        "<div class=\"info_check\">\n" +
                        "<label for=\"Mousqueton\">Mousqueton</label>\n" +
                        // vérifie si la personne a un mousquetton
                        "<input class=\"box\" type=\"checkbox\" id=\"Mousqueton\" name=\"Mousqueton\"disabled=\"disabled\" + " + mousquettonCheck + " \n" +
                        "</div>\n" +

                        "<div class=\"info_check\">\n" +
                        "<label for=\"Gant\">Gant d'intervention</label>\n" +
                        // vérifie si la personne a un des gants d'intervention
                        "<input type=\"checkbox\" id=\"Gant\" name=\"Gant\" disabled=\"disabled\" " + gantInterventionCheck + "\n" +
                        "</div>\n" +

                        "<div class=\"info_check\">\n" +
                        "<label for=\"Ceinture\">Ceinture de sécurité tactique</label>\n" +
                        // vérifie si la personne a une ceinture de sécurité
                        "<input type=\"checkbox\" id=\"Ceinture\" name=\"Ceinture\" disabled=\"disabled\" " + ceintureSecuriteCheck + "\n" +
                        "</div>\n" +

                        "<div class=\"info_check\">\n" +
                        "<label for=\"Détecteur\">Détecteur de métaux</label>\n" +
                        // vérifie si la personne a un détecteur à métaux
                        "<input type=\"checkbox\" id=\"Détecteur\" name=\"Détecteur\" disabled=\"disabled\" " + detecteurMetauxCheck + "\n" +
                        "</div>\n" +

                        "<div class=\"info_check\">\n" +
                        "<label for=\"Brassard\">Brassard de sécurité</label>\n" +
                        // vérifie si la personne a un brassard de sécurité
                        "<input type=\"checkbox\" id=\"Brassard\" name=\"Brassard\" disabled=\"disabled\" " + brassardSecuriteCheck + "\n" +
                        "</div>\n" +

                        "<div class=\"info_check\">\n" +
                        "<label for=\"Lampe\">Lampe torche</label>\n" +
                        // vérifie si la personne a une lampe torche
                        "<input type=\"checkbox\" id=\"Lampe\" name=\"Lampe\" disabled=\"disabled\" " + lampeTorcheCheck + "\n" +
                        "</div>\n" +

                        "<div class=\"info_check\">\n" +
                        "<label for=\"Gillet\">Gillet pare balle</label>\n" +
                        // vérifie si la personne a un gillet
                        "<input type=\"checkbox\" id=\"Gillet\" name=\"Gillet\" disabled=\"disabled\" " + gilletCheck + "\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</main>\n" +

                        "<!-- footer -->\n" +
                        "<footer>\n" +
                        "<div class=\"logo\">\n" +
                        //récupére l'image de la personne
                        "<img width=\"400\" height=\"400\" src=\"/var/www/html/MSPR_E6.1" + fileName + ".png\" />\n" + // chemin + filename + ".png"
                        "</div>\n" +
                        "</footer>\n" +
                        "</body>\n" +
                        "</html>\n"

                        //" </head>\n" +
                        //" <body>\n" +
                        //"<p>" + fichier + "</p>" +
                        //" </body>\n" +
                        //"</html>"
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