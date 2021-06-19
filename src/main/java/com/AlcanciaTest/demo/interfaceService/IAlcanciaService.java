package com.AlcanciaTest.demo.interfaceService;

import java.util.List;

import com.AlcanciaTest.demo.modelo.Alcancia;

public interface IAlcanciaService {
	//0. Nos permite obtener todos los datos
	public List<Alcancia>listar();
	
	//1. Nos permite almacenar una moneda
	public int save(Alcancia a);
	
	//2. Permite obtener la cantidad de monedas en la alcancia
	public int GetCantidadMonedas();
	
	//3. Permite obtener la cantidad de dinero dentro de la alcancia
	public long GetCantidadDinero();
	
	//4. Permite obtener la cantidad de monedas por tipo
	public int GetCantidadMonedasByTipo(int tipo); 
	
	//5. Permite obtener la cantidad de dinero por tipo dentro de la alcancia
	public long GetCantidadDineroByTipo(int tipo);

	//6. Permite validar las monedas al momento de almacenarla
	public boolean ValidarDenominacion(int denominacion);
	
}
