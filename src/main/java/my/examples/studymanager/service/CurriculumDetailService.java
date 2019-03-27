package my.examples.studymanager.service;


import my.examples.studymanager.domain.CurriculumDetail;
import java.util.List;

public interface CurriculumDetailService {
    public List<CurriculumDetail> getCurriculumDetailByCurriculumId(Long curriculumId);
    public void deleteCurriculumDetail(Long curriculumDetailId);
    public void modifyCurriculumDetail(CurriculumDetail curriculumDetail);
    public void addCurriculumDetail(CurriculumDetail curriculumDetail);

}