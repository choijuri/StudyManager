package my.examples.studymanager.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import my.examples.studymanager.domain.QRecruitStudy;
import my.examples.studymanager.domain.RecruitStudy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RecruitStudyRepositoryImpl extends QuerydslRepositorySupport implements RecruitStudyRepositoryCustom  {

    public RecruitStudyRepositoryImpl(){
        super(RecruitStudy.class);
    }

    @Override
    public List<RecruitStudy> getRecruitStudy(Long categoryId, int start, int limit, String searchKind, String searchStr) {
        QRecruitStudy qRecruitStudy = QRecruitStudy.recruitStudy;
        JPQLQuery<RecruitStudy> jpqlQuery = from(qRecruitStudy).innerJoin(qRecruitStudy.category).fetchJoin().distinct();

        if(categoryId != null){
            jpqlQuery.where(qRecruitStudy.category.categoryId.eq(categoryId));
        }

        searchWhere(searchKind,searchStr,qRecruitStudy,jpqlQuery);

        jpqlQuery.orderBy(qRecruitStudy.recruitId.desc());
        jpqlQuery.offset(start).limit(limit);
        return jpqlQuery.fetch();
    }

    @Override
    public Long getRecruitStudyCount(Long categoryId, String searchKind, String searchStr) {
        QRecruitStudy qRecruitStudy = QRecruitStudy.recruitStudy;
        JPQLQuery<RecruitStudy> jpqlQuery = from(qRecruitStudy).innerJoin(qRecruitStudy.category);

        if (categoryId != null) {
            jpqlQuery.where(qRecruitStudy.category.categoryId.eq(categoryId));
        }
        searchWhere(searchKind,searchStr,qRecruitStudy,jpqlQuery);

        return jpqlQuery.fetchCount();
    }

    private void searchWhere(String searchKind, String searchStr, QRecruitStudy qRecruitStudy, JPQLQuery<RecruitStudy> jpqlQuery) {
        if ("RECRUITSTUDYNAME_SEARCH".equals(searchKind)) {
            jpqlQuery.where(qRecruitStudy.recruitName.like("%" + searchStr + "%"));
        } else if ("RECRUITSTUDYLOCATION_SEARCH".equals(searchKind)) {
            jpqlQuery.where(qRecruitStudy.location.like("%" + searchStr + "%"));
        }
    }

}
