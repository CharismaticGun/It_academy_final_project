package com.example.poster_final_project.service.api;


import com.example.poster_final_project.service.dto.api.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;



@Transactional(readOnly = true)
public interface IEventService<C,R,P extends IPage<?>> {

    @Transactional
    C create(C event);

    R readEventInfo(String uuid);

    @Transactional
    C updateEventInfo(C event, String uuid, LocalDateTime dtUpdate);

    P readEventPage(int size,int page);





}
