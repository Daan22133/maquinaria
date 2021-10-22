/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.services.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daan_
 */
@RestController
@RequestMapping("Reservation")
public class ReservationController {
   
    @Autowired
    private ReservationService service;
	    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }
	    
    /**
     * POST
     * @param category
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation category) {
        return service.save(category);
    }
    
    /**
     * PUT
     * @param category
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation category) {
        return service.update(category);
    }
    
    /**
     * DELETE
     * @param ReservationId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ReservationId) {
        return service.deleteReservation(ReservationId);
    }
    
}
