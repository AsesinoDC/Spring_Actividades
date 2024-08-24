package com.taller_2.events.service.crud;

public interface ReadById <Entity, ID>{
    public Entity readById(ID id);
}
