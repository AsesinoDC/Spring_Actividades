package com.taller_2.events.service.crud;

import org.springframework.data.domain.Page;

public interface PageElement<Entity, Pages, Size>{
    public Page<Entity> pagesAllElement(Pages pages, Size size);
}
