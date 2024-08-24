package com.taller_2.events.controller.crud;

import org.springframework.http.ResponseEntity;

public interface SaveController<Entity>{
    public ResponseEntity<Entity> save(Entity request);
}
