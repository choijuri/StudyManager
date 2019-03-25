package my.examples.studymanager.repository.custom;

import my.examples.studymanager.domain.RecruitStudy;

import java.util.List;

public interface RecruitStudyRepositoryCustom {
    public List<RecruitStudy> getRecruitStudy(Long categoryId, int start, int limit, String searchKind, String searchStr);
    public Long getRecruitStudyCount(Long categoryId, String searchKind, String searchStr);
}



