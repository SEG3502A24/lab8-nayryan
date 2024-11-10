package seg3x02.employeeGql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import seg3x02.entity.Employee
import seg3x02.repository.EmployeeRepository

@Component
class EmployeesResolver(
    private val employeeRepository: EmployeeRepository
) : GraphQLQueryResolver, GraphQLMutationResolver {

    fun getEmployees(): List<Employee> = employeeRepository.findAll()

    fun getEmployee(id: Long): Employee? = employeeRepository.findById(id).orElse(null)

    fun addEmployee(name: String, position: String, salary: Float): Employee {
        val employee = Employee(name = name, position = position, salary = salary)
        return employeeRepository.save(employee)
    }

    fun updateEmployee(id: Long, name: String?, position: String?, salary: Float?): Employee? {
        val employee = employeeRepository.findById(id).orElse(null) ?: return null
        if (name != null) employee.name = name
        if (position != null) employee.position = position
        if (salary != null) employee.salary = salary
        return employeeRepository.save(employee)
    }

    fun deleteEmployee(id: Long): Boolean {
        return if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}

