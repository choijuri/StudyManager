package my.examples.studymanager.service.impl;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.dto.RecruitStudyDto;
import my.examples.studymanager.repository.CategoryRepository;
import my.examples.studymanager.repository.RecruitStudyRepository;
import my.examples.studymanager.repository.UserRepository;
import my.examples.studymanager.repository.custom.RecruitStudyRepositoryCustom;
import my.examples.studymanager.repository.custom.RecruitStudyRepositoryImpl;
import my.examples.studymanager.service.RecruitStudyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitStudyServiceImpl implements RecruitStudyService {
    private final RecruitStudyRepository recruitStudyRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    public final static String RECRUITSTUDYNAME_SEARCH = "name_search";
    public final static String RECRUITSTUDYLOCATION_SEARCH = "location_search";

    @Override
    @Transactional(readOnly = true)
    public List<RecruitStudy> getRecruitStudyAll() {
        return recruitStudyRepository.findAll();
    }

    @Override
    @Transactional
    public void addRecruitStudy(RecruitStudyDto recruitStudyDto, Long userId) {
            RecruitStudy recruitStudy = new RecruitStudy();
            recruitStudy.setUser(userRepository.getOne(userId));
            recruitStudy.setLocation(recruitStudyDto.getSido1() +" "+recruitStudyDto.getGugun1());
            recruitStudy.setRecruitContent(recruitStudyDto.getRecruitContent());
            recruitStudy.setRecruitName(recruitStudyDto.getRecruitName());
            recruitStudy.setRecruitNumber(recruitStudyDto.getRecruitNumber());
            recruitStudy.setCategory(categoryRepository.getOne(recruitStudyDto.getCategoryId()));
            recruitStudyRepository.save(recruitStudy);
    }

    @Override
    @Transactional(readOnly = true)
    public RecruitStudy getRecruitStudy(Long recruitStudyId) {
        return recruitStudyRepository.getOne(recruitStudyId);
    }

    @Override
    @Transactional
    public List<RecruitStudy> searchRecruitStudy(int page, Long categoryId, String searchType, String searchStr) {
        int limit = 5;
        int start = page * limit - limit;
        return recruitStudyRepository.getRecruitStudy(categoryId, start, limit, searchType, searchStr);

    }
}
