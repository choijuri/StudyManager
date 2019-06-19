package my.examples.studymanager.service.impl;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.CurriculumDetail;
import my.examples.studymanager.dto.CurriculumDetailFormDto;
import my.examples.studymanager.repository.CurriculumDetailRepository;
import my.examples.studymanager.repository.CurriculumRepository;
import my.examples.studymanager.service.CurriculumDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumDetailServiceImpl implements CurriculumDetailService {
    private final CurriculumDetailRepository curriculumDetailRepository;
    private final CurriculumRepository curriculumRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CurriculumDetail> getCurriculumDetailByCurriculumId(Long curriculumId) {
        return curriculumDetailRepository.getCurriculumDetailsByCurriculumId(curriculumId);
    }

    @Override
    public CurriculumDetail getCurriculumDetail(Long curriculumDetailId) {
        return curriculumDetailRepository.getOne(curriculumDetailId);
    }

    @Override
    @Transactional
    public void deleteCurriculumDetail(Long curriculumDetailId) {
        curriculumDetailRepository.deleteById(curriculumDetailId);
    }

    @Override
    @Transactional
    public void modifyCurriculumDetail(List<CurriculumDetail> curriculumDetails) {
        for (CurriculumDetail curriculumDetail : curriculumDetails) {
            CurriculumDetail detail = curriculumDetailRepository.getOne(curriculumDetail.getCurriculumDetailId());
            detail.setCurriculumDetailContent(curriculumDetail.getCurriculumDetailContent());
            curriculumDetailRepository.save(detail);
        }
    }

    //    @Override
//    @Transactional
//    public List<CurriculumDetailFormDto> addCurriculumDetail(List<CurriculumDetailFormDto> curriculumDetailFormDtoList) {
//        for (CurriculumDetailFormDto c : curriculumDetailFormDtoList){
//            CurriculumDetail curriculumDetail = new CurriculumDetail();
//
//            curriculumDetail.setCurriculum(curriculumRepository.getOne(c.getCurriculumId()));
//            curriculumDetail.setCurriculumDetailContent(c.getCurriculumDetailContent());
//            curriculumDetailRepository.save(curriculumDetail);
//        }
//        return curriculumDetailFormDtoList;
//    }
    @Override
    @Transactional
    public Long addCurriculumDetail(List<CurriculumDetailFormDto> curriculumDetailFormDtoList) {
        for (CurriculumDetailFormDto c : curriculumDetailFormDtoList) {
            CurriculumDetail curriculumDetail = new CurriculumDetail();

            curriculumDetail.setCurriculum(curriculumRepository.getOne(c.getCurriculumId()));
            curriculumDetail.setCurriculumDetailContent(c.getCurriculumDetailContent());
            curriculumDetailRepository.save(curriculumDetail);

        }
        return curriculumDetailFormDtoList.get(0).getCurriculumId();
    }
}
