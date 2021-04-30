package com.db.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.db.library.model.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {

}
