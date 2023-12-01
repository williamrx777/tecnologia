package blog.tecnologia.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data
import java.time.LocalDateTime



@Entity
@Table(name = "noticia")
@Data
data class Noticia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    @Column(length = 255)
    val nome:String,
    @Column(columnDefinition = "TEXT")
    val descricao:String,
    val publicacao: LocalDateTime
)
