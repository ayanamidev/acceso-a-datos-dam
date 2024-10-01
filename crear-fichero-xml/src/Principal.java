import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Principal {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=factoria.newDocumentBuilder();
        Document documento=db.newDocument();

        //Alumnos
        Element alumnos=documento.createElement("alumnos");
        documento.appendChild(alumnos);

            //Alumno 1
            Element alumno1=documento.createElement("alumno");
            alumnos.appendChild(alumno1);

                    Element dniA1=documento.createElement("dni");
                    dniA1.setTextContent("11111111A");
                    alumno1.appendChild(dniA1);


                    Element nombreA1=documento.createElement("nombre");
                    nombreA1.setTextContent("Jose");
                    alumno1.appendChild(nombreA1);

            //Alumno2
            Element alumno2=documento.createElement("alumno");
            alumnos.appendChild(alumno2);

                    Element dniA2=documento.createElement("dni");
                    dniA2.setTextContent("11111111A");
                    alumno2.appendChild(dniA2);


                    Element nombreA2=documento.createElement("nombre");
                    nombreA2.setTextContent("Menganito");
                    alumno2.appendChild(nombreA2);

            //Alumno3
            Element alumno3=documento.createElement("alumno");
            alumnos.appendChild(alumno3);

                    Element dniA3=documento.createElement("dni");
                    dniA3.setTextContent("11111111A");
                    alumno3.appendChild(dniA3);

                    Element nombreA3=documento.createElement("nombre");
                    nombreA3.setTextContent("Fulanito");
                    alumno3.appendChild(nombreA3);



        TransformerFactory tf=TransformerFactory.newInstance();
        Transformer transformer=tf.newTransformer();

        DOMSource dom=new DOMSource(documento);
        StreamResult sr=new StreamResult(new File("C:\\Users\\laura\\Desktop\\fichero.xml"));
        transformer.transform(dom,sr);
    }
}
