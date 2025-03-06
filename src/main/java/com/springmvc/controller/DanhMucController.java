package com.springmvc.controller;

import com.springmvc.beans.DanhMuc;
import com.springmvc.dao.DanhMucDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/danhmuc")
public class DanhMucController {

    @Autowired
    private DanhMucDao dao;

    @GetMapping("/list")
    public String listDanhMuc(Model model) {
        List<DanhMuc> list = dao.getAllDanhMuc();
        model.addAttribute("list", list);
        return "danhmuc/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("command", new DanhMuc());
        return "danhmuc/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("danhMuc") DanhMuc danhMuc) {
        dao.save(danhMuc);
        return "redirect:/danhmuc/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        DanhMuc danhMuc = dao.getDanhMucById(id);
        model.addAttribute("command", danhMuc);
        return "danhmuc/edit";
    }

    @PostMapping("/editsave")
    public String editSave(@ModelAttribute("danhMuc") DanhMuc danhMuc) {
        dao.update(danhMuc);
        return "redirect:/danhmuc/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        dao.delete(id);
        return "redirect:/danhmuc/list";
    }
}
