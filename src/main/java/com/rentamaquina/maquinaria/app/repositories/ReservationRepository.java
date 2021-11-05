/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories;


import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.entities.custom.CountClient;
import com.rentamaquina.maquinaria.app.repositories.crud.ReservationCRUDRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daan_
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCrudRepository;
    
    
      public List<Reservation> getReservationPeriod(Date dateOne,Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }  
    
      public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
      
      
   public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();
        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }

      
      
    /**
     * Select
     * @return 
     */
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    /**
     * Insert
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
       return reservationCrudRepository.save(reservation);
    } 
    
    /**
     * Buscar registro
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservation(int reservationId){
        return reservationCrudRepository.findById(reservationId);
    }
    
    /**
     * Delete
     * @param reservation
     */
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
}
