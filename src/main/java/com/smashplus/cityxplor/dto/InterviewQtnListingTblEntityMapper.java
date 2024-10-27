package com.smashplus.cityxplor.dto;

import com.smashplus.cityxplor.domain.InterviewQtnListingTblEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InterviewQtnListingTblEntityMapper {
    InterviewQtnListingTblEntity interviewQtnListingTblEntityDtoToInterviewQtnListingTblEntity(InterviewQtnListingTblEntityDto interviewQtnListingTblEntityDto);

    InterviewQtnListingTblEntityDto interviewQtnListingTblEntityToInterviewQtnListingTblEntityDto(InterviewQtnListingTblEntity interviewQtnListingTblEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    InterviewQtnListingTblEntity updateInterviewQtnListingTblEntityFromInterviewQtnListingTblEntityDto(InterviewQtnListingTblEntityDto interviewQtnListingTblEntityDto, @MappingTarget InterviewQtnListingTblEntity interviewQtnListingTblEntity);

    @AfterMapping
    default void linkIntListingQtnMappingsById(@MappingTarget InterviewQtnListingTblEntity interviewQtnListingTblEntity) {
        interviewQtnListingTblEntity.getIntListingQtnMappingsById().forEach(intListingQtnMappingsById -> intListingQtnMappingsById.setInterviewQtnListingTblByIntListId(interviewQtnListingTblEntity));
    }
}
