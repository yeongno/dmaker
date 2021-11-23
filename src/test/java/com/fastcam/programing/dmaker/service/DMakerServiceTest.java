package com.fastcam.programing.dmaker.service;

import com.fastcam.programing.dmaker.code.StatusCode;
import com.fastcam.programing.dmaker.dto.CreateDeveloper;
import com.fastcam.programing.dmaker.dto.DeveloperDetailDto;
import com.fastcam.programing.dmaker.dto.DeveloperDto;
import com.fastcam.programing.dmaker.entity.Developer;
import com.fastcam.programing.dmaker.entity.RetiredDeveloper;
import com.fastcam.programing.dmaker.repository.DeveloperRepository;
import com.fastcam.programing.dmaker.type.DeveloperLevel;
import com.fastcam.programing.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.fastcam.programing.dmaker.code.StatusCode.EMPLOYED;
import static com.fastcam.programing.dmaker.type.DeveloperLevel.SENIOR;
import static com.fastcam.programing.dmaker.type.DeveloperSkillType.FRONT_END;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DMakerServiceTest {

    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloper retiredDeveloper;

    @InjectMocks
    private DMakerService dMakerService;

    @Test
    public void testSomething(){
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(Developer.builder()
                                .developerLevel(SENIOR)
                                .developerSkillType(FRONT_END)
                                .experienceYears(12)
                                .statusCode(EMPLOYED)
                                .name("name")
                                .age(12)
                                .build()));

        DeveloperDetailDto developerDetail = dMakerService.getDeveloperDetail("memberId");

        assertEquals(SENIOR, developerDetail.getDeveloperLevel());
        assertEquals(FRONT_END, developerDetail.getDeveloperSkillType());
        assertEquals(12,developerDetail.getAge());
        assertEquals("name", developerDetail.getName());
    }

}