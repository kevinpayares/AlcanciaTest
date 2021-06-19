package com.AlcanciaTest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AlcanciaTest.demo.interfaceService.IAlcanciaService;
import com.AlcanciaTest.demo.modelo.Alcancia;

@Controller
@RequestMapping
public class AlcanciaController {
	
	@Autowired
	private IAlcanciaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Alcancia> alcancia = service.listar();
		model.addAttribute("alcancia", alcancia);
		return "index";
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> Save(int denominacion, Model model ) {
		try {
			if (!service.ValidarDenominacion(denominacion)) {
				return new ResponseEntity<>("Error, solo se permiten monedas con denominacion de 50, 100, 200, 500 y 1000 pesos", HttpStatus.BAD_REQUEST);	
			}
			
			Alcancia a = new Alcancia();
			a.setMoneda(denominacion);
			String result = Integer.toString(service.save(a));
			return new ResponseEntity<>(result, HttpStatus.OK);	
			
		} catch (Exception e) {
			return new ResponseEntity<>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/GetCantidadMonedas")
	public ResponseEntity<String> GetCantidadMonedas() {
		try {
			String result = Integer.toString(service.GetCantidadMonedas());
			String mensaje = "La cantidad de monedas en la alcancia es: "+result;
			return new ResponseEntity<>(mensaje, HttpStatus.OK);	
			
		} catch (Exception e) {
			return new ResponseEntity<>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
		
	@GetMapping("/GetCantidadDinero")
	public ResponseEntity<String> GetCantidadDinero() {
		try {
			String result =  Long.toString(service.GetCantidadDinero());
			String mensaje = "La cantidad de dinero en la alcancia es: $"+result+" pesos";
			return new ResponseEntity<>(mensaje, HttpStatus.OK);	
			
		} catch (Exception e) {
			return new ResponseEntity<>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/GetCantidadMonedasByTipo")
	public ResponseEntity<String> GetCantidadMonedasByTipo(int tipo) {
		try {
			String result =  Integer.toString(service.GetCantidadMonedasByTipo(tipo));
			String mensaje = "La cantidad de monedas de $"+Integer.toString(tipo)+" es :"+result;
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/GetCantidadDineroByTipo")
	public ResponseEntity<String> GetCantidadDineroByTipo(int tipo) {
		try {
			String result =  Long.toString(service.GetCantidadDineroByTipo(tipo));
			String mensaje = "La cantidad de dinero en monedas de $"+Integer.toString(tipo)+" es : $"+result+" pesos";
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}	
}
