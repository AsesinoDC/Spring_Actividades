package com.taller_2.events.controller.crud;

import org.springframework.http.ResponseEntity;

public interface ReadByIdController<Entity, ID>{
    public ResponseEntity<Entity> readById(ID id);
}
