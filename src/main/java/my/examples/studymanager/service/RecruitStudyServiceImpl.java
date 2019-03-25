package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.repository.RecruitStudyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitStudyServiceImpl implements RecruitStudyService {
    private final RecruitStudyRepository recruitStudyRepository;

    @Override
    public List<RecruitStudy> getRecruitStudyAll() {
        return null;
    }

    @Override
    public void addRecruitStudy(RecruitStudy recruitStudy, String userId) {

    }

    @Override
    public RecruitStudy getRecruitStudy(Long recruitStudyId) {
        return null;
    }

    @Override
    public List<RecruitStudy> searchRecruitStudy(int page, Long categoryId, String searchType, String searchStr) {
        return null;
    }
}
