package com.db.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.library.model.Organization;

public interface OrgRepository extends JpaRepository<Organization, Integer>{

}
