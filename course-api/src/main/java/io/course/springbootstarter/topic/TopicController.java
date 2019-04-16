package io.course.springbootstarter.topic;

import io.course.springbootstarter.entity.Topic;
import io.course.springbootstarter.hanldeException.ResouceNotFoundException;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	@GetMapping(path="/topics",produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping(path="/topics/{id}")
	public Topic getTopic(@PathVariable Long id){
		Topic topic = topicService.getTopic(id);
		if(topic==null){
			throw new ResouceNotFoundException("Topic with id "+id+" Not Found");
		}
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public ResponseEntity<String> updateTopic(@RequestBody Topic topic,@PathVariable String id){
		topicService.updateTopic(id,topic);
		return new ResponseEntity<String>("Topic with id ="+id+" is updated",HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable Long id){
		 topicService.deleteTopic(id);
	}
}
