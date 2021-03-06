package io.course.springbootstarter.dao;

import io.course.springbootstarter.entity.Topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

}
