import java.io.*;

public class Index {
    public static void main(String[] args) throws IOException {
        final int TAMANHO =16*1024;
        byte[]buffer=new byte[TAMANHO];

        int cantidadLeida=0;

        BufferedInputStream bis= new BufferedInputStream(new FileInputStream("C:\\Users\\laura\\Desktop\\2ºDAM\\ACCESO A DATOS\\prueba2.pdf"));

        BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream("C:\\Users\\laura\\Desktop\\2ºDAM\\ACCESO A DATOS\\prueba3.pdf"));

        while ((cantidadLeida=bis.read(buffer,0,TAMANHO))!=1){
                            bos.write(buffer,0,cantidadLeida);
        }

        bis.close();
        bos.close();


    }
}
