package com.taller_2.events.controller.crud;

import org.springframework.http.ResponseEntity;

public interface DeleteController <ID>{
    public ResponseEntity<Void> delete(ID id);
}
