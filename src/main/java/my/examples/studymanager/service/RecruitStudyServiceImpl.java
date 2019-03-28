package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.RecruitStudy;
import my.examples.studymanager.dto.RecruitStudyDto;
import my.examples.studymanager.repository.CategoryRepository;
import my.examples.studymanager.repository.RecruitStudyRepository;
import my.examples.studymanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitStudyServiceImpl implements RecruitStudyService {
    private final RecruitStudyRepository recruitStudyRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

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
            recruitStudy.setLocation(recruitStudyDto.getLocation());
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
        return null;
    }
}
