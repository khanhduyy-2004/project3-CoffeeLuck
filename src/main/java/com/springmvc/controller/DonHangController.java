package com.springmvc.controller;

import com.springmvc.beans.DonHang;
import com.springmvc.dao.DonHangDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donhang")
public class DonHangController {

    @Autowired
    private DonHangDao dao;

    @GetMapping("/list")
    public String listDonHang(Model model) {
        List<DonHang> list = dao.getAllDonHang();
        model.addAttribute("list", list);
        return "donhang/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("command", new DonHang());
        return "donhang/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("donHang") DonHang donHang) {
        dao.save(donHang);
        return "redirect:/donhang/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        DonHang donHang = dao.getDonHangById(id);
        model.addAttribute("command", donHang);
        return "donhang/edit";
    }

    @PostMapping("/editsave")
    public String editSave(@ModelAttribute("donHang") DonHang donHang) {
        dao.update(donHang);
        return "redirect:/donhang/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        dao.delete(id);
        return "redirect:/donhang/list";
    }
}
