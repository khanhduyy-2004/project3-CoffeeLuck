package com.springmvc.controller;

import com.springmvc.beans.NguoiDung;
import com.springmvc.dao.NguoiDungDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nguoidung")
public class NguoiDungController {

    @Autowired
    private NguoiDungDao nguoidungdao;

    @GetMapping("/list")
    public String listNguoiDung(Model model) {
        List<NguoiDung> list = nguoidungdao.getAllNguoiDung();
        model.addAttribute("list", list);
        return "nguoidung/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("command", new NguoiDung());
        return "nguoidung/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("nguoiDung") NguoiDung nguoiDung) {
    	nguoidungdao.save(nguoiDung);
        return "redirect:/nguoidung/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        NguoiDung nguoiDung = nguoidungdao.getNguoiDungById(id);
        model.addAttribute("command", nguoiDung);
        return "nguoidung/edit";
    }

    @PostMapping("/editsave")
    public String editSave(@ModelAttribute("nguoiDung") NguoiDung nguoiDung) {
    	nguoidungdao.update(nguoiDung);
        return "redirect:/nguoidung/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	nguoidungdao.delete(id);
        return "redirect:/nguoidung/list";
    }
}
