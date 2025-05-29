package pe.edu.tecsup.tarea9.controller;

import pe.edu.tecsup.tarea9.modelo.entidades.Alumno;
import pe.edu.tecsup.tarea9.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService servicio;

    @RequestMapping(value = "/listarAlumno", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Alumnos");
        model.addAttribute("alumnos", servicio.listar());
        return "alumnoListarView";
    }

    @RequestMapping(value = "/formAlumno")
    public String crear(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        model.put("titulo", "Formulario de Alumno");
        return "formAlumnoView";
    }

    @RequestMapping(value = "/formAlumno/{codigo}")
    public String editar(@PathVariable(value = "codigo") String codigo, Map<String, Object> model) {
        System.out.println("EDITAR -> " + codigo);
        Alumno alumno = servicio.buscar(codigo);
        if (alumno == null) {
            return "redirect:/listarAlumno";
        }
        model.put("alumno", alumno);
        model.put("titulo", "Editar Alumno");
        return "formAlumnoView";
    }

    @RequestMapping(value = "/formAlumno", method = RequestMethod.POST)
    public String guardar(@Validated Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Alumno");
            return "formAlumnoView";
        }
        servicio.grabar(alumno);
        status.setComplete();
        return "redirect:/listarAlumno";
    }

    @RequestMapping(value = "/eliminarAlumno/{codigo}")
    public String eliminar(@PathVariable(value = "codigo") String codigo) {
        System.out.println("ELIMINAR -> " + codigo);
        if (codigo != null && !codigo.isEmpty()) {
            servicio.eliminar(codigo);
        }
        return "redirect:/listarAlumno";
    }
}