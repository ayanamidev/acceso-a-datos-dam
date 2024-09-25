public class Alumno {
    String nombre;
    String edad;
    String ciudad;
    String curso;

    public Alumno(String nombre, String edad, String ciudad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "El alumno "+nombre+", de "+edad+" años, estudia "+curso+" y es de "+ciudad;
    }
}
