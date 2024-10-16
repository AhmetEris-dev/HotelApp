package com.ahmete.odakiralama.dto.request;

public record MusteriEklemeRequestDto(
		String ad,
		String soyad,
		String telefon,
		String tc,
		Integer dogumTarihi
) {
}