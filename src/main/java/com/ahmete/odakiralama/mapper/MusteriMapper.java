package com.ahmete.odakiralama.mapper;

import com.ahmete.odakiralama.dto.request.MusteriEklemeRequestDto;
import com.ahmete.odakiralama.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusteriMapper {
	
	MusteriMapper INSTANCE= Mappers.getMapper(MusteriMapper.class);
	
	Musteri musteriEklemeDto(final MusteriEklemeRequestDto dto);
}