package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.model.Item;
import com.spring.web.repository.ItemRepository;

@Controller
public class WebController {
	@Autowired
	ItemRepository itemRepository;
	
	// ����Ʈ
	@RequestMapping("/list")
	public String list(ModelMap model){		
		model.addAttribute("list",itemRepository.findAll());
		return "list";
	}
	
	// �۾��� ��
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addPage(){
		return "write";
	}
	
	// �۾��� ó��
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addItem(Item item){
		itemRepository.save(item);
		return "redirect:/list";		
	}
	
	// ����
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable int id){
		itemRepository.delete(id);
		return "redirect:/list";		
	}
	
	// ����ȭ��
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String modifyPage(ModelMap model,@PathVariable int id){
		model.addAttribute("item",itemRepository.findOne(id));
		return "modify";
	}

	// ����
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String modifyProc(ModelMap model,@PathVariable int id,Item item){
		model.addAttribute("item",itemRepository.save(item));
		return "redirect:/" + id;
	}
	
	// �󼼺���
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String detailPage(ModelMap model, @PathVariable int id){
		model.addAttribute("item",itemRepository.findOne(id));
		return "detail";
	}
}
