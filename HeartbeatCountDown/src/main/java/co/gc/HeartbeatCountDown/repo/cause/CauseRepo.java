package co.gc.HeartbeatCountDown.repo.cause;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gc.HeartbeatCountDown.model.causes.Cause;

public interface CauseRepo extends JpaRepository<Cause, Integer> {

}
