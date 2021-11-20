package com.fastcam.programing.dmaker.repository;

import com.fastcam.programing.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {

    Optional<Developer> findByMemberId(String memberId);
}
