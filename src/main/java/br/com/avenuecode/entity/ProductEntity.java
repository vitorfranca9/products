package br.com.avenuecode.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name="PRODUCT")
public class ProductEntity extends BaseEntity {
	private static final long serialVersionUID = 1963749493829902691L;

	@Getter @Setter
	private String name;

	@Getter @Setter
	private String description;

	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	@Getter @Setter
	private List<ImageEntity> images;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="parentProduct")
	@Getter @Setter
	private List<ProductEntity> childProducts;

	@ManyToOne
	@JoinColumn(name="parent_product_id")
	@Getter @Setter
	private ProductEntity parentProduct;

}
