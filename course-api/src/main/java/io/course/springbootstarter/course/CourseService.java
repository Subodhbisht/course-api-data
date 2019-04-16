package io.course.springbootstarter.course;

import io.course.springbootstarter.dao.CourseRepository;
import io.course.springbootstarter.entity.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	

	public List<Course> getAllCourses(Long topicId){
//		return topics;
		List<Course> topics = new ArrayList<>();
		Iterable<Course> allTopic = courseRepository.findByTopicId(topicId);
		for (Course topic : allTopic) {
			topics.add(topic);
		}
		return topics;
	}
	
	public Course getCourse(Long id){
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course topic){
		courseRepository.save(topic);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(Long id) {
		courseRepository.delete(id);
	}
}
