package com.ahmete.odakiralama.service;

import com.ahmete.odakiralama.dto.request.OdaEklemeRequestDto;
import com.ahmete.odakiralama.entity.Oda;
import com.ahmete.odakiralama.mapper.OdaMapper;
import com.ahmete.odakiralama.repository.OdaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdaService {
	public final OdaRepository odaRepository;
	public OdaService(OdaRepository odaRepository) {
		this.odaRepository = odaRepository;
	}
	
	public void odaKaydet(OdaEklemeRequestDto dto){
		odaRepository.save(OdaMapper.INSTACE.odaEklemeDto(dto));
	}
	
	public List<Oda> musteriListesi() {
		return odaRepository.findAll();
	}
	
	public Oda findById(Long odaId) {
		return odaRepository.findById(odaId)
		                    .orElseThrow(() -> new RuntimeException("Oda bulunamadı. ID: " + odaId));
	}
}