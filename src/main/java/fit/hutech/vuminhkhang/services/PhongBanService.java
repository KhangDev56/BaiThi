package fit.hutech.vuminhkhang.services;

import fit.hutech.vuminhkhang.model.PhongBan;
import fit.hutech.vuminhkhang.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService
{
    @Autowired
    private IPhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }

    public PhongBan getPhongBanById(String id)
    {
        Optional<PhongBan> optionalPhongBan = phongBanRepository.findById(id);
        if(optionalPhongBan.isPresent())
        {
            return optionalPhongBan.get();
        }else {
            throw new RuntimeException("Phong ban khong tim thay !!!");
        }
    }

    public void addPhongBan(PhongBan newPhongBan){
        phongBanRepository.save(newPhongBan);
    }
    public PhongBan savePhongBan(PhongBan phongBan) { return phongBanRepository.save(phongBan);}
    public void updatePhongBan(PhongBan phongBan){
        phongBanRepository.save(phongBan);
    }
    public void deletePhongBan(String id) {phongBanRepository.deleteById(id);}
}
