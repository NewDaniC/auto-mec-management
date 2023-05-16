package com.utfpr.mecanica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.utfpr.mecanica.entities.Categoria;
import com.utfpr.mecanica.repositories.CategoriaRepository;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categoria/createCategoria")
	public ModelAndView homeCategoria() {
		ModelAndView mv = new ModelAndView("categoria/createCategoria");
		//mv.addObject("item", new Item());
		mv.addObject("categoria", new Categoria());
		return mv;
	}
	
	@PostMapping("/categoria/createCategoria")
	public String createCategoria(Categoria categoria) {
		if (categoria.getId() != null) { // EDIT CATEGORY

	        categoriaRepository.save(categoria);
	    } else { // NEW CATEGORY

	        categoriaRepository.save(categoria);
	    }

	    return "redirect:/categoria/listaCategoria";
	}
	
	@GetMapping("/categoria/listaCategoria")
	public String listaCategoria(Model model) {
		List<Categoria> categorias = categoriaRepository.findAll();
		model.addAttribute("categorias", categorias);
		return "/categoria/listaCategoria";
	}

	@GetMapping("/categoria/editCategoria/{id}")
	public ModelAndView editCategoria(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("categoria/createCategoria");
		
		Categoria categoria = categoriaRepository.findById(id).orElse(null);
	    mv.addObject("categoria", categoria);

		return mv;
	}
	
	@GetMapping("/categoria/excluirCategoria/{id}")
	public ModelAndView excluirCategoria(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		ModelAndView mav = new ModelAndView("redirect:/categoria/listaCategoria");
		return mav;
	}
}
