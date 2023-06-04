package fit.hutech.vuminhkhang.controller;

import fit.hutech.vuminhkhang.model.NhanVien;
import fit.hutech.vuminhkhang.services.NhanVienService;
import fit.hutech.vuminhkhang.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/congty")
public class NhanVienController
{
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String listNhanViens(Model model)
    {
        List<NhanVien> NhanViens = nhanVienService.getAllNV();
        model.addAttribute("listNhanViens", NhanViens);
        model.addAttribute("title", "Danh sach nhan vien");
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model)
    {
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNV(@Valid @ModelAttribute("nhanvien") NhanVien nv, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("phongban", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }

        nhanVienService.addNV(nv);
        return "redirect:/congty";
    }

    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable("id") String id, Model model)
    {
        NhanVien editNV = nhanVienService.getNVById(id);
        if(editNV != null)
        {
            model.addAttribute("nhanvien", editNV);
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien updateNV, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        nhanVienService.updateNV(updateNV);
        return "redirect:/congty";
    }

    @PostMapping("/delete/{id}")
    public String deleteNV(@PathVariable("id") String id)
    {
        nhanVienService.deleteNV(id);
        return "redirect:/congty";
    }
}

