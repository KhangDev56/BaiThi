package fit.hutech.vuminhkhang.repository;

import fit.hutech.vuminhkhang.model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, String>
{
}
