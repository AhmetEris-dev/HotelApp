package com.ahmete.odakiralama.mapper;

import com.ahmete.odakiralama.dto.request.KiralamaRequestDto;
import com.ahmete.odakiralama.entity.Kiralama;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KiralamaMapper {
	
	KiralamaMapper INSTANCE = Mappers.getMapper(KiralamaMapper.class);
	
	Kiralama fromKiralamaEkleDto(final KiralamaRequestDto dto);
}