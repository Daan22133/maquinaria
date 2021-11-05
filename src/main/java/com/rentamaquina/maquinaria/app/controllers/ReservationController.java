/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.entities.custom.CountClient;
import com.rentamaquina.maquinaria.app.entities.custom.DescriptionAmount;
import com.rentamaquina.maquinaria.app.services.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")

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
    public Reservation save(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }
    
    /**
     * PUT
     * @param category
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
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
    
    
    @GetMapping("/report-status}")
    public DescriptionAmount getReservationDescriptionStatus(){
	return service.getStatusReport();
    } 
    
    @GetMapping("/report-client}")
    public List<CountClient> getCountClient(){
	return service.getTopClient();
    } 
    
    
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(
    @PathVariable("dateOne") String d1,@PathVariable("dateTwo") String d2){
	return service.getReservationPeriod(d1,d2);
    }
}
