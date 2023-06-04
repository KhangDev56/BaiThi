package fit.hutech.vuminhkhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fit.hutech.vuminhkhang.model.NhanVien;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, String>
{
}
