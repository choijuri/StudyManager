package my.examples.studymanager.service;

import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.dto.CurriculumFormDto;

import java.util.List;

public interface CurriculumService {
    public List<Curriculum> getCurriculumByStudyId(Long studyId);
    public void deleteCurriculum(Long curriculumId);
    public void modifyCurriculum(Long curriculumId, String curriculumContent);
    public void addCurriculum(List<CurriculumFormDto> curriculumFormDtoList);
    public Curriculum getcurriculum(Long curriculumId);
}
