package com.E_market.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	@Id
	private Long id;
	@NotBlank
	private String name;
	@Column(length = 1000)
	private String description;
	@NotNull
	private String brand;
	@Enumerated(EnumType.STRING)
	private Category category;
	@NotNull
	private Double price;
	@NotNull
	private Integer stock;
	@Lob
	private byte[] image;
	@NotNull
	private Long sellerId;
	

}
