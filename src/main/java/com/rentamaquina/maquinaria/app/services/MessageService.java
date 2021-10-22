/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;


import com.rentamaquina.maquinaria.app.entities.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentamaquina.maquinaria.app.repositories.MessageRepository;
import java.util.Optional;
/**
 *
 * @author daan_
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Message> getAll(){
        return repository.getAll();
    }
    
    /**
     * Buscar por ID
     * @param MessageId
     * @return 
     */
    public Optional<Message> getMessage(int MessageId){
        return repository.getMessage(MessageId);
    }
    
    /**
     * POST
     * @param Message
     * @return 
     */
    public Message save(Message Message){
        if(Message.getIdMessage()== null){
            return repository.save(Message);
        }else{
            Optional<Message> resultado = repository.getMessage(Message.getIdMessage());
            if(resultado.isPresent()){
                return Message;
            }else{
                return repository.save(Message);
            }
        }
    }
    
    /**
     * UPDATE
     * @param Message
     * @return 
     */
    public Message update(Message Message){
        if(Message.getIdMessage()!=null){
            Optional<Message> resultado = repository.getMessage(Message.getIdMessage());
            if(resultado.isPresent()){
                if(Message.getMessageText()!=null){
                    resultado.get().setMessageText(Message.getMessageText());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return Message;
            }
        }else{
            return Message;
        }
    }
    
    /**
     * DELETE
     * @param MessageId
     * @return 
     */
    public boolean deleteMessage(int MessageId) {
        Boolean aBoolean = getMessage(MessageId).map(Message -> {
            repository.delete(Message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    
}
