package br.com.avenuecode.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1963749493829902691L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String description;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	@Getter @Setter
	private List<Image> images;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="parent_product_id")
	@Getter @Setter
	private List<Product> childProducts;

}
