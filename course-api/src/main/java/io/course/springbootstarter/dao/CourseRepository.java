package io.course.springbootstarter.dao;

import io.course.springbootstarter.entity.Course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

//	public List<Course> findbByName(String name);
	
	public List<Course> findByTopicId(Long topicId);
}
