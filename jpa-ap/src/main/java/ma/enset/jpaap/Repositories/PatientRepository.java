package ma.enset.jpaap.Repositories;

import ma.enset.jpaap.Entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByMalade(boolean m);
    public Page<Patient> findByMalade(boolean m, Pageable pageable);
}
