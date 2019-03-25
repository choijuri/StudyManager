package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.Study;
import my.examples.studymanager.repository.StudyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;


    @Override
    public List<Study> getStudiesByCategory(String category) {
        return studyRepository.getStudiesByCategory(category);
    }

    @Override
    public Study getStudy(Long studyId) {
        return studyRepository.getOne(studyId);
    }

    @Override
    public boolean deleteStudy(Long studyId) {
        return false;
    }

    @Override
    public boolean modifyStudy(Study study) {
        return false;
    }

    @Override
    public void addStudy(Study study) {

    }
}
