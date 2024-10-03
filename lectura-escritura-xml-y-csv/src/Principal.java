import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        generarFicheroXML();
        Scanner scanner=new Scanner(System.in);
        boolean opcionUnoRealizada=false;
        while (true){
            if (opcionUnoRealizada){
                menu2();
                int opcion=scanner.nextInt();
                switch (opcion){
                    case 1: transformasFicheroXMLaCSV();
                        break;
                    case 2: transformaFicheroCSVaXML();
                        break;
                    case 3:System.exit(0);
                        break;
                }
            }else {
                menu1();
                int opcion=scanner.nextInt();
                switch (opcion){
                    case 1:
                        opcionUnoRealizada=true;
                        transformasFicheroXMLaCSV();
                        break;
                    case 2:System.exit(0);
                        break;
                }
            }
        }



    }

    private static void transformaFicheroCSVaXML() throws IOException, ParserConfigurationException, TransformerException {
        Path origen=Paths.get("C:\\Users\\laura\\Desktop\\ficheroCSV.csv");
        BufferedReader br=Files.newBufferedReader(origen);
        Stream<String> lineas=br.lines();

        DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=factoria.newDocumentBuilder();
        Document documento=db.newDocument();
        Element curso=documento.createElement("curso");
        documento.appendChild(curso);


        lineas.forEach(linea->{
            String[]datos=linea.split(";");
                Element asignatura=documento.createElement("asignatura");
                curso.appendChild(asignatura);
                Element nombre=documento.createElement("nombre");
                nombre.setTextContent(datos[0]);
                asignatura.appendChild(nombre);
                Element horas=documento.createElement("horas");
                horas.setTextContent(datos[1]);
                asignatura.appendChild(horas);
                Element profesor=documento.createElement("profesor");
                profesor.setTextContent(datos[2]);
                asignatura.appendChild(profesor);

        });

        TransformerFactory tf=TransformerFactory.newInstance();
        Transformer transformer=tf.newTransformer();
        DOMSource dom=new DOMSource(documento);
        StreamResult sr=new StreamResult(new File("C:\\Users\\laura\\Desktop\\opcion2.xml"));
        transformer.transform(dom,sr);



    }

    private static void transformasFicheroXMLaCSV() throws IOException, ParserConfigurationException, SAXException {
        FileInputStream fis=new FileInputStream("C:\\Users\\laura\\Desktop\\ficherito.xml");
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=factory.newDocumentBuilder();
        Document documentoXML=db.parse(fis);
        NodeList listaNombre=documentoXML.getElementsByTagName("nombre");
        NodeList listaHoras=documentoXML.getElementsByTagName("horas");
        NodeList listaProfesores=documentoXML.getElementsByTagName("profesor");

        Path destino=Paths.get("C:\\Users\\laura\\Desktop\\ficheroCSV.csv");
        BufferedWriter bw= Files.newBufferedWriter(destino);
        for (int i=0;i<listaNombre.getLength();i++){
            bw.write(listaNombre.item(i).getTextContent()+";"+listaHoras.item(1).getTextContent()+";"+listaProfesores.item(i).getTextContent()+"\n");
        }
        bw.flush();


    }

    private static void generarFicheroXML() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=factoria.newDocumentBuilder();
        Document documento=db.newDocument();

        Element curso=documento.createElement("curso");
        documento.appendChild(curso);
        Element asignatura=documento.createElement("asignatura");
        curso.appendChild(asignatura);
        Element nombre1=documento.createElement("nombre");
        nombre1.setTextContent("Acceso a datos");
        asignatura.appendChild(nombre1);
        Element horas1=documento.createElement("horas");
        horas1.setTextContent("6");
        asignatura.appendChild(horas1);
        Element profesor1=documento.createElement("profesor");
        profesor1.setTextContent("Jose");
        asignatura.appendChild(profesor1);

        Element asignatura2=documento.createElement("asignatura");
        curso.appendChild(asignatura2);
        Element nombre2=documento.createElement("nombre");
        nombre2.setTextContent("Desenvolvemento de interfaces");
        asignatura2.appendChild(nombre2);
        Element horas2=documento.createElement("horas");
        horas2.setTextContent("4");
        asignatura2.appendChild(horas2);
        Element profesor2=documento.createElement("profesor");
        profesor2.setTextContent("Brais");
        asignatura2.appendChild(profesor2);




        TransformerFactory tf=TransformerFactory.newInstance();
        Transformer transformer=tf.newTransformer();
        DOMSource dom=new DOMSource(documento);
        StreamResult sr=new StreamResult(new File("C:\\Users\\laura\\Desktop\\ficherito.xml"));
        transformer.transform(dom,sr);



        
    }

    private static void menu1() {
        System.out.println("""
                MENU 
                1. Leer un fichero xml y generar un fichero csv.
                2. Salir\n
                Escoja una opción:
                """);
    }

    private static void menu2() {
        System.out.println("""
                MENU 
                1. Leer un fichero xml y generar un fichero csv.
                2. Leer fichero csv y generar un xml solo con las asignaturas que tienen más de 5 horas.
                3. Salir\n
                Escoja una opción:
                """);
    }
}
