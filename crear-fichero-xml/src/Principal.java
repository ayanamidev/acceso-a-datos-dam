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

        Element alumnos=documento.createElement("alumnos");
        documento.appendChild(alumnos);
        Element alumno=documento.createElement("alumno");
        alumnos.appendChild(alumno);
        Element dni=documento.createElement("dni");
        dni.setTextContent("11111111A");
        alumnos.appendChild(dni);
        Element nombre=documento.createElement("nombre");
        nombre.setTextContent("Jose");
        alumnos.appendChild(nombre);

        TransformerFactory tf=TransformerFactory.newInstance();
        Transformer transformer=tf.newTransformer();

        DOMSource dom=new DOMSource(documento);
        StreamResult sr=new StreamResult(new File("C:\\Users\\laura\\Desktop\\fichero.xml"));
        transformer.transform(dom,sr);
    }
}
