package api.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.casino.entity.user.session.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}