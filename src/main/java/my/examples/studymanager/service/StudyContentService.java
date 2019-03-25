package my.examples.studymanager.service;

import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.domain.StudyContent;

import java.util.List;

public interface StudyContentService {
    public StudyContent getStudyContentByCurriculumId(Long curriculumdetailId);
    public boolean modifyStudyContent(StudyContent studyContent);
    public void addStudyContent(StudyContent studyContent, String userId);

}
