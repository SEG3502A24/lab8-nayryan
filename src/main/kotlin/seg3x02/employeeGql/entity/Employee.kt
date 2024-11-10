package seg3x02.employeeGql.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Document(collection = "employee")
data class Employee(
        val name: String,
        val dateOfBirth: String,
        val city: String,
        val salary: Float,
        val gender: String?,
        val email: String?
) {
    @Id
    var id: String = ""
}
@Entity
data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String,
    var position: String,
    var salary: Float
)
