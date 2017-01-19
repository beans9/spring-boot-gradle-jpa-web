package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
