package com.ahmete.odakiralama.mapper;

import com.ahmete.odakiralama.dto.request.OdaEklemeRequestDto;
import com.ahmete.odakiralama.entity.Oda;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OdaMapper {
	
	OdaMapper INSTACE= Mappers.getMapper(OdaMapper.class);
	
	Oda odaEklemeDto(final OdaEklemeRequestDto dto);
}