package my.examples.studymanager.service;


import my.examples.studymanager.domain.CurriculumDetail;
import my.examples.studymanager.dto.CurriculumDetailFormDto;

import java.util.List;

public interface CurriculumDetailService {
    public List<CurriculumDetail> getCurriculumDetailByCurriculumId(Long curriculumId);
    public void deleteCurriculumDetail(Long curriculumDetailId);
    public void modifyCurriculumDetail(List<CurriculumDetail> curriculumDetails);
    public boolean addCurriculumDetail(List<CurriculumDetailFormDto> curriculumDetailFormDtoList);

}
