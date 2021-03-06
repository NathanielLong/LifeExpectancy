package co.gc.HeartbeatCountDown.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gc.HeartbeatCountDown.model.User;


public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUserName(String username);
}
