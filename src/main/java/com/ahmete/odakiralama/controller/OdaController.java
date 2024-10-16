package com.ahmete.odakiralama.controller;

import com.ahmete.odakiralama.dto.request.OdaEklemeRequestDto;
import com.ahmete.odakiralama.dto.response.BaseResponse;
import com.ahmete.odakiralama.entity.Oda;
import com.ahmete.odakiralama.service.OdaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmete.odakiralama.constants.RestApis.*;

@RestController
@RequestMapping(ODA)
@RequiredArgsConstructor
public class OdaController {
	private final OdaService odaService;
	
	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<Boolean>> odaEkleme(@RequestBody OdaEklemeRequestDto dto){
		odaService.odaKaydet(dto);
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
				                         .data(true)
				                         .code(200)
				                         .message("Oda başarılı bir şekilde eklendi")
				                         .success(true)
		                                     .build());
	}
	@GetMapping(FINDALL)
	public ResponseEntity<BaseResponse<List<Oda>>> odaListesi(){
		return ResponseEntity.ok(BaseResponse.<List<Oda>>builder()
				                         .success(true)
				                         .code(200)
				                         .message("Tüm oda listesi getirildi")
				                         .data(odaService.musteriListesi())
		                                     .build());
	}
	
}