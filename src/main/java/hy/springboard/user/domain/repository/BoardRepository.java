package hy.springboard.user.domain.repository;

import hy.springboard.user.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
