package com.utfpr.mecanica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.utfpr.mecanica.entities.Categoria;
import com.utfpr.mecanica.entities.Item;
import com.utfpr.mecanica.repositories.CategoriaRepository;
import com.utfpr.mecanica.repositories.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/item/createItem")
	public ModelAndView homeItem() {
		ModelAndView mv = new ModelAndView("item/createItem");
		mv.addObject("item", new Item());
		mv.addObject("categories", categoriaRepository.findAll());
		return mv;
	}

	/* Ta funcionando - Verificar condicional */
	@PostMapping("/item/createItem")
	public String createItem(Item item, @RequestParam("categoria_id") Long categoriaId) {
		if (item.getId() != null) { // NEW ITEM
			System.out.println("O nome do item é: " + item.getNome());
			System.out.println("NEW ITEM: " + item.getId());

			itemRepository.save(item);

			Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);
			item.getCategoria().add(categoria);
			itemRepository.save(item);

		} else { // EDIT ITEM
			System.out.println("EDIT ITEM: " + item.getId());
			System.out.println("A CATEGORIA É: " + item.getCategoria());

			Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);
			item.getCategoria().add(categoria);

			itemRepository.save(item);
		}

		return "redirect:/item/listaItem";
	}

	@GetMapping("/item/listaItem")
	public String listaItem(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "/item/listaItem";
	}

	// https://www.youtube.com/watch?v=u8a25mQcMOI - 1:38:00
	@GetMapping("/item/editItem/{id}")
	public ModelAndView editItem(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("item/createItem");

		// Busca o item a ser editado
		Item item = itemRepository.findById(id).orElse(null);
		mv.addObject("item", item);

		// Busca todas as categorias disponíveis
		List<Categoria> categorias = categoriaRepository.findAll();
		mv.addObject("categories", categorias);

		return mv;
	}

	@GetMapping("/item/excluirItem/{id}")
	public ModelAndView excluirItem(@PathVariable Long id) {
		itemRepository.deleteById(id);
		ModelAndView mav = new ModelAndView("redirect:/item/listaItem");
		return mav;
	}

	@GetMapping("/item/itensPorCategoria/{categoriaId}")
	public String itensPorCategoria(Model model, @PathVariable("categoriaId") Long categoriaId) {
		List<Item> items = itemRepository.findAll();
		
		List<Item> itensDaCategoria = new ArrayList<>();

		for (Item item : items) {// Filtrar apenas os itens da categoria selecionada
			for (Categoria itemCategoria : item.getCategoria()) {
				if (itemCategoria.getId().equals(categoriaId)) {
					itensDaCategoria.add(item);
					System.out.println(itemCategoria);
					break;
				}
			}
		}
		model.addAttribute("items", itensDaCategoria);
		return "/item/itensPorCategoria";
	}
}
