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
@Table(name = "tbl_musteri")
public class Musteri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String ad;
	String soyad;
	String telefon;
	String tc;
	Integer dogumTarihi;
}