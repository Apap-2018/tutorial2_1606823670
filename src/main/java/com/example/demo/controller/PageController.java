package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping(value = {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required=false, defaultValue="0") int jumlah_a,
								@RequestParam(value="b", required=false, defaultValue="0") int jumlah_b, Model model) {
		model.addAttribute("n_a", jumlah_a);
		model.addAttribute("n_b", jumlah_b);
	
		hmGenerator(jumlah_a, jumlah_b, model);
		return "generator";
	}
	
	public String hmGenerator(int a, int b, Model model) {
		String awal = "hm";
		String hasil = "";
		int parameter = 2;
		
		//proses generate
		if (a>=parameter || b>=parameter) {
			for (int i = 1; i<a; i++) {
				awal+="m";
			}
			for (int i = 0; i<b; i++) {
				String iterasi = awal +" ";
				hasil += iterasi;
			}
		}else {
			hasil = awal;
		}
		
		model.addAttribute("hm", hasil);
		return "generator";
	}
		
}
