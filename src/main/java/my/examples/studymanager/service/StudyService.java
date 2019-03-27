package my.examples.studymanager.service;

import my.examples.studymanager.domain.Study;

import java.util.List;

public interface StudyService {
    public List<Study> getStudiesByUser(String userId);
    public List<Study> getStudiesByUserIdAndCategoryId(String userId,Long categoryId);
    public Study getStudy(Long studyId);
    public void deleteStudy(Long studyId);
    public void modifyStudy(Study study);
    public void addStudy(Study study);

}
