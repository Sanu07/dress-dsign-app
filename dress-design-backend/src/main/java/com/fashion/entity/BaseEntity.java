package com.fashion.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "_ID", columnDefinition = "BINARY(16)")
	private UUID id;
	
	@Column(name = "IS_ACTIVE")
	private Boolean status;
	
	@CreationTimestamp
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "LAST_UPDATED_AT")
	private LocalDateTime updatedAt;
	
	@Version
	private int version;
	
	@PrePersist
	private void prePersist() {
		if (this.status == null) {
			this.status = true;
		}
	}
}
