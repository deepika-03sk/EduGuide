package com.eduguide.eduguide.service;

import com.eduguide.eduguide.dto.CourseDTO;
import com.eduguide.eduguide.dto.FieldDTO;
import com.eduguide.eduguide.dto.StreamDTO;
import com.eduguide.eduguide.model.Course;
import com.eduguide.eduguide.model.Field;
import com.eduguide.eduguide.model.Stream;
import com.eduguide.eduguide.repository.StreamRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StreamService {

    private final StreamRepository streamRepository;

    public StreamService(StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }

    @Transactional(readOnly = true)
    public List<StreamDTO> getAllStreams() {

        return streamRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private StreamDTO convertToDTO(Stream stream) {

        List<FieldDTO> fields = stream.getFields()
                .stream()
                .map(this::convertFieldToDTO)
                .toList();

        return new StreamDTO(
                stream.getId(),
                stream.getName(),
                stream.getDescription(),
                fields
        );
    }

    private FieldDTO convertFieldToDTO(Field field) {

        List<CourseDTO> courses = field.getCourses()
                .stream()
                .map(this::convertCourseToDTO)
                .toList();

        return new FieldDTO(
                field.getId(),
                field.getName(),
                field.getDescription(),
                courses
        );
    }

    private CourseDTO convertCourseToDTO(Course course) {

        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getDuration(),
                course.getEligibility()
        );
    }

    public Stream saveStream(Stream stream) {
        return streamRepository.save(stream);
    }
}