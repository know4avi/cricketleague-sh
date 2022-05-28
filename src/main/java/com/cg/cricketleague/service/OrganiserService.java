package com.cg.cricketleague.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cricketleague.exception.OrganiserNotFoundException;
import com.cg.cricketleague.model.Organiser;
import com.cg.cricketleague.model.Tournament;
import com.cg.cricketleague.repository.OrganiserRepository;

@Service
public class OrganiserService implements IOrganiserService{
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrganiserRepository organiserRepository;
	
	
	/**
	   * This method is used to find organiser by organiserId. 
	   * @param organiserId This is the only parameter to getMat method.
	   * @return Organiser This returns Organiser object.
	   * @see organiserNotFoundException
	   */
	@Override
	public Organiser getOrgById(int organiserId) {
		LOG.info("OrganiserService getOrgById");
		Optional<Organiser> organiserOptional = organiserRepository.findById(organiserId);
		if (organiserOptional.isPresent()) {
			return organiserOptional.get();
		} else {
			String exceptionMessage = "Organiser with OrganiserId " + organiserId + " does not exist.";
			LOG.warn(exceptionMessage);
			throw new OrganiserNotFoundException(exceptionMessage);
		}
	}
	
	
	/**
	   * This method is used to find all the organisers 
	   * @param 
	   * @return List<Organiser> list of all organisers
	   * @see OrganiserNotFoundException
	   */
	@Override
	public List<Organiser> getAllOrgs() {
		LOG.info("OrganiserService getAllOrgs");
		List<Organiser> organiserList = organiserRepository.findAll();
		if (organiserList.isEmpty()) {
			String exceptionMessage = "No Organisers Found";
			LOG.warn(exceptionMessage);
			throw new OrganiserNotFoundException(exceptionMessage);
		} else {
			return organiserList;
		}
	}
	
	@Override
	public Organiser insertOrg(Organiser organiser) {
		return organiserRepository.save(organiser);
	}
	
	@Override
	public Organiser updateOrg(Organiser organiser) {
		return organiserRepository.save(organiser);
	}
	
	@Override
	public List<Tournament> getToursByOrgId(int organiserId) {
		LOG.info("OrganiserService getToursByOrgId");
		Optional<Organiser> organiserOptional = organiserRepository.findById(organiserId);
		if (organiserOptional.isPresent()) {
			return organiserOptional.get().getTournaments();
		} else {
			String exceptionMessage = "Organiser with OrganiserId " + organiserId + " does not exist.";
			LOG.warn(exceptionMessage);
			throw new OrganiserNotFoundException(exceptionMessage);
		}
	}
}
