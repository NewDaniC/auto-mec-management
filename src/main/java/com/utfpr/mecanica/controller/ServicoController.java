package com.utfpr.mecanica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.utfpr.mecanica.entities.Item;
import com.utfpr.mecanica.entities.Manutencao;
import com.utfpr.mecanica.entities.Servico;
import com.utfpr.mecanica.repositories.ItemRepository;
import com.utfpr.mecanica.repositories.ManutencaoRepository;
import com.utfpr.mecanica.repositories.ServicoRepository;

@Controller
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ManutencaoRepository manutencaoRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/servico/createServico")
	public ModelAndView homeServico() {
		ModelAndView mv = new ModelAndView("servico/createServico");
		mv.addObject("servico", new Servico());
		mv.addObject("manutencoes", manutencaoRepository.findAll());
		mv.addObject("itens", itemRepository.findAll());
		return mv;
	}
	
//	@PostMapping("/servico/createServico")
//    public String createServico(Servico servico, @RequestParam("manutencao_id") Long manutencaoId, @RequestParam("item_id") Long itemId) {
//        servicoRepository.save(servico);
//        
//        Manutencao manutencao = manutencaoRepository.findById(manutencaoId).orElse(null);
//        //servico.getId().add(categoria);
//		
//		Item item = itemRepository.findById(itemId).orElse(null);
//		//item.getId().add(id);
//		
//		servicoRepository.save(servico);
//        
//        return "redirect:/servico/listaServico";
//    }
	
	@PostMapping("/servico/createServico")
	public String createServico(Servico servico, @RequestParam("manutencao_id") Long manutencaoId,
			@RequestParam("item_id") Long itemId) {
		Manutencao manutencao = manutencaoRepository.findById(manutencaoId).orElse(null);
		if (manutencao != null) {
			servico.setManutencao(manutencao);
		}

		Item item = itemRepository.findById(itemId).orElse(null);
		if (item != null) {
			servico.setItem(item);
		}

		servicoRepository.save(servico);

		return "redirect:/servico/listaServico";
	}
	
	@GetMapping("/servico/listaServico")
	public String listaServico(Model model) {
		List<Servico> servicos = servicoRepository.findAll();
		model.addAttribute("servicos", servicos);
		return "/servico/listaServico";
	}	
}
