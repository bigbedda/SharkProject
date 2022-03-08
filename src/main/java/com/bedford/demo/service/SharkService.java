package com.bedford.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bedford.demo.entity.Shark;
import com.bedford.demo.repo.SharkRepo;


@Service
public class SharkService implements ServiceMethods<Shark> {
	

	private SharkRepo repo;
	

	public SharkService(SharkRepo repo) {
		this.repo=repo;		
	}
		

	@Override
	public Shark create(Shark shark) {
		return this.repo.save(shark);
	}

	@Override
	public List<Shark> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Shark readById(long id) {
		Optional<Shark> getShark = this.repo.findById(id);
		if(getShark.isPresent()) {
			return getShark.get();
		}
		return null;
	}

	
	@Override
	public Shark update(long id, Shark shark) {
		Optional<Shark> existingShark = this.repo.findById(id);
		if(existingShark.isPresent()) {
			Shark exists = existingShark.get();
			exists.setAge(shark.getAge());
			exists.setType(shark.getType());
			exists.setLocation(shark.getLocation());
			exists.setName(shark.getName());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}


	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	
	
}
