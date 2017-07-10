package br.com.avenuecode.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Image extends BaseEntity {
	private static final long serialVersionUID = 2104348246600459160L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Lob
	@Getter @Setter
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	@Getter @Setter
	private Product product;
	
	@Override
	public Serializable getId() {
		return id;
	}

}
