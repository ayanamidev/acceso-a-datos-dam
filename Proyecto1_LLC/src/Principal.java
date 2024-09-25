import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) throws IOException {
        while (true){
            menu();
            int opcion=leerInt();
            switch (opcion){
                case 1:{
                    Path origen= Paths.get("C:\\Users\\laura\\Desktop\\alumnos.csv");
                    BufferedReader br= Files.newBufferedReader(origen);
                    Stream <String> lineas=br.lines();
                    lineas.forEach(System.out::println);
                    br.close();}
                break;
                case 2:
                    Path origen= Paths.get("C:\\Users\\laura\\Desktop\\alumnos.csv");
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
                    br.close();
                    bw.close();

                    break;
                case 3:System.exit(0);
                    break;
            }
        }




    }

    private static int leerInt() {
        return new Scanner(System.in).nextInt();
    }

    private static void menu() {
        System.out.println("""
                MENU
                1.Mostrar contenido del fichero.
                2. Genrerar un nuevo fichero
                3.Salir""");
    }
}
