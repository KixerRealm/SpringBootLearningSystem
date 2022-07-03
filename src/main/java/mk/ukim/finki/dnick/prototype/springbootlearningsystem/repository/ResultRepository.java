package mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    String findByUsername(String username);
}
