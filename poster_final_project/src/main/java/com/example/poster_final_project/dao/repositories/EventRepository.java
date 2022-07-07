package com.example.poster_final_project.dao.repositories;

import com.example.poster_final_project.dao.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository<E extends Event> extends JpaRepository<E, UUID> {
}
