package blog.tecnologia.controllers

import blog.tecnologia.models.Noticia
import blog.tecnologia.services.NoticiaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/noticias")
@Tag(name = "noticias")
class NoticiaController(private val noticiaService: NoticiaService){

    @GetMapping
    fun todasNoticia():ResponseEntity<List<Noticia>> = ResponseEntity.ok(noticiaService.todasNoticias());

    @PostMapping
    fun postagem(@RequestBody noticia: Noticia): ResponseEntity<Noticia> = ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.postagem(noticia));

    @GetMapping("/{id}")
    fun buscaUm(@PathVariable id:Long):ResponseEntity<Noticia> = ResponseEntity.ok(noticiaService.buscarUm(id))

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody noticia: Noticia): ResponseEntity<Noticia> {
        if (noticia.id == id){
            return ResponseEntity.ok(noticiaService.atualizar(noticia))
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void>{
        noticiaService.deletar(id)
        return ResponseEntity.noContent().build()
    }
}