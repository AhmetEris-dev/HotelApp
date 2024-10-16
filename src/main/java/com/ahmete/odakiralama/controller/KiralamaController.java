package com.ahmete.odakiralama.controller;

import com.ahmete.odakiralama.dto.request.KiralamaRequestDto;
import com.ahmete.odakiralama.dto.response.BaseResponse;
import com.ahmete.odakiralama.entity.Kiralama;
import com.ahmete.odakiralama.entity.Oda;
import com.ahmete.odakiralama.service.KiralamaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmete.odakiralama.constants.RestApis.*;
@RestController
@RequestMapping(KIRALAMA)
@RequiredArgsConstructor
public class KiralamaController {
	private final KiralamaService kiralamaService;
	
	@PostMapping(ADD)
	public ResponseEntity<BaseResponse<Boolean>> kiralama(@RequestBody KiralamaRequestDto dto){
		kiralamaService.KiralamaKaydet(dto);
		return ResponseEntity.ok(
				BaseResponse.<Boolean>builder()
						.data(true)
						.code(200)
						.message("Kiralama başarılı")
						.success(true)
				            .build()
		);
	}
	
	@GetMapping(FINDALL)
	public ResponseEntity<BaseResponse<List<Kiralama>>> kiralamaListesi(){
		return ResponseEntity.ok(
				BaseResponse.<List<Kiralama>>builder()
						.success(true)
						.message("Tüm kiralama listesi getirildi")
						.code(200)
						.data(kiralamaService.kiralamaListesi())
				            .build()
		);
	}
	
	@GetMapping(DOLU_ODALAR)
	public ResponseEntity<BaseResponse<List<Oda>>> getGecmisDoluOdalar() {
		List<Oda> doluOdalar = kiralamaService.kiralamaSuresiGecmisDoluOdalar();
		return ResponseEntity.ok(
				BaseResponse.<List<Oda>>builder()
				            .success(true)
				            .message("Geçmiş dolu odalar başarıyla getirildi")
				            .code(200)
				            .data(doluOdalar)
				            .build()
		);
	}
}