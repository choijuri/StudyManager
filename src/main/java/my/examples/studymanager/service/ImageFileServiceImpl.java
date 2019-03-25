package my.examples.studymanager.service;

import lombok.RequiredArgsConstructor;
import my.examples.studymanager.domain.ImageFile;
import my.examples.studymanager.repository.ImageFileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService {
    private final ImageFileRepository imageFileRepository;

    @Override
    public List<ImageFile> getImageFiles(Long studyContentId) {
        return null;
    }
}
