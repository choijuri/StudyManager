package my.examples.studymanager.service;

import my.examples.studymanager.domain.Curriculum;

import java.util.List;

public interface CurriculumService {
    public List<Curriculum> getCurriculumByStudyId(Long studyId);
    public boolean deleteCurriculum(Long curriculumId);
    public boolean modifyCurriculum(Curriculum curriculum);
    public void addCurriculum(Curriculum curriculum, Long studyId);
}
