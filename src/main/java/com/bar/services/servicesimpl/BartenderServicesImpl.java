package com.bar.services.servicesimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bar.model.Arrays;
import com.bar.repository.IBartenderRepo;
import com.bar.services.IBartenderService;

@Service
public class BartenderServicesImpl implements IBartenderService {

	@Autowired
	private IBartenderRepo repo;

	public int[] bartender(Arrays arrays, int Q) {
		List<Integer> respuesta = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		List<String> Ai = new ArrayList<>();

		int[] P = { 2, 3, 5, 7, 11, 13, 17 };

		String[] A = arrays.getInput_array().split(",");

		for (int i = 0; i < Q; i++) {

			for (String v : A) {
				try {

					int va = Integer.parseInt(v);

					boolean divisible = isDivisible(va, P[i]);
					if (divisible) {
						B.add(va);
					} else {
						Ai.add(v);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			Collections.sort(B, Collections.reverseOrder());
			respuesta.addAll(B);
			A = Ai.toArray(new String[0]);

			B.removeAll(B);
			Ai.removeAll(Ai);
		}

		for (String v : A) {
			try {
				respuesta.add(Integer.parseInt(v));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		return respuesta.stream().mapToInt(Integer::intValue).toArray();
	}

	public Arrays ConsultarArray(Long id) {
		return this.repo.findById(id).get();
	}

	private boolean isDivisible(int numero, int primo) {
		return numero % primo == 0;
	}

}
