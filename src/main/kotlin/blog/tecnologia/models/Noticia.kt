package blog.tecnologia.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data
import java.time.LocalDateTime



@Entity
@Table(name = "noticias")
@Data
data class Noticia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val nome:String,
    val descricao:String,
    val publicacao: LocalDateTime
)
