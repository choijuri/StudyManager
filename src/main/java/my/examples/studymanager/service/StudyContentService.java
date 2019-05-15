package my.examples.studymanager.service;

import my.examples.studymanager.domain.StudyContent;


public interface StudyContentService {
    public StudyContent getStudyContentByCurriculumDetailId(Long curriculumDetailId);
    public void modifyStudyContent(StudyContent studyContent);
    public void addStudyContent(StudyContent studyContent, Long userId);
}
