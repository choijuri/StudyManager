package my.examples.studymanager.service;

import my.examples.studymanager.domain.StudyContent;
import my.examples.studymanager.dto.StudyContentDto;


public interface StudyContentService {
    public StudyContent getStudyContentByCurriculumDetailId(Long curriculumDetailId);
    public void modifyStudyContent(StudyContent studyContent);
    public Long addStudyContent(StudyContentDto studyContent, Long userId);
}
