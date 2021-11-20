package com.fastcam.programing.dmaker.repository;

import com.fastcam.programing.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {

}
