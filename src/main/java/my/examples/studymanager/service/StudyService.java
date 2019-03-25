package my.examples.studymanager.service;

import my.examples.studymanager.domain.Study;

import java.util.List;

public interface StudyService {
    public List<Study> getStudiesAll(String email);
    public List<Study> getStudiesByCategory(String email, String category);
    public Study getStudy(String studyId);
    public boolean deleteStudy(String studyId);
    public boolean modifyStudy(Study study);
    public void addStudy(Study study);

}
