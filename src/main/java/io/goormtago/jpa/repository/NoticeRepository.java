package io.goormtago.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.goormtago.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
