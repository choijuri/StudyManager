package my.examples.studymanager.service;

import my.examples.studymanager.domain.Study;
import my.examples.studymanager.dto.StudyDto;
import my.examples.studymanager.dto.StudyFormDto;

import java.util.List;

public interface StudyService {
    public List<Study> getStudiesByUser(Long userId);
    public List<Study> getStudiesByUserIdAndCategoryId(Long userId,Long categoryId);
    public Study getStudy(Long studyId);
    public void deleteStudy(Long studyId);
    public void modifyStudy(StudyDto studyDto);
    public Long addStudy(StudyFormDto studyFormDto);


}
