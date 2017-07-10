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
//	@JoinColumn(name="image")
	private List<Image> images;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="parent_product_id")
	@Getter @Setter
	private List<Product> childProducts;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childProducts == null) ? 0 : childProducts.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (childProducts == null) {
			if (other.childProducts != null)
				return false;
		} else if (!childProducts.equals(other.childProducts))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
