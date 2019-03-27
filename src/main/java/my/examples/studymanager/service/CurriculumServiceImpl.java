package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Curriculum;
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
    public void modifyCurriculum(Curriculum curriculum) {

    }

    @Override
    @Transactional
    public void addCurriculum(Curriculum curriculum, Long studyId) {
        curriculum.setStudy(studyRepository.getOne(studyId));
        curriculumRepository.save(curriculum);
    }
}
