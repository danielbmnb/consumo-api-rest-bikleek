package co.api.rest.bikleek.dto;

import java.io.Serializable;
import co.api.rest.bikleek.models.Categorias;
import co.api.rest.bikleek.models.Estados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDTO implements Serializable{
	
	private static final long serialVersionUID = -3467294440838294175L;

	private String nombreProducto;
	private String descripcionProducto;
	private Double precio;
	private Long cantidad;
	private Estados estado;
	private Categorias categoria;
	
}
