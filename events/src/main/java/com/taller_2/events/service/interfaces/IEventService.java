package com.taller_2.events.service.interfaces;

import com.taller_2.events.entity.EventEntity;
import com.taller_2.events.service.crud.*;

public interface IEventService extends
        Save<EventEntity>,
        ReadAll<EventEntity>,
        ReadById<EventEntity, String>,
        Delete<String>,
        PageElement<EventEntity, Integer, Integer> {
}
