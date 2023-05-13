package com.example.demo.models;

public interface EntityWithIntegerId {
	Long getId();
	
	void setId(Long id);
	
	default boolean isNew() {
		if(getId() == null) {
			return true;
		}else {
			return false;
		}
	}
}
