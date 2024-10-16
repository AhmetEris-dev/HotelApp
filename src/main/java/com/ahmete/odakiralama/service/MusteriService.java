package com.ahmete.odakiralama.service;

import com.ahmete.odakiralama.dto.request.MusteriEklemeRequestDto;
import com.ahmete.odakiralama.entity.Musteri;
import com.ahmete.odakiralama.mapper.MusteriMapper;
import com.ahmete.odakiralama.repository.MusteriRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusteriService {
	private final MusteriRepository musteriRepository;
	public MusteriService(MusteriRepository musteriRepository) {
		this.musteriRepository = musteriRepository;
	}
	
	public void musteriKaydet(MusteriEklemeRequestDto dto){
		musteriRepository.save(MusteriMapper.INSTANCE.musteriEklemeDto(dto));
	}
	
	public List<Musteri> musteriListesi() {
		return musteriRepository.findAll();
	}
}