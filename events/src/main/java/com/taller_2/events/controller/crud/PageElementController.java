package com.taller_2.events.controller.crud;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface PageElementController <Entity, Pages, Size>{
    public ResponseEntity<Page<Entity>> pagesElement(Pages pages, Size size);
}
