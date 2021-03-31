package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Override
	public List<String> loadMenu() {
		List<String> menuS = new ArrayList<String>();
		menuS.add("fuck");
		menuS.add("ahihi");
		menuS.add("ahuhu");
		menuS.add("a fuck this bitch");
		return menuS;
	}

}
