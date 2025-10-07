package excursionweb.modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import excursionweb.modelo.javabean.Excursion;

@Repository
public class ExcursionDaoImplList implements ExcursionDao{
	private List<Excursion> lista;
	
	public ExcursionDaoImplList() {
		lista = new ArrayList<>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		lista.add(new Excursion(1, "Viaje a la playa", "Sevilla", "Malaga", 1, "CREADO", "S", 60, 50, 20, "playa", LocalDate.of(2025, 06, 9), LocalDate.of(2025, 03, 1) ));
		lista.add(new Excursion(2, "Viaje a la nieve", "Sevilla", "Granada", 2, "CREADO", "S", 80, 60, 30, "nieve", LocalDate.of(2024, 06, 12), LocalDate.of(2024, 06, 1)));
		lista.add(new Excursion(3, "Viaje a la Mezquita", "Malaga", "Cordoba", 1, "CREADO", "S", 40, 30, 15, "mezquita", LocalDate.of(2025, 05, 14), LocalDate.of(2025, 05, 13) ));
		lista.add(new Excursion(4, "Viaje al Bernabeu", "Malaga", "Madrid", 2, "CANCELADO", "N", 50, 40, 150, "bernabeu", LocalDate.of(2024, 10, 26), LocalDate.of(2024, 10, 20) ));
		lista.add(new Excursion(5, "Viaje a Italia", "Sevilla", "Roma", 3, "TERMINADO", "N", 100, 80, 300, "coliseo", LocalDate.of(2024, 8, 10), LocalDate.of(2024, 8, 9) ));
	}

	
	public Excursion findById(int idExcursion) {
		for (Excursion ele: lista) {
			if (ele.getIdExcursion() == idExcursion)
				return ele;
		}
		return null;
	}

	@Override
	public List<Excursion> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public int insertOne(Excursion excursion) {
		if (lista.contains(excursion))
		return 0;
		return lista.add(excursion) ? 1 : 0;
	}
	 /*El método inserOne si la lista contiene la excursión no
	  puedo dar de alta pq ya está añadida, sino añade una nueva
     */
	@Override
	public int updateOne(Excursion excursion) {
		int pos = lista.indexOf(excursion);
		
		if (pos == -1)
			return 0;
		return (lista.set(pos, excursion) != null) ? 1 : 0;
		
	/*	if (lista.set(pos, excursion) !=)
			return 1;
		else          /esto es lo mismo que el método anterior
			return 0;
	*/ 
	}

	@Override
	public List<Excursion> findByCreados() {
		List<Excursion> listaCreados = new ArrayList<>();
		for (Excursion ele:lista) {
			if (ele.getEstado().equals("CREADO")) {
				listaCreados.add(ele);
			}
		}
			
		return listaCreados;
	}

	@Override
	public List<Excursion> findByTerminados() {
		List<Excursion> listaTerminados = new ArrayList<>();
		for (Excursion ele:lista) {
			if (ele.getEstado().equals("TERMINADO")) {
				listaTerminados.add(ele);  
			}
		}
		return listaTerminados;
	}

	@Override
	public List<Excursion> findByDestacados() {
		List<Excursion> listadestacados = new ArrayList<>();
		for (Excursion ele:lista) {
			if (ele.getDestacado().equals("S")) {
				listadestacados.add(ele);
			}
		}
			
		return listadestacados;
	}

	
	

}
