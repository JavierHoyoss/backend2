package com.portfolio.hoyos.Controller;

import com.portfolio.hoyos.Dto.dtoPersona;
import com.portfolio.hoyos.Entity.Persona;
import com.portfolio.hoyos.Security.Controller.Mensaje;

import com.portfolio.hoyos.Sevice.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendhoyos.web.app")

public class PersonaController {

    @Autowired
    ImpPersonaService iPersonaService;
    
     @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.save(persona);
        return "La persona fue creada correctamente";
    }

    @GetMapping("/list")
    public List<Persona> getPersona() {
        return iPersonaService.list();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona educacion = iPersonaService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")

    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        //Validamos si existe el ID
        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de educaciones
        if (iPersonaService.existsByNombre(dtopersona.getNombre()) && iPersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = iPersonaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido((dtopersona.getApellido()));
        persona.setAcerca(dtopersona.getAcerca());
        persona.setImg(dtopersona.getImg());

        iPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada correctamente"), HttpStatus.OK);

    }
}
