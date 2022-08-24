package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.PersonaDto;
import com.tutorial.crud.entity.Persona;
import com.tutorial.crud.service.PersonaService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://argentinaprog22.web.app")
public class PersonaController {

	@Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Persona> getByNombre(@PathVariable("nombre") String nombre){
        if(!personaService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Persona persona = personaService.getByNombre(nombre).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("persona creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody PersonaDto personaDto){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }


}
