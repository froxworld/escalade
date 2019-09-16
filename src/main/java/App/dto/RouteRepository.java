package App.dto;

import App.domain.Route;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, Long> {

 Route findByRouteType() ;

}
