package io.course.springbootstarter.topic;

import io.course.springbootstarter.dao.TopicRepository;
import io.course.springbootstarter.entity.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	

	public List<Topic> getAllTopics(){
//		return topics;
		List<Topic> topics = new ArrayList<>();
		Iterable<Topic> allTopic = topicRepository.findAll();
		for (Topic topic : allTopic) {
			topics.add(topic);
		}
		return topics;
	}
	
	public Topic getTopic(Long id){
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic){
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(Long id) {
		topicRepository.delete(id);
	}
}
