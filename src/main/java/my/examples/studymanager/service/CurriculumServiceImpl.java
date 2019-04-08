package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.dto.CurriculumFormDto;
import my.examples.studymanager.repository.CurriculumRepository;
import my.examples.studymanager.repository.StudyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumServiceImpl implements CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final StudyRepository studyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Curriculum> getCurriculumByStudyId(Long studyId) {
        return curriculumRepository.getCurriculumByStudyId(studyId);
    }

    @Override
    @Transactional
    public void deleteCurriculum(Long curriculumId) {
        curriculumRepository.deleteById(curriculumId);
    }

    @Override
    @Transactional
    public void modifyCurriculum(Long curriculumId, String curriculumContent) {
        Curriculum curriculum = curriculumRepository.getOne(curriculumId);
        curriculum.setCurriculumContent(curriculumContent);
        curriculumRepository.save(curriculum);
    }

    @Override
    @Transactional
    public void addCurriculum(List<CurriculumFormDto> curriculumFormDtoList) {
        for(CurriculumFormDto c : curriculumFormDtoList) {
            Curriculum curriculum = new Curriculum();
            curriculum.setStudy(studyRepository.getOne(c.getStudyId()));
            curriculum.setCurriculumContent(c.getCurriculumContent());
            curriculumRepository.save(curriculum);
        }
    }
}
