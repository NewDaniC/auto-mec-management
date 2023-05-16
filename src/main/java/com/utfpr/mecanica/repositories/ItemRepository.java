package com.utfpr.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.mecanica.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}