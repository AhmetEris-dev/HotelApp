package com.ahmete.odakiralama.controller;

import com.ahmete.odakiralama.dto.request.MusteriEklemeRequestDto;
import com.ahmete.odakiralama.dto.response.BaseResponse;
import com.ahmete.odakiralama.entity.Musteri;
import com.ahmete.odakiralama.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmete.odakiralama.constants.RestApis.*;

@RestController
@RequestMapping(MUSTERI)
@RequiredArgsConstructor
public class MusteriController {
	private final MusteriService musteriService;
	
	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<Boolean>> musteriEkleme(@RequestBody MusteriEklemeRequestDto dto){
		musteriService.musteriKaydet(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
				                         .data(true)
				                         .code(200)
				                         .success(true)
				                         .message("Kayıt başarılı bir şekilde gercekleşti")
		                                     .build());
	}
	
	@GetMapping(FINDALL)
	public ResponseEntity<BaseResponse<List<Musteri>>> musteriListe(){
		return ResponseEntity.ok(BaseResponse.<List<Musteri>>builder()
				                         .success(true)
				                         .code(200)
				                         .message("Tüm musteri listesi getirildi")
				                         .data(musteriService.musteriListesi())
		                                     .build());
	}
}