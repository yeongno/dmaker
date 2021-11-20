package com.fastcam.programing.dmaker.service;

import com.fastcam.programing.dmaker.dto.CreateDeveloper;
import com.fastcam.programing.dmaker.entity.Developer;
import com.fastcam.programing.dmaker.repository.DeveloperRepository;
import com.fastcam.programing.dmaker.type.DeveloperLevel;
import com.fastcam.programing.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper(CreateDeveloper.Request request){
        validateCreateDeveloperRequest(request);

        //business logic start
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build();

        developerRepository.save(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        //business validation
        if (request.getDeveloperLevel() == DeveloperLevel.SENIOR
                && request.getExperienceYears() < 10) {
            throw new RuntimeException("SENIOR need 10 years experience.");
        }

    }
}
