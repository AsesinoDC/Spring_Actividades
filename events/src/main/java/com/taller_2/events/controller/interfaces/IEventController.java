package com.taller_2.events.controller.interfaces;

import com.taller_2.events.controller.crud.*;
import com.taller_2.events.entity.EventEntity;

public interface IEventController extends
        SaveController<EventEntity>,
        ReadAllController<EventEntity>,
        ReadByIdController<EventEntity, String>,
        DeleteController<String>,
        PageElementController<EventEntity,Integer,Integer> {
}
