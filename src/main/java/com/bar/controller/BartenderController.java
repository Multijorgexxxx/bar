package com.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bar.model.Arrays;
import com.bar.model.request.Request;
import com.bar.services.IBartenderService;

@RestController
public class BartenderController {

	@Autowired
	private IBartenderService barservice;

	@PostMapping("/Iniciar")
	public ResponseEntity<?> bar(@RequestBody Request request) {

		if (request.getId() >= 1 && request.getId() <= 5) {

			Arrays arrays = barservice.ConsultarArray(request.getId());

			int[] resultado = barservice.bartender(arrays, request.getQ());

			return ResponseEntity.status(HttpStatus.OK).body(resultado);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error validar el valor para el parametro ID ya que solo se permite numeros del 1 al 5");
		}
	}
}
