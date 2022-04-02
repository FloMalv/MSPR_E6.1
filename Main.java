//package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintWriter fluxSortie;
        String fichier = "";
        ArrayList<String> ListePersonne = new ArrayList<>();
        try {
            BufferedReader entree = new BufferedReader(new FileReader("C:\\Users\\Public\\staff.txt"));
            Scanner scan = new Scanner(entree);

            while(scan.hasNextLine()) {
                //fichier = fichier + scan.nextLine() + " ";
                ListePersonne.add(scan.nextLine());
            }
            System.out.println("liste : " + ListePersonne);
        }
        catch (Exception e){
            e.getMessage();
        }
        try {
            for (String test : ListePersonne){
                fichier = "";
                BufferedReader entree = new BufferedReader(new FileReader("C:\\Users\\Public\\"+ test + ".txt"));
                Scanner scan = new Scanner(entree);

                while(scan.hasNextLine()) {
                    fichier = fichier + scan.nextLine() + " ";
                    fluxSortie = new PrintWriter(new FileOutputStream(test +".html"));
                    fluxSortie.println(("<!DOCTYPE html>\n" +
                            "<html lang=\"fr\">\n" +
                            " <head>\n" +
                            "<meta charset=\"UTF-8\" />\n"+
                            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"+
                            "<title>Page de présentation employé</title>\n"+
                            "<meta name=\"description\" content=\"Page de Présentation\" />\n"+

                            "<!-- Roboto -->\n"+
                            "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"+
                            "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"+
                            "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap\" rel=\"stylesheet\">\n"+

                            "<style>\n"+
                            "html{\n"+
                            " background-color: #659224;\n"+
                            "font-family: 'Roboto', sans-serif;\n"+
                            "}\n"+

                            "main{\n"+
                            "max-width: 1000px;\n"+
                            "margin: auto;\n"+
                            "}\n"+

                            "h1{\n"+
                            "font-size: 35px;\n"+
                            "}\n"+

                            "/* --- partie nom/photo --- */\n"+
                            ".partie_nom_photo{\n"+
                            "display: flex;\n"+
                            "justify-content: space-between;\n"+
                            "margin-top: 60px;\n"+
                            "margin-bottom: 25px;\n"+
                            "}\n"+

                            "/* --- partie nom --- */\n"+
                            ".name{\n"+
                            "display: block;\n"+
                            "background-color: #379EC1;\n"+
                            "border: 2px solid rgb(0, 0, 0);\n"+
                            "height: 65px;\n"+
                            "padding: 15px;\n"+
                            "}\n"+

                            "/* --- partie photo --- */\n"+
                            "/*.photo{\n"+
                            "height: 230px;\n"+
                            "width: 350px;\n"+
                            "border: 2px solid grey;\n"+
                            "overflow: hidden;\n"+
                            "position: relative;\n"+
                            "}*/\n"+

                            ".photo img{\n"+
                            "width: 150%;\n"+
                            "border: 2px solid rgb(0, 0, 0);\n"+
                            "/* position: absolute;\n"+
                            "top: 50%;\n"+
                            "left: 50%;\n"+
                            "transform: translate(-50%, -50%);*/\n"+
                            "}\n"+

                            ".photo:hover{\n"+
                            "transform: scale(1.3);\n"+
                            "}\n"+

                            "/* --- partie checkbox --- */\n"+
                            ".infos_checks{\n"+
                            "display: flex;\n"+
                            "max-width: 400px;\n"+
                            "flex-direction: column;\n"+
                            "justify-content: center;\n"+
                            "text-align: end;\n"+
                            "background-color: #379EC1;\n"+
                            "border: 2px solid  rgb(29, 28, 28);\n"+
                            "margin-top: 80px;\n"+
                            "margin-bottom: 40px;\n"+
                            "}\n"+

                            ".info_check{\n"+
                            "padding: 15px;\n"+
                            "}\n"+

                            "label{\n"+
                            "font-size: 20px;\n"+
                            "}\n"+

                            "/* --- footer --- */\n"+
                            "footer{\n"+
                            "display: flex;\n"+
                            "flex-direction: column;\n"+
                            "justify-content: center;\n"+
                            "align-items: center;\n"+
                            "height: 150px;\n"+
                            "background-color: rgb(0, 0, 0);\n"+
                            "color: white;\n"+
                            "}\n"+

                            "@media only screen and (max-width: 500px) \n"+
                            "{\n"+
                            ".partie_nom_photo{\n"+
                            "display: flex;\n"+
                            "flex-direction: column;\n"+
                            "}\n"+

                            ".name{\n"+
                            "margin-bottom: 25px;\n"+
                            "}\n"+
                            "}\n"+

                            "/* --- logo --- */\n"+
                            ".logo{\n"+
                            "width: 290px;\n"+
                            "height: 100%;\n"+
                            "}\n"+

                            "</style>\n"+
                            "</head>\n"+

                            "<body>\n"+
                            "<!-- main -->\n"+
                            "<main>\n"+
                            "<div class=\"partie_nom_photo\">\n"+
                            "<div class=\"name\">\n"+
                            "<h1>Nom + Prénom</h1>\n"+
                            "</div>\n"+

                            "<div class=\"photo\">\n"+
                            "<img src=\"\" />\n"+
                            "</div>\n"+
                            "</div>\n"+


                            "<div class=\"infos_checks\">\n"+
                                "<div class=\"info_check\">\n"+
                                    "<label for=\"Mousqueton\">Mousqueton</label>\n"+
                                    "<input class=\"box\" type=\"checkbox\" id=\"Mousqueton\" name=\"Mousqueton\"disabled=\"disabled\"checked \n"+
                            "</div>\n"+

                            "<div class=\"info_check\">\n"+
                                "<label for=\"Gant\">Gant d'intervention</label>\n"+
                                "<input type=\"checkbox\" id=\"Gant\" name=\"Gant\" disabled=\"disabled\"\n"+
                            "</div>\n"+

                            "<div class=\"info_check\">\n"+
                                "<label for=\"Ceinture\">Ceinture de sécurité tactique</label>\n"+
                                "<input type=\"checkbox\" id=\"Ceinture\" name=\"Ceinture\" disabled=\"disabled\"\n"+
                            "</div>\n"+

                            "<div class=\"info_check\">\n"+
                                "<label for=\"Détecteur\">Détecteur de métaux</label>\n"+
                                "<input type=\"checkbox\" id=\"Détecteur\" name=\"Détecteur\" disabled=\"disabled\"\n"+
                            "</div>\n"+

                            "<div class=\"info_check\">\n"+
                            "<label for=\"Brassard\">Brassard de sécurité</label>\n"+
                            "<input type=\"checkbox\" id=\"Brassard\" name=\"Brassard\" disabled=\"disabled\"\n"+
                            "</div>\n"+

                            "<div class=\"info_check\">\n"+
                                "<label for=\"Lampe\">Lampe torche</label>\n"+
                                "<input type=\"checkbox\" id=\"Lampe\" name=\"Lampe\" disabled=\"disabled\"\n"+
                            "</div>\n"+

                            "<div class=\"info_check\">\n"+
                                "<label for=\"Gillet\">Gillet pare balle</label>\n"+
                                "<input type=\"checkbox\" id=\"Gillet\" name=\"Gillet\" disabled=\"disabled\"\n"+
                            "</div>\n"+
                            "</div>\n"+
                            "</main>\n"+

                            "<!-- footer -->\n"+
                            "<footer>\n"+
                            "<div class=\"logo\">\n"+
                                "<img src=\"D:\\Téléchargements\\Capture(1).PNG\"  />\n"+
                            "</div>\n"+
                            "</footer>\n"+
                            "</body>\n"+
                            "</html>\n"

                            //" </head>\n" +
                            //" <body>\n" +
                            //"<p>" + fichier + "</p>" +
                            //" </body>\n" +
                            //"</html>"
                    ));

                    fluxSortie.close();//marque les flux sur le fichier physique.
                    //ListePersonne.add(scan.nextLine());
                }
                System.out.println("liste : " + ListePersonne);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Le fichier n'a pas pu Ãªtre lu.");
        }
    }
}
