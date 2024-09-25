import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class nioII {
    public static void main(String[] args) {
        try {
            Path origen = Paths.get("C:\\Users\\laura\\Desktop\\pruebaNio.txt");
            BufferedReader br = Files.newBufferedReader(origen);
            Stream<String> lineas = br.lines();
            lineas.forEach(System.out::println);
            br.close();

        } catch (IOException e) {

            System.out.println("ERROR");

        }

    }
}
