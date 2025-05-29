package pe.edu.tecsup.tarea9.servicios;

import pe.edu.tecsup.tarea9.modelo.entidades.Alumno;
import java.util.List;

public interface AlumnoService {
    List<Alumno> listar();
    void grabar(Alumno alumno);
    Alumno buscar(String codigo);
    void eliminar(String codigo);
}