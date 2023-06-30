package com.utfpr.mecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.utfpr.mecanica.entities.Veiculo;
import com.utfpr.mecanica.entities.enums.CorDoVeiculo;
import com.utfpr.mecanica.repositories.VeiculoRepository;

@Controller
public class VeiculoController {

//	@GetMapping("/veiculo/createVeiculo")
//	public ModelAndView homeVeiculo() {
//		ModelAndView mv = new ModelAndView("veiculo/createVeiculo");
//		mv.addObject("veiculo", new Veiculo());
//		return mv;
//	}
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping("/veiculo/createVeiculo")
	public ModelAndView homeVeiculo() {
		ModelAndView mv = new ModelAndView("veiculo/createVeiculo");
		mv.addObject("veiculo", new Veiculo());
		mv.addObject("corVeiculoEnum", CorDoVeiculo.values());
		return mv;
	}
	
	@PostMapping("/veiculo/createVeiculo")
	public String createVeiculo(@ModelAttribute Veiculo veiculo) {
	    veiculoRepository.save(veiculo);
	    return "redirect:/veiculo/listaVeiculo";
	}

	@GetMapping("/veiculo/listaVeiculo")
	public String listaVeiculo(Model model) {
		model.addAttribute("veiculos", veiculoRepository.findAll());
		return "/veiculo/listaVeiculo";
	}

	@GetMapping("/veiculo/editVeiculo/{id}")
	public ModelAndView editVeiculo(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("veiculo/createVeiculo");
		Veiculo veiculo = veiculoRepository.findById(id).orElse(null);
		mv.addObject("veiculo", veiculo);
		mv.addObject("corVeiculoEnum", CorDoVeiculo.values());
		return mv;
	}

	@GetMapping("/veiculo/excluirVeiculo/{id}")
	public String excluirVeiculo(@PathVariable("id") Long id) {
		veiculoRepository.deleteById(id);
		return "redirect:/veiculo/listaVeiculo";
	}
	
}
