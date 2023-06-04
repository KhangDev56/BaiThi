package fit.hutech.vuminhkhang.services;

import fit.hutech.vuminhkhang.model.NhanVien;
import fit.hutech.vuminhkhang.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService
{
    @Autowired
    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllNV(){
        return nhanVienRepository.findAll();
    }
    public NhanVien getNVById(String id){
        Optional<NhanVien> optionalNV = nhanVienRepository.findById(id);
        return optionalNV.orElse(null);
    }
    public void addNV(NhanVien newnv){
        nhanVienRepository.save(newnv);
    }
    public void updateNV(NhanVien newnv){
        nhanVienRepository.save(newnv);
    }
    public void deleteNV(String id){
        nhanVienRepository.deleteById(id);
    }
}
