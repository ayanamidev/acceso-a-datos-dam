import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.stream.Stream;
import java.nio.file.Files;


public class Ficheros {
    //"C:\\Users\\laura\\Desktop\\alumnos.csv"

    public static void MostrarFichero(String ruta)throws IOException{ 
        Path origen= Paths.get(ruta);
        BufferedReader br= Files.newBufferedReader(origen);
        Stream <String> lineas=br.lines();
        lineas.forEach(System.out::println);
        br.close();

    }

    public static void GenerarFichero(String ruta)throws IOException{
        Path origen= Paths.get(ruta);
        BufferedReader br= Files.newBufferedReader(origen);
        Stream <String> lineas=br.lines();
        BufferedWriter bw=Files.newBufferedWriter(Paths.get("C:\\Users\\laura\\Desktop\\alumnosResultado.txt"));
        lineas.forEach(linea ->{
            String[]datos=linea.split(";");
            if (datos.length==4){
                String nombre=datos[0];
                String edad=datos[1];
                String ciudad=datos[2];
                String curso=datos[3];

                Alumno alumnos=new Alumno(nombre,edad,ciudad,curso);
                try {

                    bw.write(alumnos.toString());
                    bw.newLine();


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                
            }

        });
        bw.flush();
        br.close();
        bw.close();

    }
}
