package com.cenfotec.examen.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cenfotec.examen.domain.Cafe;
import com.cenfotec.examen.domain.Finca;
import com.cenfotec.examen.domain.Productor;
import com.cenfotec.examen.repository.ProductorRepository;

@Controller
public class ProductorController {
	
	@Autowired
	ProductorRepository repo;
	
	@GetMapping("/productorForm")
	public String productorForm(Model model) {
		model.addAttribute("productor", new Productor());
		return "productorForm";
	}
	
	@PostMapping("/index")
	public String productorSubmit(@ModelAttribute Productor productor) {
		repo.save(productor);
		return "index";
	}
	
	@GetMapping("/listaProductores")
	public String productorIndex(Model model) {
		model.addAttribute("productor", repo.findAll());
		return "listaProductores";
	}
	
	@GetMapping("/listaProductores/{id}")
	public String productorIndexId(Model model) {
		model.addAttribute("productor", repo.findAll());
		return "listaProductores";
	}
	
	@GetMapping("/verProductor/{id}")
	public String getProductorById(@PathVariable Long id, Model model) {
		List<Productor> productores = repo.findAll();	
		for(Productor productor : productores) {
			if(productor.getId().equals(id)) {	
				Set<Finca> fincas = new HashSet<Finca>();
						fincas = productor.getFincas();
				model.addAttribute("productor", productor);
			}
		}		
		return "verProductor";
	}
	
	@GetMapping("/fincaForm/{id}")
	public String fincaForm(@PathVariable Long id, Model model) {
		model.addAttribute("finca", new Finca());
		return "fincaForm";
	}
	
	@PostMapping("/listaProductores/{id}")
	public String fincaSubmit(@PathVariable Long id, @ModelAttribute Finca finca) {	
		
		Productor prodUpdate = repo.getOne(id);
		Set<Finca> fincas = new HashSet<Finca>() {{
			add(new Finca(finca.getNombre(), prodUpdate));
		}};
		prodUpdate.setFincas(fincas);
		repo.save(prodUpdate);
		return "index";
	}

	@GetMapping("/cafeForm/{id}")
	public String cafeForm(@PathVariable Long id, Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafeForm";
	}
	
	@PostMapping("/cafeForm/{id}")
	public String cafeSubmit(@PathVariable Long id, @ModelAttribute Cafe cafe) {	
		
		List<Productor> prodUpdate = repo.findAll();
		Set<Finca> fns;
		Set<Cafe> cfs = null;
		Finca finca = null;
		Long prod_id = (long) 0;
		Productor pro;
		
		for(Productor prod:prodUpdate) {
			Set<Finca> fincas = prod.getFincas();
			for(Finca fn:fincas) {
				if(fn.getId().equals(id)) {
					Set<Cafe> cafes = new HashSet<Cafe>() {{
						add(new Cafe(cafe.getNombre(), fn));
					}};
					finca = fn;
					cfs = cafes;
					prod_id=fn.getProductor().getId();	
				}
			}			
		}
		
		pro = repo.getOne(prod_id);
		pro.getFincas().remove(finca);
		finca.setCafes(cfs);
		pro.getFincas().add(finca);
		repo.save(pro);
		
		return "index";
	}
	
}
