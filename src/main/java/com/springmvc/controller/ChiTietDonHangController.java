package com.springmvc.controller;

import com.springmvc.beans.ChiTietDonHang;
import com.springmvc.dao.ChiTietDonHangDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chitietdonhang")
public class ChiTietDonHangController {

    @Autowired
    private ChiTietDonHangDao chitietdao;

    @GetMapping("/list")
    public String listChiTietDonHang(Model model) {
        List<ChiTietDonHang> list = chitietdao.getAllChiTietDonHang();
        model.addAttribute("list", list);
        return "chitietdonhang/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("command", new ChiTietDonHang());
        return "chitietdonhang/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("chiTietDonHang") ChiTietDonHang chiTietDonHang) {
    	chitietdao.save(chiTietDonHang);
        return "redirect:/chitietdonhang/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        ChiTietDonHang chiTietDonHang = chitietdao.getChiTietDonHangById(id);
        model.addAttribute("command", chiTietDonHang);
        return "chitietdonhang/edit";
    }

    @PostMapping("/editsave")
    public String editSave(@ModelAttribute("chiTietDonHang") ChiTietDonHang chiTietDonHang) {
    	chitietdao.update(chiTietDonHang);
        return "redirect:/chitietdonhang/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	chitietdao.delete(id);
        return "redirect:/chitietdonhang/list";
    }
}
