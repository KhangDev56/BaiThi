package fit.hutech.vuminhkhang.services;

import fit.hutech.vuminhkhang.model.NhanVien;
import fit.hutech.vuminhkhang.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService //
{
    @Autowired
    private INhanVienRepository nhanVienRepository;

    //@Override
    public List<NhanVien> getAllNV()
    {
        return nhanVienRepository.findAll();
    }

    //@Override
    public NhanVien getNVById(String id)
    {
        Optional<NhanVien> optionalNV = nhanVienRepository.findById(id);
        return optionalNV.orElse(null);
    }

    //@Override
    public void saveNV(NhanVien nhanVien)
    {
        this.nhanVienRepository.save(nhanVien);
    }

    //@Override
    public void addNV(NhanVien newnv){
        nhanVienRepository.save(newnv);
    }
    //@Override
    public void updateNV(NhanVien newnv){
        nhanVienRepository.save(newnv);
    }
    //@Override
    public void deleteNV(String id){
        nhanVienRepository.deleteById(id);
    }

//    @Override
//    public Page <NhanVien> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
//        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
//                Sort.by(sortField).descending();
//
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//        return this.nhanVienRepository.findAll(pageable);
//    }

}
