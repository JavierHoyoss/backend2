/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.hoyos.Controller;

import com.portfolio.hoyos.Dto.dtoBanner;
import com.portfolio.hoyos.Entity.Banner;
import com.portfolio.hoyos.Security.Controller.Mensaje;
import com.portfolio.hoyos.Sevice.SBanner;
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
@RequestMapping("/banner")
@CrossOrigin(origins = "https://frontendhoyos.web.app")

public class CBanner {
    
     @Autowired
    SBanner sBanner;
     
     Banner banner = new Banner();
     
      @PostMapping("/crear")
    public String createPersona(@RequestBody Banner banner){
        sBanner.save(banner);
        return "El banner fue agregado correctamente";
    }
     

    @GetMapping("/list")
    public List<Banner> getBanner() {
        return sBanner.list();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id") int id) {
        if (!sBanner.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Banner banner = sBanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")

    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner) {
        //Validamos si existe el ID
        if (!sBanner.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        //No puede estar vacio
        if (StringUtils.isBlank(dtobanner.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatorio"), HttpStatus.BAD_REQUEST);
        }

       Banner banner = sBanner.getOne(id).get();        
        banner.setImg(dtobanner.getImg());

        sBanner.save(banner);
        return new ResponseEntity(new Mensaje("Imagen actualizada correctamente"), HttpStatus.OK);

    }
}
