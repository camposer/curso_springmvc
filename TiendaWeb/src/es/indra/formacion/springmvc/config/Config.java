package es.indra.formacion.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.indra.formacion.springmvc.dao.IProductoDao;
import es.indra.formacion.springmvc.dao.ProductoDao;
import es.indra.formacion.springmvc.service.IProductoService;
import es.indra.formacion.springmvc.service.ProductoService;

@Configuration
public class Config {

	@Bean
	public IProductoDao productoDao() {
		return new ProductoDao();
	}
	
	@Bean(initMethod="init")
	public IProductoService productoService() {
		return new ProductoService();
	}
}
