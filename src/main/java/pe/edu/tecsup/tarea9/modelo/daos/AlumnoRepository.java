package pe.edu.tecsup.tarea9.modelo.daos;


import pe.edu.tecsup.tarea9.modelo.entidades.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, String> {
}