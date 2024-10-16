package com.ahmete.odakiralama.service;

import com.ahmete.odakiralama.dto.request.KiralamaRequestDto;
import com.ahmete.odakiralama.entity.Durum;
import com.ahmete.odakiralama.entity.Kiralama;
import com.ahmete.odakiralama.entity.Oda;
import com.ahmete.odakiralama.exception.ErrorType;
import com.ahmete.odakiralama.exception.OdaKiralamaException;
import com.ahmete.odakiralama.mapper.KiralamaMapper;
import com.ahmete.odakiralama.repository.KiralamaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KiralamaService {
	private final KiralamaRepository kiralamaRepository;
	private final OdaService odaService;
	public KiralamaService(KiralamaRepository kiralamaRepository, OdaService odaService) {
		this.kiralamaRepository = kiralamaRepository;
		this.odaService=odaService;
	}
	
	public void KiralamaKaydet(KiralamaRequestDto dto){
		Long odaId= dto.odaId();
		Oda oda =odaService.findById(odaId);
		if(oda.getDurum()== Durum.DOLU){
			throw new OdaKiralamaException(ErrorType.ODA_DOLU);
		}
		oda.setDurum(Durum.DOLU);
		kiralamaRepository.save(KiralamaMapper.INSTANCE.fromKiralamaEkleDto(dto));
		
	}
	
	public List<Kiralama> kiralamaListesi() {
		return kiralamaRepository.findAll();
	}
	
	public List<Oda> kiralamaSuresiGecmisDoluOdalar() {
		List<Kiralama> kiralamalar = kiralamaRepository.findAll();
		List<Oda> doluOdalar = new ArrayList<>();
		
		for (Kiralama kiralama : kiralamalar) {
			if (kiralama.getBitisTarihi().isBefore(LocalDate.now())) {
				if (kiralama.getGirisTarihi().isBefore(LocalDate.now())) {
					Oda oda = odaService.findById(kiralama.getOdaId());
					if (oda != null && oda.getDurum() == Durum.DOLU) {
						doluOdalar.add(oda);
					}
				}
			}
		}
		return doluOdalar;
	}
}