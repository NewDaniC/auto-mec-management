package com.utfpr.mecanica.services;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.Categoria;
import com.utfpr.mecanica.entities.Item;
import com.utfpr.mecanica.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;

	public List<Item> findAll() {
		return repository.findAll();
	}

	public Item findById(Long id) {
		Optional<Item> obj = repository.findById(id);
		return obj.get();
	}
	
	public Item update(Long id, Item obj) {
		Item entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Item entity, Item obj) {
		entity.setNome(obj.getNome());
		entity.setDescricao(obj.getDescricao());
		entity.setPreco(obj.getPreco());
	}
	
	public List<Item> findByCategoria(Categoria categoria) {
	    List<Item> items = repository.findAll();
	    List<Item> filteredItems = new ArrayList<>();
	    
	    for (Item item : items) {
	        if (item.getCategoria().contains(categoria)) {
	            filteredItems.add(item);
	        }
	    }
	    return filteredItems;
	}
	
//	public List<Item> findByCategoria(Categoria categoria) {
//	    List<Item> items = repository.findAll();
//	    List<Item> filteredItems = new ArrayList<>();
//	    
//	    for (Item item : items) {
//	        if (item.getCategoria().contains(categoria)) {
//	            filteredItems.add(item);
//	        }
//	    }
//	    return filteredItems;
//	}
}
