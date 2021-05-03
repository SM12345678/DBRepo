package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor,Integer>{

}
