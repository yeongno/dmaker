package com.fastcam.programing.dmaker.service;

import com.fastcam.programing.dmaker.dto.CreateDeveloper;
import com.fastcam.programing.dmaker.entity.Developer;
import com.fastcam.programing.dmaker.exception.DMakerErrorCode;
import com.fastcam.programing.dmaker.exception.DMakerException;
import com.fastcam.programing.dmaker.repository.DeveloperRepository;
import com.fastcam.programing.dmaker.type.DeveloperLevel;
import com.fastcam.programing.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.fastcam.programing.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em;

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
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer -> {
                    throw new DMakerException(DMakerErrorCode.DUPLICATED_MEMBER_ID);
                }));
    }
}
