package com.barbararibeiro.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbararibeiro.workshopmongo.domain.Post;
import com.barbararibeiro.workshopmongo.resources.util.URL;
import com.barbararibeiro.workshopmongo.servico.PostServico;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostServico servico;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="texto", defaultValue="") String texto) {
		texto = URL.decodeParam(texto);
		List<Post> list = servico.findByTitle(texto);
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> fullSearch(@RequestParam(value="texto", defaultValue="") String texto,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		texto = URL.decodeParam(texto);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = servico.fullSearch(texto, min, max);
		return ResponseEntity.ok().body(list);
	}

}