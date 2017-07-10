package br.com.avenuecode.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 4182232071566303152L;

	public abstract Serializable getId();
}
