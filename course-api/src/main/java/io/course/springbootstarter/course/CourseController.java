package io.course.springbootstarter.course;

import io.course.springbootstarter.entity.Course;
import io.course.springbootstarter.topic.TopicService;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value ="/topics/{id}/courses",produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Course> getAllCourses(@PathVariable Long id){
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{id}/courses/{courseId}")
	public Course getCourse(@PathVariable Long courseId){
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{id}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable Long id){
		course.setTopic(topicService.getTopic(id));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}/courses")
	public void updateCourse(@RequestBody Course course,@PathVariable Long id){
		course.setTopic(topicService.getTopic(id));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable Long id){
		 courseService.deleteCourse(id);
	}
}
