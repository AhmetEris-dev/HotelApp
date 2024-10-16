package com.ahmete.odakiralama.repository;

import com.ahmete.odakiralama.entity.Kiralama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KiralamaRepository extends JpaRepository<Kiralama, Long> {
}