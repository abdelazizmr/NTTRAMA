package com.ntt.cinema.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ntt.cinema.models.Nationality;


public interface NationalityRepository extends JpaRepository<Nationality, Integer> {
}
