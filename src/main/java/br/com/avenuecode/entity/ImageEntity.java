package br.com.avenuecode.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="IMAGE")
public class ImageEntity extends BaseEntity {
	private static final long serialVersionUID = 2104348246600459160L;

	@Lob
	@Getter @Setter
	private byte[] image;

	@ManyToOne
	@JoinColumn(name="product_id")
	@Getter @Setter
	private ProductEntity product;

}
