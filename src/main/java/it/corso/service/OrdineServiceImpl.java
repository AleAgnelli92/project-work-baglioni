package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.OrdineDao;
import it.corso.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineDao ordineDao;
	@Override
	public List<Ordine> getOrdini() {
		return (List<Ordine>) ordineDao.findAll();
	}

}
