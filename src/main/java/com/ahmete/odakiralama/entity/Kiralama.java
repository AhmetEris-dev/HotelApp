package com.ahmete.odakiralama.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_kiralama")
public class Kiralama {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long musteriId;
	Long odaId;
	LocalDate girisTarihi;
	LocalDate bitisTarihi;
}