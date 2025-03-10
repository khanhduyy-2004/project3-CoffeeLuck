package com.springmvc.controller;

import com.springmvc.beans.SanPham;
import com.springmvc.dao.SanPhamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamDao sanphamdao;

    @GetMapping("/list")
    public String listSanPham(Model model) {
        List<SanPham> list = sanphamdao.getAllSanPham();
        model.addAttribute("list", list);
        return "sanpham/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("command", new SanPham());
        return "sanpham/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("sanPham") SanPham sanPham) {
    	sanphamdao.save(sanPham);
        return "redirect:/sanpham/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        SanPham sanPham = sanphamdao.getSanPhamById(id);
        model.addAttribute("command", sanPham);
        return "sanpham/edit";
    }

    @PostMapping("/editsave")
    public String editSave(@ModelAttribute("sanPham") SanPham sanPham) {
    	sanphamdao.update(sanPham);
        return "redirect:/sanpham/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	sanphamdao.delete(id);
        return "redirect:/sanpham/list";
    }
    
}
