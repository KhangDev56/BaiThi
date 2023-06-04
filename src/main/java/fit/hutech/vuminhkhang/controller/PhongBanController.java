package fit.hutech.vuminhkhang.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fit.hutech.vuminhkhang.model.PhongBan;
import fit.hutech.vuminhkhang.services.PhongBanService;

import java.util.List;

@Controller
@RequestMapping("/phongban")
public class PhongBanController
{
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String listPhongBan(Model model)
    {
        List<PhongBan> phongBan =phongBanService.getAllPhongBan();
        model.addAttribute("phongbans", phongBan);
        model.addAttribute("title", "Danh sach phong ban");
        return "phongban/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model)
    {
        model.addAttribute("phongban", new PhongBan());
        return "phongban/add";
    }

    @PostMapping("/add")
    public String addNV(@Valid @ModelAttribute("phongban") PhongBan phongBan, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "phongban/add";
        }
        phongBanService.addPhongBan(phongBan);
        return "redirect:/phongban";
    }

    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable("id") String id, Model model)
    {
        PhongBan editPhongBan = phongBanService.getPhongBanById(id);
        if(editPhongBan != null)
        {
            model.addAttribute("phongban", editPhongBan);
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "phongban/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editNhanVien(@Valid @ModelAttribute("phongban")PhongBan updatePhongBan, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            return "phongban/edit";
        }
        phongBanService.updatePhongBan(updatePhongBan);
        return "redirect:/phongban";
    }

    @PostMapping("/delete/{id}")
    public String deletePhongBan(@PathVariable("id") String id)
    {
        phongBanService.deletePhongBan(id);
        return "redirect:/phongban";
    }

}
