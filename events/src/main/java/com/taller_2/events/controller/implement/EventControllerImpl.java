package com.taller_2.events.controller.implement;

import com.taller_2.events.controller.interfaces.IEventController;
import com.taller_2.events.entity.EventEntity;
import com.taller_2.events.service.interfaces.IEventService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventControllerImpl implements IEventController {

    @Autowired
    private IEventService eventService;

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        try {
            eventService.delete(id);
            //Codigo 204 me indica que fue exitosa la eliminacion
            return ResponseEntity.noContent().build();
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @GetMapping("/readAll")
    public List<EventEntity> readAll() {
        return eventService.readAll();
    }

    @Override
    @GetMapping("/read")
    public ResponseEntity<EventEntity> readById(@RequestParam String id) {
        try {
            EventEntity eventFound = eventService.readById(id);
            //Sera codigo 200 de ok
            return ResponseEntity.ok(eventFound);
        }
        catch (EntityNotFoundException e){
            //Sera el codigo 404 not found
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping("/save")
    public ResponseEntity<EventEntity> save(@RequestBody EventEntity request) {
        if(request.getCapacity() <= 0 || request.getDate_event().isBefore(LocalDate.now())){
            return null;
        }
        return ResponseEntity.ok(eventService.save(request));
    }


    @Override
    @GetMapping("/pages")
    public ResponseEntity<Page<EventEntity>> pagesElement(@RequestParam Integer page,
                                                          @RequestParam Integer size) {

        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Error");
        }
        Page<EventEntity> eventPages = eventService.pagesAllElement(page,size);
        return ResponseEntity.ok(eventPages);
    }

}
