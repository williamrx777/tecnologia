package blog.tecnologia.repositories

import blog.tecnologia.models.Noticia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoticiaRepository : JpaRepository<Noticia, Long> {
}