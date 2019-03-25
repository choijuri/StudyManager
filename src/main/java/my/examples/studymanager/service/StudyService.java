package my.examples.studymanager.service;

import my.examples.studymanager.domain.Study;

import java.util.List;

public interface StudyService {
    public List<Study> getStudiesByCategory(String category);
    public Study getStudy(Long studyId);
    public boolean deleteStudy(Long studyId);
    public boolean modifyStudy(Study study);
    public void addStudy(Study study);

}
