package com.coach.aws.lambda.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * https://blog.tericcabrel.com/using-mongodb-with-spring-boot-project-part-1/
 * 
 * @author Anurag Asthana
 *
 */
public class BaseEntity {
	
	@MongoId
	Long id;

	Date creationTime;
	Date updateTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
}
