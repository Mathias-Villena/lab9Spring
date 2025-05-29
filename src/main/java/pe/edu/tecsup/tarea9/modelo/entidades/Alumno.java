package pe.edu.tecsup.tarea9.modelo.entidades;
import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
@Entity
@Table(name = "Alumno")
public class Alumno {
    @Id
    @Column(name = "chrAluCodigo", length = 10)
    @NotEmpty(message = "El código no puede estar vacío")
    private String codigo;

    @Column(name = "vchAluNombres", length = 50)
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombres;

    @Column(name = "vchAluApellidos", length = 50)
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String apellidos;

    @Column(name = "dtmAluFechaNac")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @Column(name = "chrAluSexo", length = 1)
    private String sexo;

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}