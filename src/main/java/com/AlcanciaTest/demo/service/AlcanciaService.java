package com.AlcanciaTest.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AlcanciaTest.demo.interfaceService.IAlcanciaService;
import com.AlcanciaTest.demo.interfaces.IAlcancia;
import com.AlcanciaTest.demo.modelo.Alcancia;

@Service
public class AlcanciaService implements IAlcanciaService {

	@Autowired
	private IAlcancia data;

	@Override
	public int save(Alcancia a) {
		int isValid = 0;
		Alcancia alcancia = data.save(a);

		if (!alcancia.equals(null)) {
			isValid = 1;
		}

		return isValid;
	}

	@Override
	public List<Alcancia> listar() {
		// TODO Auto-generated method stub
		return (List<Alcancia>) data.findAll();
	}

	@Override
	public int GetCantidadMonedas() {

		List<Alcancia> a = (List<Alcancia>) data.findAll();
		int cantidad = a.size();

		return cantidad;
	}

	@Override
	public long GetCantidadDinero() {
		List<Alcancia> a = (List<Alcancia>) data.findAll();

		long cantidadDinero = 0;

		for (Alcancia alcancia : a) {
			cantidadDinero += alcancia.getMoneda();
		}

		return cantidadDinero;
	}

	@Override
	public int GetCantidadMonedasByTipo(int tipo) {
		List<Alcancia> a = (List<Alcancia>) data.findAll();

		int cantidadMoneda = 0;

		for (Alcancia alcancia : a) {
			if (alcancia.getMoneda() == tipo) {
				cantidadMoneda++;
			}

		}

		return cantidadMoneda;
	}

	@Override
	public long GetCantidadDineroByTipo(int tipo) {
		List<Alcancia> a = (List<Alcancia>) data.findAll();

		int cantidadDinero = 0;

		for (Alcancia alcancia : a) {
			if (alcancia.getMoneda() == tipo) {
				cantidadDinero += alcancia.getMoneda();
			}

		}

		return cantidadDinero;
	}

	@Override
	public boolean ValidarDenominacion(int denominacion) {

		if (denominacion == 50 || denominacion == 100 || denominacion == 200 || denominacion == 500
				|| denominacion == 1000) {
			return true;
		}
		
		return false;
	}

}
