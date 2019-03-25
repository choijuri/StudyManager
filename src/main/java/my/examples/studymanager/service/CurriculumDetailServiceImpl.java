package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.CurriculumDetail;
import my.examples.studymanager.repository.CurriculumDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumDetailServiceImpl implements CurriculumDetailService {
    private final CurriculumDetailRepository curriculumDetailRepository;

    @Override
    public List<CurriculumDetail> getCurriculumDetailByCurriculumId(Long curriculumId) {
        return null;
    }

    @Override
    public void deleteCurriculumDetail(Long curriculumDetailId) {

    }

    @Override
    public void modifyCurriculumDetail(CurriculumDetail curriculumDetail) {
        
    }

    @Override
    public void addCurriculumDetail(CurriculumDetail curriculumDetail) {

    }
}
