/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories.crud;

import com.rentamaquina.maquinaria.app.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author daan_
 */
public interface AdminCRUDRepository extends JpaRepository<Admin,Integer>{
    
}
