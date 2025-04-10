package br.com.sodresoftwares.geradorcpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sodresoftwares.geradorcpf.service.GeradorCpfService;


@Controller
public class GeradorCpfController {
	
	public GeradorCpfService geradorCpfService;
	
	public GeradorCpfController(GeradorCpfService geradorCpfService) {
		this.geradorCpfService = geradorCpfService;
	}
	
	@GetMapping("/")
	public String acessarPagina() {
		return "/gerador-cpf/gerador-cpf";
	}
	
	@PostMapping("/gerar-cpf-aleatorio")
	public String gerarCpfAleatorio(RedirectAttributes redirectAttributes,
									@RequestParam("acao")String acao, @RequestParam("uf")String uf,
									@RequestParam("pontuacao") String pontuacao) {
		if(acao.equalsIgnoreCase("gerar")) {
			/*Gerando CPF Aleatorio*/
			String cpf = geradorCpfService.gerarCpfAleatorio(uf,pontuacao);
			redirectAttributes.addFlashAttribute("cpfAle", cpf);
		}
		return "redirect:/";
	}
}
