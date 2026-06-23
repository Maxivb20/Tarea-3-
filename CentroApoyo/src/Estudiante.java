public class Estudiante { //definimos la clase Estudiante
    private String nombre;
    private String curso;
    private double nota;   //definimos los atributos

    public Estudiante(String nombre, String curso, double nota) {
        this.nombre= nombre;
        this.curso = curso;   //hacemos el constructor
        this.nota = nota;
    }
    public String getNombre() {
        return nombre;        //hacemos los getter
    }
    public String getCurso() {
        return curso;
    }
    public double getNota() {
        return nota;
    }
}
