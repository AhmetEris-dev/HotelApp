package com.ahmete.odakiralama.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record KiralamaRequestDto(
		
		Long musteriId,
		Long odaId,
		LocalDate girisTarihi,
		LocalDate bitisTarihi
) {
}