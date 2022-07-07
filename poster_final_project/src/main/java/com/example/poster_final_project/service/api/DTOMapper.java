package com.example.poster_final_project.service.api;

import com.example.poster_final_project.dao.entity.Event;
import com.example.poster_final_project.service.dto.api.IPage;
import org.springframework.data.domain.Page;

public interface DTOMapper<E extends Event,C,R,P extends IPage<?>> {

    E fromDTOToEntity(C dto);

    R fromEntityToDTO(E entity);

    P fromEntityPageToDtoPage(Page<E> ePage);

    void updateEntityFromDTO(C dto,E entity);

}
