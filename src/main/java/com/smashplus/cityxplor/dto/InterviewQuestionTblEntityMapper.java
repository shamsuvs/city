package com.smashplus.cityxplor.dto;

import com.smashplus.cityxplor.domain.InterviewQuestionTblEntity;
import com.smashplus.cityxplor.domain.InterviewQuestionTblEntityDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InterviewQuestionTblEntityMapper {
    InterviewQuestionTblEntity interviewQuestionTblEntityDtoToInterviewQuestionTblEntity(InterviewQuestionTblEntityDto interviewQuestionTblEntityDto);

    InterviewQuestionTblEntityDto interviewQuestionTblEntityToInterviewQuestionTblEntityDto(InterviewQuestionTblEntity interviewQuestionTblEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    InterviewQuestionTblEntity updateInterviewQuestionTblEntityFromInterviewQuestionTblEntityDto(InterviewQuestionTblEntityDto interviewQuestionTblEntityDto, @MappingTarget InterviewQuestionTblEntity interviewQuestionTblEntity);
}
