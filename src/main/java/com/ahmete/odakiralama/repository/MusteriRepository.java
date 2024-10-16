package com.ahmete.odakiralama.repository;

import com.ahmete.odakiralama.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusteriRepository extends JpaRepository<Musteri, Long> {
}