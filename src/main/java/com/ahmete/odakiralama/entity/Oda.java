package com.ahmete.odakiralama.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_oda")
public class Oda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long odaNo;
	Long kapasite;
	@Builder.Default
	@Enumerated(EnumType.STRING)
	Durum durum= Durum.BOS;
	
}