package com.utfpr.mecanica.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.utfpr.mecanica.entities.Manutencao;
import com.utfpr.mecanica.entities.Veiculo;
import com.utfpr.mecanica.repositories.ManutencaoRepository;
import com.utfpr.mecanica.repositories.VeiculoRepository;

@Controller
public class ManutencaoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private ManutencaoRepository manutencaoRepository;

	@GetMapping("/manutencao/createManutencao")
	public ModelAndView homeManutencao() {
		ModelAndView mv = new ModelAndView("manutencao/createManutencao");
		mv.addObject("manutencao", new Manutencao());
		mv.addObject("cars", veiculoRepository.findAll());
		return mv;
	}
	
	@PostMapping("/manutencao/createManutencao")
	public String createManutencao(Manutencao manutencao, @RequestParam("veiculo.id") Long veiculoId) {
//	public String createManutencao(Manutencao manutencao, @RequestParam("veiculo_id") Long veiculoId) {
	    if (manutencao.getId() != null) { // EDIT MANUTENCAO
//	        System.out.println("EDIT MANUTENCAO: " + manutencao.getId());
//	        System.out.println("O nome da manutencao é: " + manutencao.getNome());

	        Veiculo veiculo = veiculoRepository.findById(veiculoId).orElse(null);
	        manutencao.setVeiculo(veiculo);
	        manutencaoRepository.save(manutencao);
	        
	    } else { // NEW MANUTENCAO
//	        System.out.println("NEW MANUTENCAO: " + manutencao.getId());

	        Veiculo veiculo = veiculoRepository.findById(veiculoId).orElse(null);
	        manutencao.setVeiculo(veiculo);

	        manutencaoRepository.save(manutencao);
	    }

	    return "redirect:/manutencao/listaManutencao";
	}
	
	@GetMapping("/manutencao/listaManutencao")
	public String listaManutencao(Model model) {
		List<Manutencao> manutencoes = manutencaoRepository.findAll();
		model.addAttribute("manutencoes", manutencoes);
		return "/manutencao/listaManutencao";
	}
		
	@ControllerAdvice
	class DateControllerAdvice {

	    @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	}
	
}
