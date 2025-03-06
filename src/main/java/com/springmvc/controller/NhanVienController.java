package com.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.springmvc.beans.NhanVien;
import com.springmvc.dao.NhanVienDao;

@Controller
@RequestMapping("/")  // Đổi từ "/nhanvien" sang "/" để dễ gọi menu
public class NhanVienController {
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, true));
    }
    
    @Autowired  
    private NhanVienDao dao;
    
    // Trang chính chuyển hướng đến menu
    @GetMapping("/")
    public String home() {
        return "redirect:/menu";
    }

    // Hiển thị menu chính
    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }

    // Hiển thị form thêm nhân viên
    @GetMapping("/nhanvien/form")
    public String showForm(Model model) {
        model.addAttribute("command", new NhanVien());
        return "save";
    }

    // Lưu nhân viên vào database
    @PostMapping("/nhanvien/save")
    public String save(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        dao.save(nhanVien);
        return "redirect:/nhanvien/view";
    }

    // Hiển thị danh sách nhân viên
    @GetMapping("/nhanvien/list")
    public String listNhanVien(Model model) {
        List<NhanVien> listnv = dao.getAllNhanVien();
        model.addAttribute("list", listnv);
        return "nhanvien/list";
    }

    // Hiển thị form chỉnh sửa thông tin nhân viên
    @GetMapping("/nhanvien/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        NhanVien nhanVien = dao.getNhanVienById(id);
        model.addAttribute("command", nhanVien);
        return "edit";
    }

    // Lưu chỉnh sửa thông tin nhân viên
    @PostMapping("/nhanvien/editsave")
    public String editSave(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        dao.update(nhanVien);
        return "redirect:/nhanvien/view";
    }

    // Xóa nhân viên theo ID
    @GetMapping("/nhanvien/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        dao.delete(id);
        return "redirect:/nhanvien/view";
    }
}
