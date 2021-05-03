package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.SeminarSponsor;
import com.db.library.model.SeminarSponsorId;

public interface SeminarSponsorRepository extends JpaRepository<SeminarSponsor, SeminarSponsorId>{

}
