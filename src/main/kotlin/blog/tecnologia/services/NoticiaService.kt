package blog.tecnologia.services

import blog.tecnologia.models.Noticia
import blog.tecnologia.repositories.NoticiaRepository
import org.springframework.stereotype.Service

@Service
class NoticiaService(private val noticiaRepository: NoticiaRepository) {

    fun todasNoticias():
            List<Noticia> = noticiaRepository.findAll()

    fun postagem(noticia: Noticia):Noticia = noticiaRepository.save(noticia)

    fun buscarUm(id:Long): Noticia? = noticiaRepository.findById(id).orElse(null)

    fun atualizar(noticia: Noticia): Noticia = noticiaRepository.save(noticia)

    fun deletar(id: Long) = noticiaRepository.deleteById(id);
}