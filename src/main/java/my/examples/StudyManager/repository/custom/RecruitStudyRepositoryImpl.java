package my.examples.StudyManager.repository.custom;

import my.examples.StudyManager.domain.RecruitStudy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RecruitStudyRepositoryImpl extends QuerydslRepositorySupport implements RecruitStudyRepositoryCustom  {

    public RecruitStudyRepositoryImpl(){
        super(RecruitStudy.class);
    }

    @Override
    public List<RecruitStudy> getRecruitStudy(Long categoryId, int start, int limit, String searchKind, String searchStr) {
        return null;
    }

    @Override
    public Long getRecruitStudyCount(Long categoryId, String searchKind, String searchStr) {
        return null;
    }
}
