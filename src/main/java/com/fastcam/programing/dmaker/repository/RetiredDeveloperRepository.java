package com.fastcam.programing.dmaker.repository;

import com.fastcam.programing.dmaker.entity.Developer;
import com.fastcam.programing.dmaker.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiredDeveloperRepository
        extends JpaRepository<RetiredDeveloper, Long> {

}
