package com.utfpr.mecanica.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.utfpr.mecanica.entities.Item;
import com.utfpr.mecanica.repositories.ItemRepository;

@Controller
public class MainController {
	
	@Autowired
    private ItemRepository itemRepository;
	
	@GetMapping("/")
	public String index() {
	    return "index";
	}
	
	@GetMapping("/createItem")
    public String listItems(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "/createItem";
    }
	
	@PostMapping("/createItem")
	public String createItem(Item item) {
		System.out.println("O nome do item é: " + item.getNome());
		Item item1 = new Item (item.getId(), item.getNome(), item.getDescricao(), item.getPreco());
		itemRepository.saveAll(Arrays.asList(item1));
		return "redirect:/listaItem";
	}
	
	@GetMapping("/listaItem")
	public String listaItem(Model model) {
		List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "/listaItem";
	}
	
	
//	@GetMapping("listaItem")
//	public ModelAndView listaItem() {
//		ModelAndView mv = new ModelAndView("list");
//		 List<Item> items = itemRepository.findAll();
//		 mv.addObject("items", items);
//		return mv;
//	}
	
	/* ********************************** */
	/* Metodos teste */
	@GetMapping("/create")
	public String create() {
	    return "create";
	}
	
	@GetMapping("/login")
	public String login() {
	    return "login";
	}
	/* ********************************** */

	

	
	
}
