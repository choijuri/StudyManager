package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Curriculum;
import my.examples.studymanager.repository.CurriculumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumServiceImpl implements CurriculumService {
    private final CurriculumRepository curriculumRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Curriculum> getCurriculumByStudyId(Long studyId) {
        return curriculumRepository.getCurriculumByStudyId(studyId);
    }

    @Override
    public void deleteCurriculum(Long curriculumId) {
        curriculumRepository.deleteById(curriculumId);
    }

    @Override
    public void modifyCurriculum(Curriculum curriculum) {

    }

    @Override
    public void addCurriculum(Curriculum curriculum, Long studyId) {

    }
}
