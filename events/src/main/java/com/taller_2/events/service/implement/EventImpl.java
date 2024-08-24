package com.taller_2.events.service.implement;

import com.taller_2.events.entity.EventEntity;
import com.taller_2.events.repositories.interfaces.EventRepository;
import com.taller_2.events.service.interfaces.IEventService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventImpl implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void delete(String id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventEntity> readAll() {
        return eventRepository.findAll();
    }

    @Override
    public EventEntity readById(String id) {
        return eventRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("No se encontro el evento con el id: " + id));
    }

    @Override
    public EventEntity save(EventEntity request) {
        return eventRepository.save(request);
    }

    @Override
    public Page<EventEntity> pagesAllElement(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return eventRepository.findAll(pageable);
    }
}
