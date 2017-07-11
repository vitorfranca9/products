package br.com.avenuecode.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 4182232071566303152L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long id;

}
