package my.examples.studymanager.service;

import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.domain.StudyContent;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudyContentService {
    public StudyContent getStudyContentByCurriculumId(Long curriculumdetailId);
    public void modifyStudyContent(StudyContent studyContent);
    public void addStudyContent(StudyContent studyContent, String userId);

}
