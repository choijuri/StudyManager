package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.CurriculumDetail;
import my.examples.studymanager.repository.CurriculumDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumDetailServiceImpl implements CurriculumDetailService {
    private final CurriculumDetailRepository curriculumDetailRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CurriculumDetail> getCurriculumDetailByCurriculumId(Long curriculumId) {
        return curriculumDetailRepository.getCurriculumDetailsByCurriculumId(curriculumId);
    }

    @Override
    @Transactional
    public void deleteCurriculumDetail(Long curriculumDetailId) {
        curriculumDetailRepository.deleteById(curriculumDetailId);
    }

    @Override
    @Transactional
    public void modifyCurriculumDetail(CurriculumDetail curriculumDetail) {

    }

    @Override
    @Transactional
    public void addCurriculumDetail(CurriculumDetail curriculumDetail) {
        curriculumDetailRepository.save(curriculumDetail);
    }
}
